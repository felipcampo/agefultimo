/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.SubactividadesProyecto;

/**
 *
 * @author Usuario
 */
@Stateless
public class SubactividadesProyectoFacade extends AbstractFacade<SubactividadesProyecto> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubactividadesProyectoFacade() {
        super(SubactividadesProyecto.class);
    }
    
}
