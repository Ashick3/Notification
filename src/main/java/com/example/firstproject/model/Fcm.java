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
@Table(name = "fcm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fcm.findAll", query = "SELECT f FROM Fcm f")
    , @NamedQuery(name = "Fcm.findByFcm", query = "SELECT f FROM Fcm f WHERE f.fcm = :fcm")
    , @NamedQuery(name = "Fcm.findByMessage", query = "SELECT f FROM Fcm f WHERE f.message = :message")
    , @NamedQuery(name = "Fcm.findByTitle", query = "SELECT f FROM Fcm f WHERE f.title = :title")
    , @NamedQuery(name = "Fcm.findByTokenId", query = "SELECT f FROM Fcm f WHERE f.tokenId = :tokenId")})
public class Fcm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fcm")
    private Integer fcm;
    @Size(max = 40)
    @Column(name = "message")
    private String message;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @Size(max = 200)
    @Column(name = "tokenId")
    private String tokenId;

    public Fcm() {
    }

    public Fcm(Integer fcm) {
        this.fcm = fcm;
    }

    public Integer getFcm() {
        return fcm;
    }

    public void setFcm(Integer fcm) {
        this.fcm = fcm;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fcm != null ? fcm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fcm)) {
            return false;
        }
        Fcm other = (Fcm) object;
        if ((this.fcm == null && other.fcm != null) || (this.fcm != null && !this.fcm.equals(other.fcm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.firstproject.model.Fcm[ fcm=" + fcm + " ]";
    }
    
}
