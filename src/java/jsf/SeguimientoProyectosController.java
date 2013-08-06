package jsf;

import jpa.entities.SeguimientoProyectos;
import jsf.util.JsfUtil;
import jpa.sessions.SeguimientoProyectosFacade;

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

@ManagedBean(name = "seguimientoProyectosController")
@SessionScoped
public class SeguimientoProyectosController implements Serializable {

    private SeguimientoProyectos current;
    private LazyDataModel<SeguimientoProyectos> lazyModel = null;
    @EJB
    private jpa.sessions.SeguimientoProyectosFacade ejbFacade;

    public SeguimientoProyectosController() {
    }

    public SeguimientoProyectos getSelected() {
        if (current == null) {
            current = new SeguimientoProyectos();
        }
        return current;
    }

    public void setSelected(SeguimientoProyectos entity) {
        current = entity;
    }

    private SeguimientoProyectosFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<SeguimientoProyectos> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<SeguimientoProyectos>() {
                @Override
                public List<SeguimientoProyectos> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<SeguimientoProyectos> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(SeguimientoProyectos entity) {
                    return entity.getIdSeguimientoProyectos();
                }

                @Override
                public SeguimientoProyectos getRowData(String rowKey) {
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
        current = (SeguimientoProyectos) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new SeguimientoProyectos();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProyectosCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (SeguimientoProyectos) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProyectosUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProyectosDeleted"));
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

    @FacesConverter(forClass = SeguimientoProyectos.class)
    public static class SeguimientoProyectosControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SeguimientoProyectosController controller = (SeguimientoProyectosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "seguimientoProyectosController");
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
            if (object instanceof SeguimientoProyectos) {
                SeguimientoProyectos o = (SeguimientoProyectos) object;
                return getStringKey(o.getCodSeg());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + SeguimientoProyectos.class.getName());
            }
        }
    }
}
