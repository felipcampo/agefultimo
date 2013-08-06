/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.CentrosFormacion;

/**
 *
 * @author Usuario
 */
@Stateless
public class CentrosFormacionFacade extends AbstractFacade<CentrosFormacion> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentrosFormacionFacade() {
        super(CentrosFormacion.class);
    }
    
}
