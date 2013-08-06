package jsf;

import jpa.entities.MatrizCaracterizacion;
import jsf.util.JsfUtil;
import jpa.sessions.MatrizCaracterizacionFacade;

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

@ManagedBean(name = "matrizCaracterizacionController")
@SessionScoped
public class MatrizCaracterizacionController implements Serializable {

    private MatrizCaracterizacion current;
    private LazyDataModel<MatrizCaracterizacion> lazyModel = null;
    @EJB
    private jpa.sessions.MatrizCaracterizacionFacade ejbFacade;

    public MatrizCaracterizacionController() {
    }

    public MatrizCaracterizacion getSelected() {
        if (current == null) {
            current = new MatrizCaracterizacion();
        }
        return current;
    }

    public void setSelected(MatrizCaracterizacion entity) {
        current = entity;
    }

    private MatrizCaracterizacionFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<MatrizCaracterizacion> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<MatrizCaracterizacion>() {
                @Override
                public List<MatrizCaracterizacion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<MatrizCaracterizacion> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(MatrizCaracterizacion entity) {
                    return entity.getCodMatCar();
                }

                @Override
                public MatrizCaracterizacion getRowData(String rowKey) {
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
        current = (MatrizCaracterizacion) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new MatrizCaracterizacion();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("MatrizCaracterizacionCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (MatrizCaracterizacion) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("MatrizCaracterizacionUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("MatrizCaracterizacionDeleted"));
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

    @FacesConverter(forClass = MatrizCaracterizacion.class)
    public static class MatrizCaracterizacionControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MatrizCaracterizacionController controller = (MatrizCaracterizacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "matrizCaracterizacionController");
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
            if (object instanceof MatrizCaracterizacion) {
                MatrizCaracterizacion o = (MatrizCaracterizacion) object;
                return getStringKey(o.getCodMatCar());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + MatrizCaracterizacion.class.getName());
            }
        }
    }
}
