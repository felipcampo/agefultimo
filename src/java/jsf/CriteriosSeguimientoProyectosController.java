package jsf;

import jpa.entities.CriteriosSeguimientoProyectos;
import jsf.util.JsfUtil;
import jpa.sessions.CriteriosSeguimientoProyectosFacade;

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

@ManagedBean(name = "criteriosSeguimientoProyectosController")
@SessionScoped
public class CriteriosSeguimientoProyectosController implements Serializable {

    private CriteriosSeguimientoProyectos current;
    private LazyDataModel<CriteriosSeguimientoProyectos> lazyModel = null;
    @EJB
    private jpa.sessions.CriteriosSeguimientoProyectosFacade ejbFacade;

    public CriteriosSeguimientoProyectosController() {
    }

    public CriteriosSeguimientoProyectos getSelected() {
        if (current == null) {
            current = new CriteriosSeguimientoProyectos();
            current.setCriteriosSeguimientoProyectosPK(new jpa.entities.CriteriosSeguimientoProyectosPK());
        }
        return current;
    }

    public void setSelected(CriteriosSeguimientoProyectos entity) {
        current = entity;
    }

    private CriteriosSeguimientoProyectosFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<CriteriosSeguimientoProyectos> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<CriteriosSeguimientoProyectos>() {
                @Override
                public List<CriteriosSeguimientoProyectos> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<CriteriosSeguimientoProyectos> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(CriteriosSeguimientoProyectos entity) {
                    return entity.getIdCriteriosSeguimientoProyectos();
                }

                @Override
                public CriteriosSeguimientoProyectos getRowData(String rowKey) {
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
        current = (CriteriosSeguimientoProyectos) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new CriteriosSeguimientoProyectos();
        current.setCriteriosSeguimientoProyectosPK(new jpa.entities.CriteriosSeguimientoProyectosPK());
        return "Create";
    }

    public String create() {
        try {
            current.getCriteriosSeguimientoProyectosPK().setCodSeg(current.getSeguimientoProyectos().getCodSeg());
            current.getCriteriosSeguimientoProyectosPK().setCodCri(current.getCriteriosEvaluacion().getCodCri());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriteriosSeguimientoProyectosCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (CriteriosSeguimientoProyectos) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            current.getCriteriosSeguimientoProyectosPK().setCodSeg(current.getSeguimientoProyectos().getCodSeg());
            current.getCriteriosSeguimientoProyectosPK().setCodCri(current.getCriteriosEvaluacion().getCodCri());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriteriosSeguimientoProyectosUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriteriosSeguimientoProyectosDeleted"));
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

    @FacesConverter(forClass = CriteriosSeguimientoProyectos.class)
    public static class CriteriosSeguimientoProyectosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CriteriosSeguimientoProyectosController controller = (CriteriosSeguimientoProyectosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "criteriosSeguimientoProyectosController");
            return controller.ejbFacade.find(getKey(value));
        }

        jpa.entities.CriteriosSeguimientoProyectosPK getKey(String value) {
            jpa.entities.CriteriosSeguimientoProyectosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new jpa.entities.CriteriosSeguimientoProyectosPK();
            key.setCodCri(values[0]);
            key.setCodSeg(values[1]);
            return key;
        }

        String getStringKey(jpa.entities.CriteriosSeguimientoProyectosPK value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value.getCodCri());
            sb.append(SEPARATOR);
            sb.append(value.getCodSeg());
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CriteriosSeguimientoProyectos) {
                CriteriosSeguimientoProyectos o = (CriteriosSeguimientoProyectos) object;
                return getStringKey(o.getCriteriosSeguimientoProyectosPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + CriteriosSeguimientoProyectos.class.getName());
            }
        }
    }
}
