/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.NivelesFormacion;

/**
 *
 * @author Usuario
 */
@Stateless
public class NivelesFormacionFacade extends AbstractFacade<NivelesFormacion> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelesFormacionFacade() {
        super(NivelesFormacion.class);
    }
    
}
