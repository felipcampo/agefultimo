package jsf;

import jpa.entities.EstadosAspirantes;
import jsf.util.JsfUtil;
import jpa.sessions.EstadosAspirantesFacade;

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

@ManagedBean(name = "estadosAspirantesController")
@SessionScoped
public class EstadosAspirantesController implements Serializable {

    private EstadosAspirantes current;
    private LazyDataModel<EstadosAspirantes> lazyModel = null;
    @EJB
    private jpa.sessions.EstadosAspirantesFacade ejbFacade;

    public EstadosAspirantesController() {
    }

    public EstadosAspirantes getSelected() {
        if (current == null) {
            current = new EstadosAspirantes();
        }
        return current;
    }

    public void setSelected(EstadosAspirantes entity) {
        current = entity;
    }

    private EstadosAspirantesFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<EstadosAspirantes> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<EstadosAspirantes>() {
                @Override
                public List<EstadosAspirantes> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<EstadosAspirantes> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(EstadosAspirantes entity) {
                    return entity.getIdEstAsp();
                }

                @Override
                public EstadosAspirantes getRowData(String rowKey) {
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
        current = (EstadosAspirantes) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new EstadosAspirantes();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosAspirantesCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EstadosAspirantes) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosAspirantesUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosAspirantesDeleted"));
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

    @FacesConverter(forClass = EstadosAspirantes.class)
    public static class EstadosAspirantesControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstadosAspirantesController controller = (EstadosAspirantesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estadosAspirantesController");
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
            if (object instanceof EstadosAspirantes) {
                EstadosAspirantes o = (EstadosAspirantes) object;
                return getStringKey(o.getIdEstAsp());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EstadosAspirantes.class.getName());
            }
        }
    }
}
