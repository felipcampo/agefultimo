/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Ambientes;

/**
 *
 * @author Usuario
 */
@Stateless
public class AmbientesFacade extends AbstractFacade<Ambientes> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AmbientesFacade() {
        super(Ambientes.class);
    }
    
}
