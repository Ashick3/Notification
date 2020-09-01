/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firstproject.service;

//import com.example.firstproject.dao.FileUploadBaseDao;
import com.example.firstproject.dao.BaseDao;
import com.example.firstproject.dao.FileUploadDao;
import com.example.firstproject.model.Fileupload;
//import com.netphenix.blaer.admin.dao.FileuploadDao;
//import com.netphenix.blaer.model.Fileupload;
import java.util.Map;
import org.apache.tomcat.util.http.fileupload.FileUpload;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@Transactional
public class FileUploadService {

    @Autowired
    private FileUploadDao fileUploadDao;
//    final static Logger log = Logger.getLogger(FileUploadService.class);

    public Object saveFile(String returnFilename, String fileName) {
//        log.debug("Calling saveFile function with return type Map with parameter returnFilename,fileName" + returnFilename + fileName);
        Fileupload fileUpload = new Fileupload();
//        fileUpload.setId(1);
        fileUpload.setFilepath("ghghg");
        fileUpload.setFileName("jnnj");
//        System.out.println("id=============" + id);
        System.out.println("returnFilename=========" + returnFilename);
        System.out.println("fileName=======" + fileName);
        System.out.println("fileUpload=======" + fileUpload);
//        fileUploadDao.saveOrUpdate(fileUpload);

        return fileUpload;

    }

    public Fileupload getFileById(Integer id) {
        return null;
//        log.debug("Calling saveFile function with return type Fileupload with parameter id" + id);
//        return (Fileupload) fileUploadDao.read(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(HttpMessageNotReadableException e) {
        e.printStackTrace();
    }
}
