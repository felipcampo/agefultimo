/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ActividadesProyecto;

/**
 *
 * @author Usuario
 */
@Stateless
public class ActividadesProyectoFacade extends AbstractFacade<ActividadesProyecto> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadesProyectoFacade() {
        super(ActividadesProyecto.class);
    }
    
}
