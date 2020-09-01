/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firstproject.service;

import com.example.firstproject.dao.MainDao;
import com.example.firstproject.model.Fcm;
import java.util.Date;
//import com.example.firstproject.model.Phase;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MainService {

    @Autowired
    MainDao userDao;

    @Autowired
    FcmService fcmService;

    public Fcm sendNotificationToUser(String tokenId, String title, String message) {
        Fcm fcm = new Fcm();
        fcm.setTokenId(tokenId);
        fcm.setMessage(message);
        fcm.setTitle(title);
        System.out.println("fcm++++++++++++" + fcm);
        fcmService.send_FCM_Notification(tokenId, title, message);
//        userDao.save(fcm);
        return null;
    }

//    @org.springframework.transaction.annotation.Transactional
//    public List<Fcm> getCustomer(String id) {
//        return userDao.getNotificationById(id);
//    }
}
