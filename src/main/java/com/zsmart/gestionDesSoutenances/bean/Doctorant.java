/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author HP
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Doctorant extends Personnel {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cne;
        private boolean nv;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateInscription;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Sujet sujet;

    @ManyToOne
    private StructureDeRecherche structureDeRecherche;
    
    @OneToMany(mappedBy = "doctorant")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Rapporteur> rapporteurs;   
}
