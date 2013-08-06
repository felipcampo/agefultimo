package jsf;

import jpa.entities.PlanesMejoramiento;
import jsf.util.JsfUtil;
import jpa.sessions.PlanesMejoramientoFacade;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "planesMejoramientoController")
@SessionScoped
public class PlanesMejoramientoController implements Serializable {

    private PlanesMejoramiento current;
    private LazyDataModel<PlanesMejoramiento> lazyModel = null;
    @EJB
    private jpa.sessions.PlanesMejoramientoFacade ejbFacade;

    public PlanesMejoramientoController() {
    }

    public PlanesMejoramiento getSelected() {
        if (current == null) {
            current = new PlanesMejoramiento();
        }
        return current;
    }

    public void setSelected(PlanesMejoramiento entity) {
        current = entity;
    }

    private PlanesMejoramientoFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<PlanesMejoramiento> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<PlanesMejoramiento>() {
                @Override
                public List<PlanesMejoramiento> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<PlanesMejoramiento> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(PlanesMejoramiento entity) {
                    return entity.getCodPlaMej();
                }

                @Override
                public PlanesMejoramiento getRowData(String rowKey) {
                    try {
                        return getFacade().find(rowKey);
                    } catch (Exception e) {
                        return null;
                    }
                }
            };
            lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
        }
        return lazyModel;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (PlanesMejoramiento) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new PlanesMejoramiento();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("PlanesMejoramientoCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (PlanesMejoramiento) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("PlanesMejoramientoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        performDestroy();
        recreateModel();
        return "List";
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("PlanesMejoramientoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void recreateModel() {
        lazyModel = null;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = PlanesMejoramiento.class)
    public static class PlanesMejoramientoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PlanesMejoramientoController controller = (PlanesMejoramientoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "planesMejoramientoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PlanesMejoramiento) {
                PlanesMejoramiento o = (PlanesMejoramiento) object;
                return getStringKey(o.getCodPlaMej());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + PlanesMejoramiento.class.getName());
            }
        }
    }
}
