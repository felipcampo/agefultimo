package jsf;

import jpa.entities.EvidenciasAprendizaje;
import jsf.util.JsfUtil;
import jpa.sessions.EvidenciasAprendizajeFacade;

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

@ManagedBean(name = "evidenciasAprendizajeController")
@SessionScoped
public class EvidenciasAprendizajeController implements Serializable {

    private EvidenciasAprendizaje current;
    private LazyDataModel<EvidenciasAprendizaje> lazyModel = null;
    @EJB
    private jpa.sessions.EvidenciasAprendizajeFacade ejbFacade;

    public EvidenciasAprendizajeController() {
    }

    public EvidenciasAprendizaje getSelected() {
        if (current == null) {
            current = new EvidenciasAprendizaje();
        }
        return current;
    }

    public void setSelected(EvidenciasAprendizaje entity) {
        current = entity;
    }

    private EvidenciasAprendizajeFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<EvidenciasAprendizaje> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<EvidenciasAprendizaje>() {
                @Override
                public List<EvidenciasAprendizaje> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<EvidenciasAprendizaje> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(EvidenciasAprendizaje entity) {
                    return entity.getIdEvidenciasAprendizaje();
                }

                @Override
                public EvidenciasAprendizaje getRowData(String rowKey) {
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
        current = (EvidenciasAprendizaje) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new EvidenciasAprendizaje();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvidenciasAprendizajeCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EvidenciasAprendizaje) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvidenciasAprendizajeUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvidenciasAprendizajeDeleted"));
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

    @FacesConverter(forClass = EvidenciasAprendizaje.class)
    public static class EvidenciasAprendizajeControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EvidenciasAprendizajeController controller = (EvidenciasAprendizajeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "evidenciasAprendizajeController");
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
            if (object instanceof EvidenciasAprendizaje) {
                EvidenciasAprendizaje o = (EvidenciasAprendizaje) object;
                return getStringKey(o.getCodEviApr());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EvidenciasAprendizaje.class.getName());
            }
        }
    }
}
