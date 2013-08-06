/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.TiposCasosBienestar;

/**
 *
 * @author Usuario
 */
@Stateless
public class TiposCasosBienestarFacade extends AbstractFacade<TiposCasosBienestar> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposCasosBienestarFacade() {
        super(TiposCasosBienestar.class);
    }
    
}
