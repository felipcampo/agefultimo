package jsf;

import jpa.entities.MedidasFormativas;
import jsf.util.JsfUtil;
import jpa.sessions.MedidasFormativasFacade;

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

@ManagedBean(name = "medidasFormativasController")
@SessionScoped
public class MedidasFormativasController implements Serializable {

    private MedidasFormativas current;
    private LazyDataModel<MedidasFormativas> lazyModel = null;
    @EJB
    private jpa.sessions.MedidasFormativasFacade ejbFacade;

    public MedidasFormativasController() {
    }

    public MedidasFormativas getSelected() {
        if (current == null) {
            current = new MedidasFormativas();
        }
        return current;
    }

    public void setSelected(MedidasFormativas entity) {
        current = entity;
    }

    private MedidasFormativasFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<MedidasFormativas> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<MedidasFormativas>() {
                @Override
                public List<MedidasFormativas> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<MedidasFormativas> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(MedidasFormativas entity) {
                    return entity.getIdMedidasFormativas();
                }

                @Override
                public MedidasFormativas getRowData(String rowKey) {
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
        current = (MedidasFormativas) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new MedidasFormativas();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("MedidasFormativasCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (MedidasFormativas) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("MedidasFormativasUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("MedidasFormativasDeleted"));
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

    @FacesConverter(forClass = MedidasFormativas.class)
    public static class MedidasFormativasControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MedidasFormativasController controller = (MedidasFormativasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "medidasFormativasController");
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
            if (object instanceof MedidasFormativas) {
                MedidasFormativas o = (MedidasFormativas) object;
                return getStringKey(o.getCodMedFor());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + MedidasFormativas.class.getName());
            }
        }
    }
}
