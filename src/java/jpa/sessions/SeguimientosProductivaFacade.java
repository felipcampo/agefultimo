/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.SeguimientosProductiva;

/**
 *
 * @author Usuario
 */
@Stateless
public class SeguimientosProductivaFacade extends AbstractFacade<SeguimientosProductiva> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguimientosProductivaFacade() {
        super(SeguimientosProductiva.class);
    }
    
}
