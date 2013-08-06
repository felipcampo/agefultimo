/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Eps;

/**
 *
 * @author Usuario
 */
@Stateless
public class EpsFacade extends AbstractFacade<Eps> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EpsFacade() {
        super(Eps.class);
    }
    
}
