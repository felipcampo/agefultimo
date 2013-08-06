/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import org.primefaces.model.SortOrder;

/**
 *
 * @author leoandresm
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T refresh(T entity) {
        getEntityManager().refresh(getEntityManager().merge(entity));
        return entity;
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    private Predicate getFilterCondition(CriteriaBuilder cb, Root<T> entity, Map<String, String> filters) {
        Predicate filterCondition = cb.conjunction();
        try {                       
             if (filters != null) {
             EntityType<T> Entity_ = entity.getModel();
             List<Predicate> ps = new ArrayList<Predicate>();
             for (Map.Entry<String, String> param : filters.entrySet()) {
             String campo = param.getKey();
             String valor = "%" + param.getValue() + "%";
             ps.add(cb.like(entity.get(Entity_.getSingularAttribute(campo, String.class)), valor));
             }
             if (ps.size() > 0) {
             return cb.and(ps.toArray(new Predicate[]{}));
             }
             } 
            return filterCondition;
        } catch (Exception e) {
            Logger.getLogger(entityClass.getName()).log(Level.SEVERE, "Exception", e);
            return filterCondition;
        }
    }

    public int count(Map<String, String> filters) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<T> entity = cq.from(entityClass);
        cq.where(getFilterCondition(cb, entity, filters));
        cq.select(cb.count(entity));
        return getEntityManager().createQuery(cq).getSingleResult().intValue();
    }

    public List<T> getResultList(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> entity = cq.from(entityClass);
        cq.where(getFilterCondition(cb, entity, filters));
        if (sortField != null) {
            if (sortOrder == SortOrder.ASCENDING) {
                cq.orderBy(cb.asc(entity.get(sortField)));
            } else if (sortOrder == SortOrder.DESCENDING) {
                cq.orderBy(cb.desc(entity.get(sortField)));
            }
        }
        return getEntityManager().createQuery(cq).setFirstResult(first).setMaxResults(pageSize).getResultList();
    }
}
