/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author HP
 */
@Entity
public class Soutenance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSoutenance;
    private String resultatFinal;

    @OneToOne
    private Doctorant doctorant;

    @OneToMany(mappedBy = "soutenance")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Jury> jurys;

    
    public Soutenance(String reference, Date dateSoutenance, String resultatFinal, Doctorant doctorant,
			List<Jury> jurys) {
		super();
		this.reference = reference;
		this.dateSoutenance = dateSoutenance;
		this.resultatFinal = resultatFinal;
		this.doctorant = doctorant;
		this.jurys = jurys;
	}

	public Soutenance() {
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

    public Date getDateSoutenance() {
        return dateSoutenance;
    }

    public void setDateSoutenance(Date dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
    }

    public String getResultatFinal() {
        return resultatFinal;
    }

    public void setResultatFinal(String resultatFinal) {
        this.resultatFinal = resultatFinal;
    }

    public Doctorant getDoctorant() {
        return doctorant;
    }

    public void setDoctorant(Doctorant doctorant) {
        this.doctorant = doctorant;
    }

    public List<Jury> getJurys() {
        return jurys;
    }

    public void setJurys(List<Jury> jurys) {
        this.jurys = jurys;
    }



}
