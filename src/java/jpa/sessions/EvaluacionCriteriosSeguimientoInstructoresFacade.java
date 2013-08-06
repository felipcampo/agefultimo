/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EvaluacionCriteriosSeguimientoInstructores;

/**
 *
 * @author Usuario
 */
@Stateless
public class EvaluacionCriteriosSeguimientoInstructoresFacade extends AbstractFacade<EvaluacionCriteriosSeguimientoInstructores> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacionCriteriosSeguimientoInstructoresFacade() {
        super(EvaluacionCriteriosSeguimientoInstructores.class);
    }
    
}
