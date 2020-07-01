/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author HP
 */
@Entity
public class StructureDeRecherche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private String title;
    private String responsable;
    private String emailRespo;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Etablissement etablissement;
    

    public StructureDeRecherche(String reference, Etablissement etablissement, String title, String responsable,
			String emailRespo) {
		super();
		this.reference = reference;
		this.etablissement = etablissement;
		this.title = title;
		this.responsable = responsable;
		this.emailRespo = emailRespo;
	}



	public StructureDeRecherche() {
    }
             

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEmailRespo() {
        return emailRespo;
    }

    public void setEmailRespo(String emailRespo) {
        this.emailRespo = emailRespo;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }


}
