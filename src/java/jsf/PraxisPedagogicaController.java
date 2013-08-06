package jsf;

import jpa.entities.PraxisPedagogica;
import jsf.util.JsfUtil;
import jpa.sessions.PraxisPedagogicaFacade;

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

@ManagedBean(name = "praxisPedagogicaController")
@SessionScoped
public class PraxisPedagogicaController implements Serializable {

    private PraxisPedagogica current;
    private LazyDataModel<PraxisPedagogica> lazyModel = null;
    @EJB
    private jpa.sessions.PraxisPedagogicaFacade ejbFacade;

    public PraxisPedagogicaController() {
    }

    public PraxisPedagogica getSelected() {
        if (current == null) {
            current = new PraxisPedagogica();
        }
        return current;
    }

    public void setSelected(PraxisPedagogica entity) {
        current = entity;
    }

    private PraxisPedagogicaFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<PraxisPedagogica> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<PraxisPedagogica>() {
                @Override
                public List<PraxisPedagogica> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<PraxisPedagogica> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(PraxisPedagogica entity) {
                    return entity.getIdPraxisPedagogica();
                }

                @Override
                public PraxisPedagogica getRowData(String rowKey) {
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
        current = (PraxisPedagogica) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new PraxisPedagogica();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("PraxisPedagogicaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (PraxisPedagogica) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("PraxisPedagogicaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("PraxisPedagogicaDeleted"));
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

    @FacesConverter(forClass = PraxisPedagogica.class)
    public static class PraxisPedagogicaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PraxisPedagogicaController controller = (PraxisPedagogicaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "praxisPedagogicaController");
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
            if (object instanceof PraxisPedagogica) {
                PraxisPedagogica o = (PraxisPedagogica) object;
                return getStringKey(o.getCodPrx());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + PraxisPedagogica.class.getName());
            }
        }
    }
}
