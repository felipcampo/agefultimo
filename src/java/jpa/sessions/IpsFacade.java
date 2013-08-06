/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Ips;

/**
 *
 * @author Usuario
 */
@Stateless
public class IpsFacade extends AbstractFacade<Ips> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IpsFacade() {
        super(Ips.class);
    }
    
}
