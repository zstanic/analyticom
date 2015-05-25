package de.analyticom.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import de.analyticom.entity.Player;

@Repository
public class BaseDao<T> {
   
	@PersistenceContext(unitName="analyticom_pu")
    protected EntityManager entityManager;
	
    @SuppressWarnings("unchecked")
    public <T> List<T> find(String hql, Class<T> type) {
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    // Get a list of objects based on one passed parameter
    @SuppressWarnings("unchecked")
    public <T> List<T> find(String hql, Object value, Class<T> type) {
        Query query = entityManager.createQuery(hql).setParameter(0, value);
        return query.getResultList();
    }

    // Get a list of objects based on set of passed parameter
    @SuppressWarnings("unchecked")
    public <T> List<T> find(String hql, Object[] values, Class<T> type) {
        Query query = entityManager.createQuery(hql);

        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }

        return query.getResultList();
    }


    public <T> T get(Class<T> type, Serializable id) {
        return (T) entityManager.find(type, id);
    }

    // Get an object based one key (Long)
    @SuppressWarnings("unchecked")
    public <T> T loadByKey(Class<T> type, String attributeName, Long attributeValue) {

        String hql = "select " + type.getSimpleName() + " from " + type.getName() + " " +
                type.getSimpleName() + " where " + type.getSimpleName() + "." + attributeName +
                " = :attributeValue";

        Query query = entityManager.createQuery(hql).setParameter("attributeValue", attributeValue);

        List<T> result = query.getResultList();
        if(result != null && !result.isEmpty()){
            return result.get(0);
        } else {
            return null;
        }
    }

    // Get an object based one key (String)
    @SuppressWarnings("unchecked")
    public <T> T loadByKey(Class<T> type, String attributeName, String attributeValue) {
        Query query = entityManager.createQuery(" from " + type.getName() + " " +
                type.getSimpleName() + " where " + type.getSimpleName() + "." + attributeName +
                " = :attributeValue").setParameter("attributeValue", attributeValue);

        List<T> result = query.getResultList();
        if(result != null && !result.isEmpty()){
            return result.get(0);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
	public <T> T loadByKey(Class<T> type, String attributeName, Integer attributeValue) {

        Query query = entityManager.createQuery(" from " + type.getName() + " " +
                type.getSimpleName() + " where " + type.getSimpleName() + "." + attributeName +
                " = :attributeValue").setParameter("attributeValue", attributeValue);

        List<T> result = query.getResultList();
        if(result != null && !result.isEmpty()){
            return result.get(0);
        } else {
            return null;
        }
    }

    // Get the objects for lookup tables
    @SuppressWarnings({ "unchecked", "hiding" })
    public <T> List<T> findAll(Class<T> c) {
        Query query = entityManager.createQuery("from " + c.getName());
        return (List<T>) query.getResultList();
    }

    // Returns objects of the passed type based on the criteria
    public <T> List<T> find(Class<T> c, Map<String, Object> parameters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(c);
        Root<T> root = cq.from(c);
        List<Predicate> predicates = new ArrayList<Predicate>();
        for (String key : parameters.keySet()) {
            predicates.add(cb.equal(root.get(key), parameters.get(key)));
        }
        cq.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<T> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    // Get one unique object from the named query
    @SuppressWarnings({ "unchecked", "hiding" })
    public <T> T find(Class<T> c, String queryName, Map<String, Object> parameters) {
        Query query = entityManager.createNamedQuery(queryName);
        for (String key : parameters.keySet()) {
            query.setParameter(key, parameters.get(key));

        }

        List<T> result = query.getResultList();
        if(result != null && !result.isEmpty()){
            return result.get(0);
        } else {
            return null;
        }
    }

    // Get list of objects from the named query
    @SuppressWarnings({ "unchecked", "hiding" })
    public <T> List<T> getList(Class<T> c, String queryName, Map<String, Object> parameters) {
        Query query = entityManager.createNamedQuery(queryName);
        for (String key : parameters.keySet()) {
            query.setParameter(key, parameters.get(key));
        }
        
        return (List<T>) query.getResultList();
    }
    
    
    @SuppressWarnings("unchecked")
    public <T> List<T> getList(String hql, Map<String, Object> parameters, Class<T> type) {
        Query query = entityManager.createQuery(hql);

        for (String key : parameters.keySet()) {
            query.setParameter(key, parameters.get(key));
        }

        return query.getResultList();
    }
    
    /*
    	}*/
    
    
	public long getCount(String hql, Map<String, Object> parameters) {
		Query query = entityManager.createQuery(hql, Long.class);
		for (String key : parameters.keySet()) {
            query.setParameter(key, parameters.get(key));
        }
		
	 return (Long) query.getSingleResult();
	}
    
	public long getCount(String hql) {
		Query query = entityManager.createQuery(hql, Long.class);		
		return (Long) query.getSingleResult();
	}
	
    @SuppressWarnings("unchecked")
	public <T> List<T> getListPaginated(String hql, Map<String, Object> parameters, Class<T> type, Integer firstResult, Integer maxResults){
		
    	Query query = entityManager.createQuery(hql);

        for (String key : parameters.keySet()) {
            query.setParameter(key, parameters.get(key));
        }
        System.out.println(query.toString());
        if(firstResult != null && maxResults != null){
    		query.setFirstResult(firstResult);
    		query.setMaxResults(maxResults);
    	}
        return query.getResultList();
    }
        
    @SuppressWarnings("unchecked")
	public <T> List<T> getListNative(String sql, Map<String, Object> parameters, Class<T> type){
    	Query query = entityManager.createNativeQuery(sql);

        for (String key : parameters.keySet()) {
            query.setParameter(key, parameters.get(key));
        }
        return query.getResultList();
    }

    // Save an entity
    public void save(Object entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }

    // Updates an entity
    public void update(Object entity) {
        entityManager.merge(entity);
    }

    // First tries to save if fails then updates
    public void saveOrUpdate(Object entity) {
        entityManager.merge(entity);
    }

    // Deletes the entity from the database, row is removed, use it judiciously
    public void delete(Object entity) {
    	if (entity instanceof Player){
    		Player ply = entityManager.getReference(Player.class, ((Player)entity).getId());
    		entityManager.remove(ply);
    	}else{
    		entityManager.remove(entity);
    	}
    }

    // Flush the current state of the entity
    public void flush() {
        entityManager.flush();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}

