/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firstproject.dao;

//import com.example.firstproject.model.Phase;
import com.example.firstproject.model.Fcm;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author netphenix
 */
@Repository
public class MainDao  {

//    public MainDao() {
//        super();
//        setClazz(Fcm.class);
//    }
//
//    @Transactional
//    public List<Fcm> getNotificationById(String name) {
//        String queryStr = "select f from Fcm f where f.title = :name";
//        Query query = getCurrentSession().createQuery(queryStr);
//        query.setParameter("name", name);
//        return query.list();
//    }
}
