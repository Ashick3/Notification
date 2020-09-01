/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firstproject.service;

import com.example.firstproject.dao.MainDao;
import com.example.firstproject.utils.PropertyReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author netphenix
 */
@Service
@Transactional
@CrossOrigin
public class FcmService {

    @Autowired
    MainDao mainDao;

    static PropertyReader fcmPropertyReader = new PropertyReader();
    final static private String FCM_URL = "https://fcm.googleapis.com/fcm/send";

    public static void send_FCM_Notification(String tokenId, String message, String title) {
        String serverKey = "fcm.server_key";
        String server_key = fcmPropertyReader.readProperties(serverKey, "fcm");
        System.out.println("===ooooooooooooo==" + server_key);
        System.out.println("+++msg++++" + message);
        System.out.println("+++tok++++" + tokenId);
        try {

// Create URL instance.
            URL url = new URL(FCM_URL);

// create connection.
            HttpURLConnection conn;
            conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

//set method as POST or GET
            conn.setRequestMethod("POST");

//FcmServiceass FCM server key
            conn.setRequestProperty("Authorization", "key=" + server_key);

//Specify Message Format
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Access-Control-Allow-Headers", "*");
            conn.setRequestProperty("Access-Control-Allow-Credentials", "true");
            conn.setDoInput(true);
            conn.setDoOutput(true);

//Create JSON Object & pass value
            JSONObject infoJson = new JSONObject();

            infoJson.put("title", title);

            infoJson.put("body", message);

            infoJson.put("sound", "default");

            infoJson.put("createdTime", new Date());

            JSONObject json = new JSONObject();

            json.put("to", tokenId.trim());

            json.put("notification", infoJson);

            json.put("data", infoJson);

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write(json.toString());

            wr.flush();

            int status = 0;

            if (null != conn) {

                status = conn.getResponseCode();

            }

            if (status != 0) {

                if (status == 200) {

//SUCCESS message
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    System.out.println("Android Notification Response : " + reader.readLine());

                } else if (status == 401) {

//client side error
                    System.out.println("Notification Response : TokenId : " + tokenId + " Error occurred :");

                } else if (status == 501) {

//server side error
                    System.out.println("Notification Response : [ errorCode=ServerError ] TokenId : " + tokenId);

                } else if (status == 503) {

//server side error
                    System.out.println("Notification Response : FCM Service is Unavailable  TokenId : " + tokenId);

                }

            }

        } catch (MalformedURLException mlfexception) {

// Prototcal Error
            System.out.println("Error occurred while sending push Notification!.." + mlfexception.getMessage());

        } catch (IOException mlfexception) {

//URL problem
            System.out.println("Reading URL, Error occurred while sending push Notification!.." + mlfexception.getMessage());

        } catch (Exception exception) {

//General Error or exception.
            System.out.println("Error occurred while sending push Notification!.." + exception.getMessage());

        }

    }
}
