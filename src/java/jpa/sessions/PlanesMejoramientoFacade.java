/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.PlanesMejoramiento;

/**
 *
 * @author Usuario
 */
@Stateless
public class PlanesMejoramientoFacade extends AbstractFacade<PlanesMejoramiento> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanesMejoramientoFacade() {
        super(PlanesMejoramiento.class);
    }
    
}
