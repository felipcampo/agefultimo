/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.FichasUsuarios;

/**
 *
 * @author Usuario
 */
@Stateless
public class FichasUsuariosFacade extends AbstractFacade<FichasUsuarios> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichasUsuariosFacade() {
        super(FichasUsuarios.class);
    }
    
}
