/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Aportantes;

/**
 *
 * @author Usuario
 */
@Stateless
public class AportantesFacade extends AbstractFacade<Aportantes> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AportantesFacade() {
        super(Aportantes.class);
    }
    
}
