package jsf;

import jpa.entities.SeguimientoInstructores;
import jsf.util.JsfUtil;
import jpa.sessions.SeguimientoInstructoresFacade;

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

@ManagedBean(name = "seguimientoInstructoresController")
@SessionScoped
public class SeguimientoInstructoresController implements Serializable {

    private SeguimientoInstructores current;
    private LazyDataModel<SeguimientoInstructores> lazyModel = null;
    @EJB
    private jpa.sessions.SeguimientoInstructoresFacade ejbFacade;

    public SeguimientoInstructoresController() {
    }

    public SeguimientoInstructores getSelected() {
        if (current == null) {
            current = new SeguimientoInstructores();
        }
        return current;
    }

    public void setSelected(SeguimientoInstructores entity) {
        current = entity;
    }

    private SeguimientoInstructoresFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<SeguimientoInstructores> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<SeguimientoInstructores>() {
                @Override
                public List<SeguimientoInstructores> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<SeguimientoInstructores> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(SeguimientoInstructores entity) {
                    return entity.getCodSegIns();
                }

                @Override
                public SeguimientoInstructores getRowData(String rowKey) {
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
        current = (SeguimientoInstructores) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new SeguimientoInstructores();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoInstructoresCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (SeguimientoInstructores) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoInstructoresUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoInstructoresDeleted"));
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

    @FacesConverter(forClass = SeguimientoInstructores.class)
    public static class SeguimientoInstructoresControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SeguimientoInstructoresController controller = (SeguimientoInstructoresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "seguimientoInstructoresController");
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
            if (object instanceof SeguimientoInstructores) {
                SeguimientoInstructores o = (SeguimientoInstructores) object;
                return getStringKey(o.getCodSegIns());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + SeguimientoInstructores.class.getName());
            }
        }
    }
}
