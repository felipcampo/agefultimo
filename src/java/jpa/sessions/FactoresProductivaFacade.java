/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.FactoresProductiva;

/**
 *
 * @author Usuario
 */
@Stateless
public class FactoresProductivaFacade extends AbstractFacade<FactoresProductiva> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FactoresProductivaFacade() {
        super(FactoresProductiva.class);
    }
    
}
