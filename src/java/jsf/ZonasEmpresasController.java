package jsf;

import jpa.entities.ZonasEmpresas;
import jsf.util.JsfUtil;
import jpa.sessions.ZonasEmpresasFacade;

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

@ManagedBean(name = "zonasEmpresasController")
@SessionScoped
public class ZonasEmpresasController implements Serializable {

    private ZonasEmpresas current;
    private LazyDataModel<ZonasEmpresas> lazyModel = null;
    @EJB
    private jpa.sessions.ZonasEmpresasFacade ejbFacade;

    public ZonasEmpresasController() {
    }

    public ZonasEmpresas getSelected() {
        if (current == null) {
            current = new ZonasEmpresas();
        }
        return current;
    }

    public void setSelected(ZonasEmpresas entity) {
        current = entity;
    }

    private ZonasEmpresasFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<ZonasEmpresas> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<ZonasEmpresas>() {
                @Override
                public List<ZonasEmpresas> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<ZonasEmpresas> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(ZonasEmpresas entity) {
                    return entity.getCodZon();
                }

                @Override
                public ZonasEmpresas getRowData(String rowKey) {
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
        current = (ZonasEmpresas) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new ZonasEmpresas();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ZonasEmpresasCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ZonasEmpresas) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ZonasEmpresasUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ZonasEmpresasDeleted"));
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

    @FacesConverter(forClass = ZonasEmpresas.class)
    public static class ZonasEmpresasControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ZonasEmpresasController controller = (ZonasEmpresasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "zonasEmpresasController");
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
            if (object instanceof ZonasEmpresas) {
                ZonasEmpresas o = (ZonasEmpresas) object;
                return getStringKey(o.getCodZon());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ZonasEmpresas.class.getName());
            }
        }
    }
}
