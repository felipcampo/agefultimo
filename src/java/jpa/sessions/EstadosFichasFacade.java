/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EstadosFichas;

/**
 *
 * @author Usuario
 */
@Stateless
public class EstadosFichasFacade extends AbstractFacade<EstadosFichas> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadosFichasFacade() {
        super(EstadosFichas.class);
    }
    
}
