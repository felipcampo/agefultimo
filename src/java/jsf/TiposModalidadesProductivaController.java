package jsf;

import jpa.entities.TiposModalidadesProductiva;
import jsf.util.JsfUtil;
import jpa.sessions.TiposModalidadesProductivaFacade;

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

@ManagedBean(name = "tiposModalidadesProductivaController")
@SessionScoped
public class TiposModalidadesProductivaController implements Serializable {

    private TiposModalidadesProductiva current;
    private LazyDataModel<TiposModalidadesProductiva> lazyModel = null;
    @EJB
    private jpa.sessions.TiposModalidadesProductivaFacade ejbFacade;

    public TiposModalidadesProductivaController() {
    }

    public TiposModalidadesProductiva getSelected() {
        if (current == null) {
            current = new TiposModalidadesProductiva();
        }
        return current;
    }

    public void setSelected(TiposModalidadesProductiva entity) {
        current = entity;
    }

    private TiposModalidadesProductivaFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<TiposModalidadesProductiva> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<TiposModalidadesProductiva>() {
                @Override
                public List<TiposModalidadesProductiva> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<TiposModalidadesProductiva> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(TiposModalidadesProductiva entity) {
                    return entity.getCodTdm();
                }

                @Override
                public TiposModalidadesProductiva getRowData(String rowKey) {
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
        current = (TiposModalidadesProductiva) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new TiposModalidadesProductiva();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("TiposModalidadesProductivaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (TiposModalidadesProductiva) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("TiposModalidadesProductivaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("TiposModalidadesProductivaDeleted"));
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

    @FacesConverter(forClass = TiposModalidadesProductiva.class)
    public static class TiposModalidadesProductivaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TiposModalidadesProductivaController controller = (TiposModalidadesProductivaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tiposModalidadesProductivaController");
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
            if (object instanceof TiposModalidadesProductiva) {
                TiposModalidadesProductiva o = (TiposModalidadesProductiva) object;
                return getStringKey(o.getCodTdm());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TiposModalidadesProductiva.class.getName());
            }
        }
    }
}
