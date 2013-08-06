/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ControlAprendiz;

/**
 *
 * @author Usuario
 */
@Stateless
public class ControlAprendizFacade extends AbstractFacade<ControlAprendiz> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControlAprendizFacade() {
        super(ControlAprendiz.class);
    }
    
}
