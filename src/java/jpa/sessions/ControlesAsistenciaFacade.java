/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ControlesAsistencia;

/**
 *
 * @author Usuario
 */
@Stateless
public class ControlesAsistenciaFacade extends AbstractFacade<ControlesAsistencia> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControlesAsistenciaFacade() {
        super(ControlesAsistencia.class);
    }
    
}
