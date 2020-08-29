/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firstproject.controller;

import com.example.firstproject.model.Fileupload;
import com.example.firstproject.service.FileUploadService;
//import com.netphenix.blaer.admin.service.FileuploadService;
//import com.netphenix.utils.Constant;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author samraj
 */
@Controller
@RequestMapping()
public class FileUploadController {

    //  private static String fileuploadPath = "/opt/work/ProjectImages/";
    @Autowired
    private FileUploadService fileuploadService;
//    final static Logger log = Logger.getLogger(FileUploadController.class);

    @RequestMapping(value = "image", method = RequestMethod.POST)
    public @ResponseBody
    Fileupload continueFileUpload(HttpServletRequest request, HttpServletResponse response) {

        MultipartHttpServletRequest mRequest;
        String returnFilename = null;
        String fileName = null;
        Integer id = 1;
        try {
            mRequest = (MultipartHttpServletRequest) request;
            mRequest.getParameterMap();

            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile mFile = mRequest.getFile(itr.next());
                fileName = mFile.getOriginalFilename();
                returnFilename = "/opt/test" + RandomStringUtils.randomAlphanumeric(32).toUpperCase() + new Date().getTime() + "-" + fileName;
//                returnFilename = Constant.FILE_UPLOAD_PATH + fileName;

                java.nio.file.Path path = Paths.get(returnFilename);
                Files.deleteIfExists(path);
                InputStream in = mFile.getInputStream();
                Files.copy(in, path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileuploadService.saveFile(returnFilename, fileName);
        return null;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(HttpMessageNotReadableException e) {
        e.printStackTrace();
    }
}
