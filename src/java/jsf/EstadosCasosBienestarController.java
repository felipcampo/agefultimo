package jsf;

import jpa.entities.EstadosCasosBienestar;
import jsf.util.JsfUtil;
import jpa.sessions.EstadosCasosBienestarFacade;

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

@ManagedBean(name = "estadosCasosBienestarController")
@SessionScoped
public class EstadosCasosBienestarController implements Serializable {

    private EstadosCasosBienestar current;
    private LazyDataModel<EstadosCasosBienestar> lazyModel = null;
    @EJB
    private jpa.sessions.EstadosCasosBienestarFacade ejbFacade;

    public EstadosCasosBienestarController() {
    }

    public EstadosCasosBienestar getSelected() {
        if (current == null) {
            current = new EstadosCasosBienestar();
        }
        return current;
    }

    public void setSelected(EstadosCasosBienestar entity) {
        current = entity;
    }

    private EstadosCasosBienestarFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<EstadosCasosBienestar> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<EstadosCasosBienestar>() {
                @Override
                public List<EstadosCasosBienestar> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<EstadosCasosBienestar> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(EstadosCasosBienestar entity) {
                    return entity.getCodEstBie();
                }

                @Override
                public EstadosCasosBienestar getRowData(String rowKey) {
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
        current = (EstadosCasosBienestar) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new EstadosCasosBienestar();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosCasosBienestarCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EstadosCasosBienestar) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosCasosBienestarUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosCasosBienestarDeleted"));
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

    @FacesConverter(forClass = EstadosCasosBienestar.class)
    public static class EstadosCasosBienestarControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstadosCasosBienestarController controller = (EstadosCasosBienestarController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estadosCasosBienestarController");
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
            if (object instanceof EstadosCasosBienestar) {
                EstadosCasosBienestar o = (EstadosCasosBienestar) object;
                return getStringKey(o.getCodEstBie());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EstadosCasosBienestar.class.getName());
            }
        }
    }
}
