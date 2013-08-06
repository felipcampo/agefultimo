/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Comites;

/**
 *
 * @author Usuario
 */
@Stateless
public class ComitesFacade extends AbstractFacade<Comites> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComitesFacade() {
        super(Comites.class);
    }
    
}
