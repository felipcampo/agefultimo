package jsf;

import jpa.entities.CriteriosSeguimientoInstructores;
import jsf.util.JsfUtil;
import jpa.sessions.CriteriosSeguimientoInstructoresFacade;

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

@ManagedBean(name = "criteriosSeguimientoInstructoresController")
@SessionScoped
public class CriteriosSeguimientoInstructoresController implements Serializable {

    private CriteriosSeguimientoInstructores current;
    private LazyDataModel<CriteriosSeguimientoInstructores> lazyModel = null;
    @EJB
    private jpa.sessions.CriteriosSeguimientoInstructoresFacade ejbFacade;

    public CriteriosSeguimientoInstructoresController() {
    }

    public CriteriosSeguimientoInstructores getSelected() {
        if (current == null) {
            current = new CriteriosSeguimientoInstructores();
        }
        return current;
    }

    public void setSelected(CriteriosSeguimientoInstructores entity) {
        current = entity;
    }

    private CriteriosSeguimientoInstructoresFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<CriteriosSeguimientoInstructores> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<CriteriosSeguimientoInstructores>() {
                @Override
                public List<CriteriosSeguimientoInstructores> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<CriteriosSeguimientoInstructores> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(CriteriosSeguimientoInstructores entity) {
                    return entity.getCodSeg();
                }

                @Override
                public CriteriosSeguimientoInstructores getRowData(String rowKey) {
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
        current = (CriteriosSeguimientoInstructores) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new CriteriosSeguimientoInstructores();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriteriosSeguimientoInstructoresCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (CriteriosSeguimientoInstructores) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriteriosSeguimientoInstructoresUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriteriosSeguimientoInstructoresDeleted"));
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

    @FacesConverter(forClass = CriteriosSeguimientoInstructores.class)
    public static class CriteriosSeguimientoInstructoresControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CriteriosSeguimientoInstructoresController controller = (CriteriosSeguimientoInstructoresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "criteriosSeguimientoInstructoresController");
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
            if (object instanceof CriteriosSeguimientoInstructores) {
                CriteriosSeguimientoInstructores o = (CriteriosSeguimientoInstructores) object;
                return getStringKey(o.getCodSeg());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + CriteriosSeguimientoInstructores.class.getName());
            }
        }
    }
}
