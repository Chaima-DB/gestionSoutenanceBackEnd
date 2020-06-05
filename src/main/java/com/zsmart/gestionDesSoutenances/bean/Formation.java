/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author HP
 */
@Entity
public class Formation extends Document{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double nbrHeures;
    
    
    public Formation(double nbrHeures) {
		super();
		this.nbrHeures = nbrHeures;
	}


	public Formation() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(double nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

   
   
    
}
