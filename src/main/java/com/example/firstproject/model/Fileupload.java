/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.firstproject.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author netphenix
 */
@Entity
@Table(name = "fileupload")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fileupload.findAll", query = "SELECT f FROM Fileupload f")
    , @NamedQuery(name = "Fileupload.findById", query = "SELECT f FROM Fileupload f WHERE f.id = :id")
    , @NamedQuery(name = "Fileupload.findByFilepath", query = "SELECT f FROM Fileupload f WHERE f.filepath = :filepath")
    , @NamedQuery(name = "Fileupload.findByFileName", query = "SELECT f FROM Fileupload f WHERE f.fileName = :fileName")})
public class Fileupload implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 225)
    @Column(name = "filepath")
    private String filepath;
    @Size(max = 225)
    @Column(name = "file_name")
    private String fileName;

    public Fileupload() {
    }

    public Fileupload(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fileupload)) {
            return false;
        }
        Fileupload other = (Fileupload) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fileupload{" + "id=" + id + ", filepath=" + filepath + ", fileName=" + fileName + '}';
    }

}
