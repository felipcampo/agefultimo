/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.GradosJuicio;

/**
 *
 * @author Usuario
 */
@Stateless
public class GradosJuicioFacade extends AbstractFacade<GradosJuicio> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GradosJuicioFacade() {
        super(GradosJuicio.class);
    }
    
}
