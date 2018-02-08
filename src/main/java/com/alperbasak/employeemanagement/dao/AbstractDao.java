package com.alperbasak.employeemanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    AbstractDao() {
        this.persistentClass=(Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    T getByKey(PK key){
        return getSession().get(persistentClass,key);
    }

    void persist(T entity){
        getSession().persist(entity);
    }

    public void delete(T entity){
        getSession().delete(entity);
    }

    CriteriaQuery<T> createEntityCriteriaQuery(){
        return createCriteriaBuilder().createQuery(persistentClass);
    }

    CriteriaBuilder createCriteriaBuilder(){
        return getSession().getCriteriaBuilder();
    }

}
