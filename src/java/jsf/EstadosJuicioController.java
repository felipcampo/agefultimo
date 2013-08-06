package jsf;

import jpa.entities.EstadosJuicio;
import jsf.util.JsfUtil;
import jpa.sessions.EstadosJuicioFacade;

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

@ManagedBean(name = "estadosJuicioController")
@SessionScoped
public class EstadosJuicioController implements Serializable {

    private EstadosJuicio current;
    private LazyDataModel<EstadosJuicio> lazyModel = null;
    @EJB
    private jpa.sessions.EstadosJuicioFacade ejbFacade;

    public EstadosJuicioController() {
    }

    public EstadosJuicio getSelected() {
        if (current == null) {
            current = new EstadosJuicio();
        }
        return current;
    }

    public void setSelected(EstadosJuicio entity) {
        current = entity;
    }

    private EstadosJuicioFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<EstadosJuicio> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<EstadosJuicio>() {
                @Override
                public List<EstadosJuicio> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<EstadosJuicio> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(EstadosJuicio entity) {
                    return entity.getIdEstadosJuicio();
                }

                @Override
                public EstadosJuicio getRowData(String rowKey) {
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
        current = (EstadosJuicio) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new EstadosJuicio();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosJuicioCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EstadosJuicio) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosJuicioUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosJuicioDeleted"));
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

    @FacesConverter(forClass = EstadosJuicio.class)
    public static class EstadosJuicioControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstadosJuicioController controller = (EstadosJuicioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estadosJuicioController");
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
            if (object instanceof EstadosJuicio) {
                EstadosJuicio o = (EstadosJuicio) object;
                return getStringKey(o.getCodEstJui());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EstadosJuicio.class.getName());
            }
        }
    }
}
