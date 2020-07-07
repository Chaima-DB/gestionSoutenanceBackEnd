/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class These implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date datePublicationThese;
        @Column(name = "titre")
	private String titre;
        
        private String filepath;
        
        private String fileName;

	@Column(name = "description")
	private String desciption;

	@Column(name = "fichier")
	private File file;
        
        @ManyToOne
        private Doctorant doctorant;

        

}
