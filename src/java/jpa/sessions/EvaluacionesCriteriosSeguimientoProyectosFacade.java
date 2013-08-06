/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EvaluacionesCriteriosSeguimientoProyectos;

/**
 *
 * @author Usuario
 */
@Stateless
public class EvaluacionesCriteriosSeguimientoProyectosFacade extends AbstractFacade<EvaluacionesCriteriosSeguimientoProyectos> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacionesCriteriosSeguimientoProyectosFacade() {
        super(EvaluacionesCriteriosSeguimientoProyectos.class);
    }
    
}
