/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import com.zsmart.gestionDesSoutenances.uploads.model.FileInfo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author HP
 */
@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePublicationArticle;
    private String motCle;

    @ManyToOne
    Indexation indexation;
    @ManyToOne
    Doctorant doctorant;
    
    @OneToOne
    FileInfo file;

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatePublicationArticle() {
        return datePublicationArticle;
    }

    public void setDatePublicationArticle(Date datePublicationArticle) {
        this.datePublicationArticle = datePublicationArticle;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public Indexation getIndexation() {
        return indexation;
    }

    public void setIndexation(Indexation indexation) {
        this.indexation = indexation;
    }

    public Doctorant getDoctorant() {
        return doctorant;
    }

    public void setDoctorant(Doctorant doctorant) {
        this.doctorant = doctorant;
    }

    public FileInfo getFile() {
        return file;
    }

    public void setFile(FileInfo fileInfo) {
        this.file = fileInfo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
