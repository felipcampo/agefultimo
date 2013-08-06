package jsf;

import jpa.entities.VisitaEtapaProductiva;
import jsf.util.JsfUtil;
import jpa.sessions.VisitaEtapaProductivaFacade;

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

@ManagedBean(name = "visitaEtapaProductivaController")
@SessionScoped
public class VisitaEtapaProductivaController implements Serializable {

    private VisitaEtapaProductiva current;
    private LazyDataModel<VisitaEtapaProductiva> lazyModel = null;
    @EJB
    private jpa.sessions.VisitaEtapaProductivaFacade ejbFacade;

    public VisitaEtapaProductivaController() {
    }

    public VisitaEtapaProductiva getSelected() {
        if (current == null) {
            current = new VisitaEtapaProductiva();
        }
        return current;
    }

    public void setSelected(VisitaEtapaProductiva entity) {
        current = entity;
    }

    private VisitaEtapaProductivaFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<VisitaEtapaProductiva> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<VisitaEtapaProductiva>() {
                @Override
                public List<VisitaEtapaProductiva> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<VisitaEtapaProductiva> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(VisitaEtapaProductiva entity) {
                    return entity.getCodVis();
                }

                @Override
                public VisitaEtapaProductiva getRowData(String rowKey) {
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
        current = (VisitaEtapaProductiva) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new VisitaEtapaProductiva();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("VisitaEtapaProductivaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (VisitaEtapaProductiva) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("VisitaEtapaProductivaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("VisitaEtapaProductivaDeleted"));
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

    @FacesConverter(forClass = VisitaEtapaProductiva.class)
    public static class VisitaEtapaProductivaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VisitaEtapaProductivaController controller = (VisitaEtapaProductivaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "visitaEtapaProductivaController");
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
            if (object instanceof VisitaEtapaProductiva) {
                VisitaEtapaProductiva o = (VisitaEtapaProductiva) object;
                return getStringKey(o.getCodVis());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + VisitaEtapaProductiva.class.getName());
            }
        }
    }
}
