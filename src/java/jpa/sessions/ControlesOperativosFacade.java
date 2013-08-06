/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ControlesOperativos;

/**
 *
 * @author Usuario
 */
@Stateless
public class ControlesOperativosFacade extends AbstractFacade<ControlesOperativos> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControlesOperativosFacade() {
        super(ControlesOperativos.class);
    }
    
}
