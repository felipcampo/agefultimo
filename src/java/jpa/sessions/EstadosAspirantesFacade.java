/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EstadosAspirantes;

/**
 *
 * @author Usuario
 */
@Stateless
public class EstadosAspirantesFacade extends AbstractFacade<EstadosAspirantes> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadosAspirantesFacade() {
        super(EstadosAspirantes.class);
    }
    
}
