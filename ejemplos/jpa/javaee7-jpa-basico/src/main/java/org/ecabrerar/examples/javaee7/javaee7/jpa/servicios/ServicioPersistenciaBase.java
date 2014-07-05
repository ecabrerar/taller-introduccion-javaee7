/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ecabrerar.examples.javaee7.javaee7.jpa.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ecabrerar
 * @param <T>
 */
public abstract class ServicioPersistenciaBase<T> {

    private final Class<T> entityClass;

    public ServicioPersistenciaBase(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManagerFactory getEntityManager() {
        return Persistence.createEntityManagerFactory("Javaee7JPAPU");
    }

    public void salvar(T entidad) {
        EntityManager entityManager = this.getEntityManager().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(entidad);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    public void modificar(T endidad) {
        EntityManager entityManager = this.getEntityManager().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(endidad);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    public void borrar(long id) {

    }

    public T getRegistroPorId(int id) {
        return null;
    }

    public List<T> getListarTodos() {
        final CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);
        Root<T> root = criteriaQuery.from(entityClass);

        criteriaQuery.select(root);

        TypedQuery<T> query = getEntityManager().createEntityManager().createQuery(criteriaQuery);

        return query.getResultList();
    }
}
