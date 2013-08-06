/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ReportesNovedades;

/**
 *
 * @author Usuario
 */
@Stateless
public class ReportesNovedadesFacade extends AbstractFacade<ReportesNovedades> {
    @PersistenceContext(unitName = "agefultimoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportesNovedadesFacade() {
        super(ReportesNovedades.class);
    }
    
}
