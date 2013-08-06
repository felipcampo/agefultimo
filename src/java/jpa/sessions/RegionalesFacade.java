/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Regionales;

/**
 *
 * @author Usuario
 */
@Stateless
public class RegionalesFacade extends AbstractFacade<Regionales> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionalesFacade() {
        super(Regionales.class);
    }
    
}
