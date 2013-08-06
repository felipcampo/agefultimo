package jsf;

import jpa.entities.EvaluacionesCriteriosSeguimientoProyectos;
import jsf.util.JsfUtil;
import jpa.sessions.EvaluacionesCriteriosSeguimientoProyectosFacade;

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

@ManagedBean(name = "evaluacionesCriteriosSeguimientoProyectosController")
@SessionScoped
public class EvaluacionesCriteriosSeguimientoProyectosController implements Serializable {

    private EvaluacionesCriteriosSeguimientoProyectos current;
    private LazyDataModel<EvaluacionesCriteriosSeguimientoProyectos> lazyModel = null;
    @EJB
    private jpa.sessions.EvaluacionesCriteriosSeguimientoProyectosFacade ejbFacade;

    public EvaluacionesCriteriosSeguimientoProyectosController() {
    }

    public EvaluacionesCriteriosSeguimientoProyectos getSelected() {
        if (current == null) {
            current = new EvaluacionesCriteriosSeguimientoProyectos();
        }
        return current;
    }

    public void setSelected(EvaluacionesCriteriosSeguimientoProyectos entity) {
        current = entity;
    }

    private EvaluacionesCriteriosSeguimientoProyectosFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<EvaluacionesCriteriosSeguimientoProyectos> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<EvaluacionesCriteriosSeguimientoProyectos>() {
                @Override
                public List<EvaluacionesCriteriosSeguimientoProyectos> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<EvaluacionesCriteriosSeguimientoProyectos> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(EvaluacionesCriteriosSeguimientoProyectos entity) {
                    return entity.getCodEvaCri();
                }

                @Override
                public EvaluacionesCriteriosSeguimientoProyectos getRowData(String rowKey) {
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
        current = (EvaluacionesCriteriosSeguimientoProyectos) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new EvaluacionesCriteriosSeguimientoProyectos();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvaluacionesCriteriosSeguimientoProyectosCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EvaluacionesCriteriosSeguimientoProyectos) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvaluacionesCriteriosSeguimientoProyectosUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvaluacionesCriteriosSeguimientoProyectosDeleted"));
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

    @FacesConverter(forClass = EvaluacionesCriteriosSeguimientoProyectos.class)
    public static class EvaluacionesCriteriosSeguimientoProyectosControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EvaluacionesCriteriosSeguimientoProyectosController controller = (EvaluacionesCriteriosSeguimientoProyectosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "evaluacionesCriteriosSeguimientoProyectosController");
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
            if (object instanceof EvaluacionesCriteriosSeguimientoProyectos) {
                EvaluacionesCriteriosSeguimientoProyectos o = (EvaluacionesCriteriosSeguimientoProyectos) object;
                return getStringKey(o.getCodEvaCri());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EvaluacionesCriteriosSeguimientoProyectos.class.getName());
            }
        }
    }
}
