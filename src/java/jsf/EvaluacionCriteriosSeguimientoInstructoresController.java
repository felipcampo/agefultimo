package jsf;

import jpa.entities.EvaluacionCriteriosSeguimientoInstructores;
import jsf.util.JsfUtil;
import jpa.sessions.EvaluacionCriteriosSeguimientoInstructoresFacade;

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

@ManagedBean(name = "evaluacionCriteriosSeguimientoInstructoresController")
@SessionScoped
public class EvaluacionCriteriosSeguimientoInstructoresController implements Serializable {

    private EvaluacionCriteriosSeguimientoInstructores current;
    private LazyDataModel<EvaluacionCriteriosSeguimientoInstructores> lazyModel = null;
    @EJB
    private jpa.sessions.EvaluacionCriteriosSeguimientoInstructoresFacade ejbFacade;

    public EvaluacionCriteriosSeguimientoInstructoresController() {
    }

    public EvaluacionCriteriosSeguimientoInstructores getSelected() {
        if (current == null) {
            current = new EvaluacionCriteriosSeguimientoInstructores();
        }
        return current;
    }

    public void setSelected(EvaluacionCriteriosSeguimientoInstructores entity) {
        current = entity;
    }

    private EvaluacionCriteriosSeguimientoInstructoresFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<EvaluacionCriteriosSeguimientoInstructores> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<EvaluacionCriteriosSeguimientoInstructores>() {
                @Override
                public List<EvaluacionCriteriosSeguimientoInstructores> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<EvaluacionCriteriosSeguimientoInstructores> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(EvaluacionCriteriosSeguimientoInstructores entity) {
                    return entity.getCodEvaCriIns();
                }

                @Override
                public EvaluacionCriteriosSeguimientoInstructores getRowData(String rowKey) {
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
        current = (EvaluacionCriteriosSeguimientoInstructores) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new EvaluacionCriteriosSeguimientoInstructores();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvaluacionCriteriosSeguimientoInstructoresCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EvaluacionCriteriosSeguimientoInstructores) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvaluacionCriteriosSeguimientoInstructoresUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvaluacionCriteriosSeguimientoInstructoresDeleted"));
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

    @FacesConverter(forClass = EvaluacionCriteriosSeguimientoInstructores.class)
    public static class EvaluacionCriteriosSeguimientoInstructoresControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EvaluacionCriteriosSeguimientoInstructoresController controller = (EvaluacionCriteriosSeguimientoInstructoresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "evaluacionCriteriosSeguimientoInstructoresController");
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
            if (object instanceof EvaluacionCriteriosSeguimientoInstructores) {
                EvaluacionCriteriosSeguimientoInstructores o = (EvaluacionCriteriosSeguimientoInstructores) object;
                return getStringKey(o.getCodEvaCriIns());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EvaluacionCriteriosSeguimientoInstructores.class.getName());
            }
        }
    }
}
