/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firstproject.controller;

//import com.example.firstproject.model.Phase;
import com.example.firstproject.model.Fcm;
import com.example.firstproject.service.FcmService;
import com.example.firstproject.service.MainService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author netphenix
 */
@RestController
@CrossOrigin
public class MainController {

    @Autowired
    MainService userService;
    @Autowired
    FcmService fcmService;

    @RequestMapping(value = "/notificationEvent", method = RequestMethod.POST, produces = "application/json")
    public Fcm saveNotificationEvent(HttpServletRequest request, HttpServletResponse response, @RequestBody Fcm notificationEvent) {
        String tokenId = notificationEvent.getTokenId();
        String title = notificationEvent.getTitle();
        String message = notificationEvent.getMessage();

        return userService.sendNotificationToUser(tokenId, title, message);
    }

//    @RequestMapping(value = "/notification/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
//    public List<Fcm> getCustomer(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
//        return userService.getCustomer(id);
//
//    }
   
}
