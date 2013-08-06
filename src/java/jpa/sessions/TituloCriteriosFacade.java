/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.TituloCriterios;

/**
 *
 * @author Usuario
 */
@Stateless
public class TituloCriteriosFacade extends AbstractFacade<TituloCriterios> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TituloCriteriosFacade() {
        super(TituloCriterios.class);
    }
    
}
