package jsf;

import jpa.entities.FactoresProductiva;
import jsf.util.JsfUtil;
import jpa.sessions.FactoresProductivaFacade;

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

@ManagedBean(name = "factoresProductivaController")
@SessionScoped
public class FactoresProductivaController implements Serializable {

    private FactoresProductiva current;
    private LazyDataModel<FactoresProductiva> lazyModel = null;
    @EJB
    private jpa.sessions.FactoresProductivaFacade ejbFacade;

    public FactoresProductivaController() {
    }

    public FactoresProductiva getSelected() {
        if (current == null) {
            current = new FactoresProductiva();
        }
        return current;
    }

    public void setSelected(FactoresProductiva entity) {
        current = entity;
    }

    private FactoresProductivaFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<FactoresProductiva> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<FactoresProductiva>() {
                @Override
                public List<FactoresProductiva> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<FactoresProductiva> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(FactoresProductiva entity) {
                    return entity.getIdFactoresProductiva();
                }

                @Override
                public FactoresProductiva getRowData(String rowKey) {
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
        current = (FactoresProductiva) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new FactoresProductiva();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FactoresProductivaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (FactoresProductiva) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FactoresProductivaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FactoresProductivaDeleted"));
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

    @FacesConverter(forClass = FactoresProductiva.class)
    public static class FactoresProductivaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FactoresProductivaController controller = (FactoresProductivaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "factoresProductivaController");
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
            if (object instanceof FactoresProductiva) {
                FactoresProductiva o = (FactoresProductiva) object;
                return getStringKey(o.getIdFep());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + FactoresProductiva.class.getName());
            }
        }
    }
}
