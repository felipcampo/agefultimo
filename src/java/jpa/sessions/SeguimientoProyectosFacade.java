/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.SeguimientoProyectos;

/**
 *
 * @author Usuario
 */
@Stateless
public class SeguimientoProyectosFacade extends AbstractFacade<SeguimientoProyectos> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguimientoProyectosFacade() {
        super(SeguimientoProyectos.class);
    }
    
}
