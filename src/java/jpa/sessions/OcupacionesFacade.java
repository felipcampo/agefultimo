/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Ocupaciones;

/**
 *
 * @author Usuario
 */
@Stateless
public class OcupacionesFacade extends AbstractFacade<Ocupaciones> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OcupacionesFacade() {
        super(Ocupaciones.class);
    }
    
}
