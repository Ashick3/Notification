/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firstproject.dao;

import com.example.firstproject.model.Fcm;
import com.example.firstproject.model.Fileupload;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FileUploadDao extends BaseDao {

    public FileUploadDao() {
        super();
        setClazz(Fileupload.class);
    }

//    public Fileupload read(Integer id) {
//        return (Fileupload) super.read(FileUpload.class);
//    }
}
