/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author HP
 */
@AllArgsConstructor
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Doctorant extends Personnel {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private String cne;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateInscription;

	@OneToOne
	private Sujet sujet;
	
	@ManyToOne
	private StructureDeRecherche structureDeRecherche;

	@ManyToOne
	private DirecteurThese directeurThese;
	
	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "article_id")
	private List<Article> article = new ArrayList<>();

		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
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

	public DirecteurThese getDirecteurThese() {
		return directeurThese;
	}

	public void setDirecteurThese(DirecteurThese directeurThese) {
		this.directeurThese = directeurThese;
	}

}
