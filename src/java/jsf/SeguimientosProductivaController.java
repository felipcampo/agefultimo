package jsf;

import jpa.entities.SeguimientosProductiva;
import jsf.util.JsfUtil;
import jpa.sessions.SeguimientosProductivaFacade;

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

@ManagedBean(name = "seguimientosProductivaController")
@SessionScoped
public class SeguimientosProductivaController implements Serializable {

    private SeguimientosProductiva current;
    private LazyDataModel<SeguimientosProductiva> lazyModel = null;
    @EJB
    private jpa.sessions.SeguimientosProductivaFacade ejbFacade;

    public SeguimientosProductivaController() {
    }

    public SeguimientosProductiva getSelected() {
        if (current == null) {
            current = new SeguimientosProductiva();
        }
        return current;
    }

    public void setSelected(SeguimientosProductiva entity) {
        current = entity;
    }

    private SeguimientosProductivaFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<SeguimientosProductiva> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<SeguimientosProductiva>() {
                @Override
                public List<SeguimientosProductiva> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<SeguimientosProductiva> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(SeguimientosProductiva entity) {
                    return entity.getIdSeguimientosProductiva();
                }

                @Override
                public SeguimientosProductiva getRowData(String rowKey) {
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
        current = (SeguimientosProductiva) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new SeguimientosProductiva();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientosProductivaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (SeguimientosProductiva) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientosProductivaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientosProductivaDeleted"));
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

    @FacesConverter(forClass = SeguimientosProductiva.class)
    public static class SeguimientosProductivaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SeguimientosProductivaController controller = (SeguimientosProductivaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "seguimientosProductivaController");
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
            if (object instanceof SeguimientosProductiva) {
                SeguimientosProductiva o = (SeguimientosProductiva) object;
                return getStringKey(o.getCodSegPro());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + SeguimientosProductiva.class.getName());
            }
        }
    }
}
