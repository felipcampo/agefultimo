package jsf;

import jpa.entities.SubactividadesProyecto;
import jsf.util.JsfUtil;
import jpa.sessions.SubactividadesProyectoFacade;

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

@ManagedBean(name = "subactividadesProyectoController")
@SessionScoped
public class SubactividadesProyectoController implements Serializable {

    private SubactividadesProyecto current;
    private LazyDataModel<SubactividadesProyecto> lazyModel = null;
    @EJB
    private jpa.sessions.SubactividadesProyectoFacade ejbFacade;

    public SubactividadesProyectoController() {
    }

    public SubactividadesProyecto getSelected() {
        if (current == null) {
            current = new SubactividadesProyecto();
        }
        return current;
    }

    public void setSelected(SubactividadesProyecto entity) {
        current = entity;
    }

    private SubactividadesProyectoFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<SubactividadesProyecto> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<SubactividadesProyecto>() {
                @Override
                public List<SubactividadesProyecto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<SubactividadesProyecto> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(SubactividadesProyecto entity) {
                    return entity.getCodSubPro();
                }

                @Override
                public SubactividadesProyecto getRowData(String rowKey) {
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
        current = (SubactividadesProyecto) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new SubactividadesProyecto();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SubactividadesProyectoCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (SubactividadesProyecto) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SubactividadesProyectoUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SubactividadesProyectoDeleted"));
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

    @FacesConverter(forClass = SubactividadesProyecto.class)
    public static class SubactividadesProyectoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SubactividadesProyectoController controller = (SubactividadesProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "subactividadesProyectoController");
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
            if (object instanceof SubactividadesProyecto) {
                SubactividadesProyecto o = (SubactividadesProyecto) object;
                return getStringKey(o.getCodSubPro());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + SubactividadesProyecto.class.getName());
            }
        }
    }
}
