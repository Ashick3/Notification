///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.example.firstproject.dao;
//
//import java.io.Serializable;
//import java.util.List;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author netphenix
// */
//@Transactional
//@Repository
//public class FileUploadBaseDao {
//
//    @Autowired
//    protected SessionFactory sessionFactory;
//
//    public Object create(Object object) {
//        try {
//            System.out.println("Object: " + object);
//            sessionFactory.getCurrentSession().save(object);
//            //sessionFactory.getCurrentSession().flush();
//        } catch (Exception e) {
//            // Exception need tobe logged
//            e.printStackTrace();
//            return null;
//        }
//        return object;
//    }
//
//    public Object update(Object object) {
//        try {
//            sessionFactory.getCurrentSession().merge(object);
//            sessionFactory.getCurrentSession().flush();
//        } catch (Exception e) {
//            // Exception need tobe logged
//            return null;
//        }
//        return object;
//    }
//
//    public List read(Class c) {
//        return sessionFactory.getCurrentSession().createCriteria(c).list();
//    }
//
//    public Object read(Class c, Serializable id) {
//        return sessionFactory.getCurrentSession().get(c, id);
//    }
//
//    public void saveOrUpdate(Object object) {
//        sessionFactory.getCurrentSession().saveOrUpdate(object);
//    }
//
//    public Object delete(Object object) {
//        try {
//            sessionFactory.getCurrentSession().delete(object);
//        } catch (Exception e) {
//            // Exception need tobe logged
//            return null;
//        }
//        return object;
//    }
//}
//
