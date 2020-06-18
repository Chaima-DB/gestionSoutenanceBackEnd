/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
//import java.io.File;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author HP
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Document implements Serializable {

    protected String reference;
    protected String titre;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date datePublicationSite;
    @Lob
    protected  byte[] pdf;
    
    @ManyToOne
    protected Doctorant doctorant;

    public Document() {
    }

    public Document(String titre, byte[] pdf) {
        this.titre = titre;
        this.pdf = pdf;
    }

    public Document(String reference, String titre, Date datePublicationSite, byte[] pdf, Doctorant doctorant) {
        this.reference = reference;
        this.titre = titre;
        this.datePublicationSite = datePublicationSite;
        this.pdf = pdf;
        this.doctorant = doctorant;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDatePublicationSite() {
        return datePublicationSite;
    }

    public void setDatePublicationSite(Date datePublicationSite) {
        this.datePublicationSite = datePublicationSite;
    }

    public Doctorant getDoctorant() {
        return doctorant;
    }

    public void setDoctorant(Doctorant doctorant) {
        this.doctorant = doctorant;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Document{" + "reference=" + reference + ", titre=" + titre + ", datePublicationSite=" + datePublicationSite + ", doctorant=" + doctorant + '}';
    }

    
   
}
