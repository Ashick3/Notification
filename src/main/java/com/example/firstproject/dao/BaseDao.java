/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firstproject.dao;

import com.example.firstproject.model.Fileupload;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author netphenix
 */
public abstract class BaseDao< T extends Serializable> {

    private Class< T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    public void setClazz(Class< T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T read(int id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public List< T> readAll() {
        return getCurrentSession()
                .createQuery("from " + clazz.getName()).list();
    }

    public void save(T entity) {
        getCurrentSession().persist(entity);
    }

    public void saveOrUpdate(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public T update(T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(int id) {
        final T entity = read(id);
        delete(entity);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
