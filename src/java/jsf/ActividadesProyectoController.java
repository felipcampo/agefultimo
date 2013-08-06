package jsf;

import jpa.entities.ActividadesProyecto;
import jsf.util.JsfUtil;
import jpa.sessions.ActividadesProyectoFacade;

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

@ManagedBean(name = "actividadesProyectoController")
@SessionScoped
public class ActividadesProyectoController implements Serializable {

    private ActividadesProyecto current;
    private LazyDataModel<ActividadesProyecto> lazyModel = null;
    @EJB
    private jpa.sessions.ActividadesProyectoFacade ejbFacade;

    public ActividadesProyectoController() {
    }

    public ActividadesProyecto getSelected() {
        if (current == null) {
            current = new ActividadesProyecto();
        }
        return current;
    }

    public void setSelected(ActividadesProyecto entity) {
        current = entity;
    }

    private ActividadesProyectoFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<ActividadesProyecto> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<ActividadesProyecto>() {
                @Override
                public List<ActividadesProyecto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<ActividadesProyecto> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(ActividadesProyecto entity) {
                    return entity.getCodActPro();
                }

                @Override
                public ActividadesProyecto getRowData(String rowKey) {
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
        current = (ActividadesProyecto) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new ActividadesProyecto();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ActividadesProyectoCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ActividadesProyecto) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ActividadesProyectoUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ActividadesProyectoDeleted"));
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

    @FacesConverter(forClass = ActividadesProyecto.class)
    public static class ActividadesProyectoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActividadesProyectoController controller = (ActividadesProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "actividadesProyectoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ActividadesProyecto) {
                ActividadesProyecto o = (ActividadesProyecto) object;
                return getStringKey(o.getCodActPro());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ActividadesProyecto.class.getName());
            }
        }
    }
}
