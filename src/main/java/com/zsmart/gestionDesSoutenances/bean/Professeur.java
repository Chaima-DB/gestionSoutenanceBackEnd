/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author HP
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Professeur extends Personnel {

    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    protected Date dateDernierePublication;

	public Professeur() {
		//super()
    }

    public Date getDateDernierePublication() {
        return dateDernierePublication;
    }

    public void setDateDernierePublication(Date dateDernierePublication) {
        this.dateDernierePublication = dateDernierePublication;
    }
    
    

}
