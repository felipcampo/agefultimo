package jsf;

import jpa.entities.CentrosFormacion;
import jsf.util.JsfUtil;
import jpa.sessions.CentrosFormacionFacade;

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

@ManagedBean(name = "centrosFormacionController")
@SessionScoped
public class CentrosFormacionController implements Serializable {

    private CentrosFormacion current;
    private LazyDataModel<CentrosFormacion> lazyModel = null;
    @EJB
    private jpa.sessions.CentrosFormacionFacade ejbFacade;

    public CentrosFormacionController() {
    }

    public CentrosFormacion getSelected() {
        if (current == null) {
            current = new CentrosFormacion();
        }
        return current;
    }

    public void setSelected(CentrosFormacion entity) {
        current = entity;
    }

    private CentrosFormacionFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<CentrosFormacion> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<CentrosFormacion>() {
                @Override
                public List<CentrosFormacion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<CentrosFormacion> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(CentrosFormacion entity) {
                    return entity.getIdCentrosFormacion();
                }

                @Override
                public CentrosFormacion getRowData(String rowKey) {
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
        current = (CentrosFormacion) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new CentrosFormacion();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CentrosFormacionCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (CentrosFormacion) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CentrosFormacionUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CentrosFormacionDeleted"));
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

    @FacesConverter(forClass = CentrosFormacion.class)
    public static class CentrosFormacionControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CentrosFormacionController controller = (CentrosFormacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "centrosFormacionController");
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
            if (object instanceof CentrosFormacion) {
                CentrosFormacion o = (CentrosFormacion) object;
                return getStringKey(o.getCodCen());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + CentrosFormacion.class.getName());
            }
        }
    }
}
