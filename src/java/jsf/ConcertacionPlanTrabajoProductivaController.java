package jsf;

import jpa.entities.ConcertacionPlanTrabajoProductiva;
import jsf.util.JsfUtil;
import jpa.sessions.ConcertacionPlanTrabajoProductivaFacade;

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

@ManagedBean(name = "concertacionPlanTrabajoProductivaController")
@SessionScoped
public class ConcertacionPlanTrabajoProductivaController implements Serializable {

    private ConcertacionPlanTrabajoProductiva current;
    private LazyDataModel<ConcertacionPlanTrabajoProductiva> lazyModel = null;
    @EJB
    private jpa.sessions.ConcertacionPlanTrabajoProductivaFacade ejbFacade;

    public ConcertacionPlanTrabajoProductivaController() {
    }

    public ConcertacionPlanTrabajoProductiva getSelected() {
        if (current == null) {
            current = new ConcertacionPlanTrabajoProductiva();
        }
        return current;
    }

    public void setSelected(ConcertacionPlanTrabajoProductiva entity) {
        current = entity;
    }

    private ConcertacionPlanTrabajoProductivaFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<ConcertacionPlanTrabajoProductiva> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<ConcertacionPlanTrabajoProductiva>() {
                @Override
                public List<ConcertacionPlanTrabajoProductiva> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<ConcertacionPlanTrabajoProductiva> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(ConcertacionPlanTrabajoProductiva entity) {
                    return entity.getCodCpt();
                }

                @Override
                public ConcertacionPlanTrabajoProductiva getRowData(String rowKey) {
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
        current = (ConcertacionPlanTrabajoProductiva) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new ConcertacionPlanTrabajoProductiva();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ConcertacionPlanTrabajoProductivaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ConcertacionPlanTrabajoProductiva) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ConcertacionPlanTrabajoProductivaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ConcertacionPlanTrabajoProductivaDeleted"));
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

    @FacesConverter(forClass = ConcertacionPlanTrabajoProductiva.class)
    public static class ConcertacionPlanTrabajoProductivaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ConcertacionPlanTrabajoProductivaController controller = (ConcertacionPlanTrabajoProductivaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "concertacionPlanTrabajoProductivaController");
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
            if (object instanceof ConcertacionPlanTrabajoProductiva) {
                ConcertacionPlanTrabajoProductiva o = (ConcertacionPlanTrabajoProductiva) object;
                return getStringKey(o.getCodCpt());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ConcertacionPlanTrabajoProductiva.class.getName());
            }
        }
    }
}
