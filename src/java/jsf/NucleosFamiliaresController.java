package jsf;

import jpa.entities.NucleosFamiliares;
import jsf.util.JsfUtil;
import jpa.sessions.NucleosFamiliaresFacade;

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

@ManagedBean(name = "nucleosFamiliaresController")
@SessionScoped
public class NucleosFamiliaresController implements Serializable {

    private NucleosFamiliares current;
    private LazyDataModel<NucleosFamiliares> lazyModel = null;
    @EJB
    private jpa.sessions.NucleosFamiliaresFacade ejbFacade;

    public NucleosFamiliaresController() {
    }

    public NucleosFamiliares getSelected() {
        if (current == null) {
            current = new NucleosFamiliares();
        }
        return current;
    }

    public void setSelected(NucleosFamiliares entity) {
        current = entity;
    }

    private NucleosFamiliaresFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<NucleosFamiliares> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<NucleosFamiliares>() {
                @Override
                public List<NucleosFamiliares> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<NucleosFamiliares> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(NucleosFamiliares entity) {
                    return entity.getIdNucleosFamiliares();
                }

                @Override
                public NucleosFamiliares getRowData(String rowKey) {
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
        current = (NucleosFamiliares) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new NucleosFamiliares();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("NucleosFamiliaresCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (NucleosFamiliares) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("NucleosFamiliaresUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("NucleosFamiliaresDeleted"));
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

    @FacesConverter(forClass = NucleosFamiliares.class)
    public static class NucleosFamiliaresControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NucleosFamiliaresController controller = (NucleosFamiliaresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "nucleosFamiliaresController");
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
            if (object instanceof NucleosFamiliares) {
                NucleosFamiliares o = (NucleosFamiliares) object;
                return getStringKey(o.getCodNucFam());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + NucleosFamiliares.class.getName());
            }
        }
    }
}
