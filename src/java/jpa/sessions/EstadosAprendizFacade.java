/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EstadosAprendiz;

/**
 *
 * @author Usuario
 */
@Stateless
public class EstadosAprendizFacade extends AbstractFacade<EstadosAprendiz> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadosAprendizFacade() {
        super(EstadosAprendiz.class);
    }
    
}
