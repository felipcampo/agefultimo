/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.CriteriosSeguimientoProyectos;

/**
 *
 * @author Usuario
 */
@Stateless
public class CriteriosSeguimientoProyectosFacade extends AbstractFacade<CriteriosSeguimientoProyectos> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CriteriosSeguimientoProyectosFacade() {
        super(CriteriosSeguimientoProyectos.class);
    }
    
}
