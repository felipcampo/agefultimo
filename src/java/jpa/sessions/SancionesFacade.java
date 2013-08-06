/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Sanciones;

/**
 *
 * @author Usuario
 */
@Stateless
public class SancionesFacade extends AbstractFacade<Sanciones> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SancionesFacade() {
        super(Sanciones.class);
    }
    
}
