/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Alistamientos;

/**
 *
 * @author Usuario
 */
@Stateless
public class AlistamientosFacade extends AbstractFacade<Alistamientos> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlistamientosFacade() {
        super(Alistamientos.class);
    }
    
}
