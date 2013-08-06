/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.LlamadosAtencionVerbal;

/**
 *
 * @author Usuario
 */
@Stateless
public class LlamadosAtencionVerbalFacade extends AbstractFacade<LlamadosAtencionVerbal> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LlamadosAtencionVerbalFacade() {
        super(LlamadosAtencionVerbal.class);
    }
    
}
