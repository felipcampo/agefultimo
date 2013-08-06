package jsf;

import jpa.entities.FichasUsuarios;
import jsf.util.JsfUtil;
import jpa.sessions.FichasUsuariosFacade;

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

@ManagedBean(name = "fichasUsuariosController")
@SessionScoped
public class FichasUsuariosController implements Serializable {

    private FichasUsuarios current;
    private LazyDataModel<FichasUsuarios> lazyModel = null;
    @EJB
    private jpa.sessions.FichasUsuariosFacade ejbFacade;

    public FichasUsuariosController() {
    }

    public FichasUsuarios getSelected() {
        if (current == null) {
            current = new FichasUsuarios();
            current.setFichasUsuariosPK(new jpa.entities.FichasUsuariosPK());
        }
        return current;
    }

    public void setSelected(FichasUsuarios entity) {
        current = entity;
    }

    private FichasUsuariosFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<FichasUsuarios> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<FichasUsuarios>() {
                @Override
                public List<FichasUsuarios> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<FichasUsuarios> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(FichasUsuarios entity) {
                    return entity.getFichasUsuariosPK();
                }

                @Override
                public FichasUsuarios getRowData(String rowKey) {
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
        current = (FichasUsuarios) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new FichasUsuarios();
        current.setFichasUsuariosPK(new jpa.entities.FichasUsuariosPK());
        return "Create";
    }

    public String create() {
        try {
            current.getFichasUsuariosPK().setIdUsu(current.getUsuarios().getIdUsu());
            current.getFichasUsuariosPK().setCodFic(current.getFichasCaracterizacion().getCodFic());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FichasUsuariosCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (FichasUsuarios) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            current.getFichasUsuariosPK().setIdUsu(current.getUsuarios().getIdUsu());
            current.getFichasUsuariosPK().setCodFic(current.getFichasCaracterizacion().getCodFic());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FichasUsuariosUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FichasUsuariosDeleted"));
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

    @FacesConverter(forClass = FichasUsuarios.class)
    public static class FichasUsuariosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FichasUsuariosController controller = (FichasUsuariosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fichasUsuariosController");
            return controller.ejbFacade.find(getKey(value));
        }

        jpa.entities.FichasUsuariosPK getKey(String value) {
            jpa.entities.FichasUsuariosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new jpa.entities.FichasUsuariosPK();
            key.setCodFic(Integer.parseInt(values[0]));
            key.setIdUsu(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(jpa.entities.FichasUsuariosPK value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value.getCodFic());
            sb.append(SEPARATOR);
            sb.append(value.getIdUsu());
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FichasUsuarios) {
                FichasUsuarios o = (FichasUsuarios) object;
                return getStringKey(o.getFichasUsuariosPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + FichasUsuarios.class.getName());
            }
        }
    }
}
