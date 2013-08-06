package jsf;

import jpa.entities.EstadosMedidasFormativas;
import jsf.util.JsfUtil;
import jpa.sessions.EstadosMedidasFormativasFacade;

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

@ManagedBean(name = "estadosMedidasFormativasController")
@SessionScoped
public class EstadosMedidasFormativasController implements Serializable {

    private EstadosMedidasFormativas current;
    private LazyDataModel<EstadosMedidasFormativas> lazyModel = null;
    @EJB
    private jpa.sessions.EstadosMedidasFormativasFacade ejbFacade;

    public EstadosMedidasFormativasController() {
    }

    public EstadosMedidasFormativas getSelected() {
        if (current == null) {
            current = new EstadosMedidasFormativas();
        }
        return current;
    }

    public void setSelected(EstadosMedidasFormativas entity) {
        current = entity;
    }

    private EstadosMedidasFormativasFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<EstadosMedidasFormativas> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<EstadosMedidasFormativas>() {
                @Override
                public List<EstadosMedidasFormativas> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<EstadosMedidasFormativas> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(EstadosMedidasFormativas entity) {
                    return entity.getCodEst();
                }

                @Override
                public EstadosMedidasFormativas getRowData(String rowKey) {
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
        current = (EstadosMedidasFormativas) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new EstadosMedidasFormativas();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosMedidasFormativasCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EstadosMedidasFormativas) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosMedidasFormativasUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EstadosMedidasFormativasDeleted"));
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

    @FacesConverter(forClass = EstadosMedidasFormativas.class)
    public static class EstadosMedidasFormativasControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstadosMedidasFormativasController controller = (EstadosMedidasFormativasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estadosMedidasFormativasController");
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
            if (object instanceof EstadosMedidasFormativas) {
                EstadosMedidasFormativas o = (EstadosMedidasFormativas) object;
                return getStringKey(o.getCodEst());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EstadosMedidasFormativas.class.getName());
            }
        }
    }
}
