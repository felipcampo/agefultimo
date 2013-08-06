/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.TiposModalidadesProductiva;

/**
 *
 * @author Usuario
 */
@Stateless
public class TiposModalidadesProductivaFacade extends AbstractFacade<TiposModalidadesProductiva> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposModalidadesProductivaFacade() {
        super(TiposModalidadesProductiva.class);
    }
    
}
