/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Faltas;

/**
 *
 * @author Usuario
 */
@Stateless
public class FaltasFacade extends AbstractFacade<Faltas> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FaltasFacade() {
        super(Faltas.class);
    }
    
}
