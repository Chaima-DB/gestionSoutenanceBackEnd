/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author HP
 */
@Entity
public class Doctorant extends Personnel {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cne;
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date dateInscription;
    private String password;

    @OneToOne
    private Sujet sujet;

    @ManyToOne
    private DirecteurThese directeurThese;

    @ManyToOne
    private StructureDeRecherche structureDeRecherche;
  

    public Doctorant() {
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCne() {
        return cne;
    }

    public void setCNE(String cne) {
        this.cne = cne;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Sujet getSujet() {
        return sujet;
    }

    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }

    public StructureDeRecherche getStructureDeRecherche() {
        return structureDeRecherche;
    }

    public void setStructureDeRecherche(StructureDeRecherche structureDeRecherche) {
        this.structureDeRecherche = structureDeRecherche;
    }

    public DirecteurThese getDirecteurThese() {
        return directeurThese;
    }

    public void setDirecteurThese(DirecteurThese directeurThese) {
        this.directeurThese = directeurThese;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


   

}
