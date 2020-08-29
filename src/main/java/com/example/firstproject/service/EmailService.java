///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.example.firstproject.service;
//
//import com.example.firstproject.mail.MailProperties;
//import com.example.firstproject.mail.TextMailWithAttachment;
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Logger;
//import javax.transaction.Transactional;
////import org.springframework.beans.factory.annotation.Autowired;
//import freemarker.template.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
///**
// *
// * @author netphenix
// */
//@Service
//@Transactional
//public class EmailService {
//
//    @Autowired
//    Configuration fmConfiguration;
//
////    final static Logger log = Logger.getLogger(EmailService.class);
////    public String getContentFromTemplate(String templateName, Map< String, Object> model) {
////        log.debug("Calling getContentFromTemplate function with return type Map with parameter templateName,model" + templateName + model);
////        StringBuffer content = new StringBuffer();
////        try {
////            content.append(FreeMarkerTemplateUtils
////                    .processTemplateIntoString(fmConfiguration.getTemplate(templateName), model));
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return content.toString();
////    }
//    public boolean sendEmail(String to, String cc, String subject, String htmlContent, List<String> attachments) {
//        System.out.println("++++++++++++++++++++++++");
////        log.debug("Calling sendEmail function with return type boolean with parameter to,cc,subject,htmlContent,attachments" + to + cc + subject + htmlContent + attachments);
//        try {
//            MailProperties mailProps = new MailProperties();
//            TextMailWithAttachment sender = new TextMailWithAttachment(mailProps);
//            sender.sendMail(to, cc, subject, htmlContent, attachments);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    public static void main(String argv[]) {
//        System.out.println("??????????????");
//    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public void handle(HttpMessageNotReadableException e) {
//        e.printStackTrace();
//    }
//}
