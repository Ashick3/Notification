///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.example.firstproject.mail;
//
//import com.example.firstproject.utils.PropertyReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import freemarker.template.Configuration;
//import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.HtmlEmail;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//
///**
// *
// * @author netphenix
// */
//public class TextMailWithAttachment {
//
//    private MailProperties props = null;
//
//    @Autowired
//    Configuration fmConfiguration;
//
//    PropertyReader propReader = new PropertyReader();
//
//    private final String hostName = "smtp.hostname";
//    private final String setPort = "smtp.port";
//    private final String authUser = "smtp.authuser";
//    private final String authPass = "smtp.authpass";
//    private final String fromAddress = "smtp.fromaddress";
//    private final String tlsSslRequired = "smtp.tls.ssl.required";
//
//    public TextMailWithAttachment(MailProperties props) {
//        this.props = props;
//    }
//
//    public String geContentFromTemplate(Map< String, Object> model) {
//        StringBuffer content = new StringBuffer();
//        try {
//            content.append(FreeMarkerTemplateUtils
//                    .processTemplateIntoString(fmConfiguration.getTemplate("email-template.txt"), model));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return content.toString();
//    }
//
//    public static void main(String argv[]) {
//        MailProperties mailProps = new MailProperties();
//        TextMailWithAttachment sender = new TextMailWithAttachment(mailProps);
//        String[] attachments = {"/tmp/test.pdf"};
//        String htmlContent = "<p style='font-size:16px;color:red'>Hello John Doe</p>";
//        sender.sendMail("varghees@netphenix.com", "ajose@netphenix.com", "Test", htmlContent, Arrays.asList(attachments));
//    }
//
//    public String sendMail(String to, String cc, String subject, String message, List<String> attachments) {
//        List<MailAttachment> mailAttachments = new ArrayList<>();
//        if (attachments != null) {
//            for (Iterator<String> iterator = attachments.iterator(); iterator.hasNext();) {
//                String attachment = iterator.next();
//                MailAttachment mailAttachment = new MailAttachment();
//                mailAttachment.setAttachDescription("");
//                mailAttachment.setAttachmentPath(attachment);
//                mailAttachments.add(mailAttachment);
//            }
//        }
//        if (this.props == null) {
//            this.props = new MailProperties();
//        }
//        this.props.setHostName(propReader.readProperties(hostName, "email"));
//        int portNo = Integer.parseInt(propReader.readProperties(setPort, "email"));
//        this.props.setPort(portNo);
//        this.props.setAuthUser(propReader.readProperties(authUser, "email"));
//        this.props.setAuthPasswd(propReader.readProperties(authPass, "email"));
//        this.props.setFrom(propReader.readProperties(fromAddress, "email"));
//        this.props.setSetSSLOnConnect(Boolean.parseBoolean(propReader.readProperties(tlsSslRequired, "email")));
//        this.props.setHtmlMessage(message);
////        this.props.setTxtMessage(message);
//        this.props.setSubject(subject);
//        this.props.setTo(to);
//        if (cc != null) {
//            this.props.setCc(cc);
//        }
//        this.props.setAttachment(mailAttachments);
//        return sendMail();
//    }
//
//    public String sendMail() {
//        try {
//            // Create the email message
//            HtmlEmail email = new HtmlEmail();
//            email.setHostName(props.getHostName());
//            email.setSmtpPort(props.getPort());
//            email.setAuthentication(props.getAuthUser(), props.getAuthPasswd());
//            email.setSSLOnConnect(props.isSetSSLOnConnect());
//            email.setFrom(props.getFrom());
//            email.setSubject(props.getSubject());
//            email.setHtmlMsg(props.getHtmlMessage());
//            if (props.getCc() != null) {
//                String[] ccAddressArr = props.getCc().split(",");
//                for (int i = 0; i < ccAddressArr.length; i++) {
//                    String cc = ccAddressArr[i];
//                    email.addCc(cc);
//                }
//            }
//            String[] toAddressArr = props.getTo().split(",");
//            for (int i = 0; i < toAddressArr.length; i++) {
//                String to = toAddressArr[i];
//                email.addTo(to);
//            }
//
//            // add attachments
//            List<MailAttachment> attachFiles = props.getAttachment();
//            for (int i = 0; i < attachFiles.size(); i++) {
//                MailAttachment attachFile = attachFiles.get(i);
//                // Create the attachment
//                EmailAttachment attachment = new EmailAttachment();
//                //attachment.setURL(props.getAttachmentURL());
//                attachment.setPath(attachFile.getAttachmentPath());
//                attachment.setDisposition(EmailAttachment.ATTACHMENT);
//                attachment.setDescription(attachFile.getAttachDescription());
//                attachment.setName(attachFile.getAttachName());
//                email.attach(attachment);
//            }
//
//            // send the email
//            System.out.println("Deliveing mail....");
//            System.out.println("Subject: " + email.getSubject());
//            System.out.println("Message : " + props.getTxtMessage());
//            String result = email.send();
//            System.out.println("Deliveing mail.... Return Message -> " + result);
//            return "Sent";
//
//        } catch (EmailException ex) {
//            Logger.getLogger(TextMailWithAttachment.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "Not Sent";
//    }
//}
