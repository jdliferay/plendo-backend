package com.maintacloud.repository;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DaoGeneric<E, ID extends Serializable> {

    @PersistenceContext
    protected EntityManager entityManager;


    private Class<E> entityClass;


    @SuppressWarnings("unchecked")
    protected DaoGeneric() {
        try {
            entityClass = (Class<E>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Exception e) {
            entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
    }

    public void refresh(E entity) {
        entityManager.refresh(entity);
    }

    public E persist(E entity) {
        entityManager.persist(entity);
        return entity;
    }


    public List<E> persistList(List<E> listToPersist) {
        for (E e : listToPersist) {
            entityManager.persist(e);
        }
        return listToPersist;
    }

    public List<E> mergeList(List<E> listToPersist) {
        for (E e : listToPersist) {
            entityManager.merge(e);
        }
        return listToPersist;
    }


    public E retrieve(ID id) {
        return entityManager.find(entityClass, id);
    }

    public E update(E entity) {
        entityManager.merge(entity);
        return entity;
    }


    public List<E> getAll() {
        TypedQuery<E> query = this.entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
        List<E> results = query.getResultList();
        return results;
    }

    public void delete(ID id) {
        try {
            E ref = entityManager.getReference(entityClass, id);
            entityManager.remove(ref);
        } catch (EntityNotFoundException e) {
            return;
        }
    }

    public List<E> findWithNamedQuery(String queryName) {
        return findWithNamedQuery(queryName, null, 0);
    }

    public List<E> findWithNamedQuery(String queryName, int resultLimit) {
        return this.findWithNamedQuery(queryName, null, resultLimit);
    }

    public List<E> findWithNamedQuery(String namedQueryName,
                                      Map<String, Object> parameters) {
        return findWithNamedQuery(namedQueryName, parameters, 0);
    }

    public List<E> findWithNamedQuery(String namedQueryName,
                                      Map<String, Object> parameters, int resultLimit) {
        TypedQuery<E> query = this.entityManager.createNamedQuery(namedQueryName,
                entityClass);
        if (resultLimit > 0)
            query.setMaxResults(resultLimit);
        if (parameters != null && !parameters.isEmpty()) {
            Set<Map.Entry<String, Object>> rawParameters = parameters
                    .entrySet();
            for (Map.Entry<String, Object> entry : rawParameters) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        // TODO provoque l'exception suivante : java.lang.IllegalArgumentException: Query FIND_ALL_USERS_ATTACHED_TO_USER_BY_LOGIN, query hint eclipselink.result-collection-type is not valid for this type of query.
        //query.setHint("eclipselink.result-collection-type", java.util.ArrayList.class);
        // TODO check and read for performancce BYPASS => we call always database and ignore cach but ....
        // query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

        return query.getResultList();
    }


    public List<Object[]> findWithNativeQuery(String queryName) {
        return findWithNativeQuery(queryName, null, 0);
    }

    public List<Object[]> findWithNativeQuery(String queryName, int resultLimit) {
        return this.findWithNativeQuery(queryName, null, resultLimit);
    }

    public List<Object[]> findWithNativeQuery(String namedQueryName,
                                              Map<String, Object> parameters) {
        return findWithNativeQuery(namedQueryName, parameters, 0);
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findWithNativeQuery(String namedQueryName,
                                              Map<String, Object> parameters, int resultLimit) {
        Query query = this.entityManager.createNativeQuery(namedQueryName, entityClass);
        if (resultLimit > 0)
            query.setMaxResults(resultLimit);
        if (parameters != null && !parameters.isEmpty()) {
            Set<Map.Entry<String, Object>> rawParameters = parameters
                    .entrySet();
            for (Map.Entry<String, Object> entry : rawParameters) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.getResultList();
    }


    public E findSingleResultWithNamedQuery(String queryName) {
        return this
                .findSingleResultWithNamedQuery(queryName, null);
    }

    public E findSingleResultWithNamedQuery(String namedQueryName,
                                            Map<String, Object> parameters) {
        TypedQuery<E> query = this.entityManager.createNamedQuery(namedQueryName, entityClass);

        if (parameters != null && !parameters.isEmpty()) {
            Set<Map.Entry<String, Object>> rawParameters = parameters
                    .entrySet();
            for (Map.Entry<String, Object> entry : rawParameters) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

//        query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
        return query.getSingleResult();
    }

    public List<E> findWithQuery(String queryName, int resultLimit) {
        return findWithQuery(queryName, null, resultLimit);
    }

    public List<E> findWithQuery(String queryName,
                                 Map<String, Object> parameters) {
        return findWithQuery(queryName, parameters, 0);
    }

    public List<E> findWithQuery(String queryName,
                                 Map<String, Object> parameters, int resultLimit) {
        TypedQuery<E> query = this.entityManager.createQuery(queryName, entityClass);
        if (resultLimit > 0)
            query.setMaxResults(resultLimit);
        if (parameters != null && !parameters.isEmpty()) {
            Set<Map.Entry<String, Object>> rawParameters = parameters
                    .entrySet();
            for (Map.Entry<String, Object> entry : rawParameters) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.getResultList();
    }
}