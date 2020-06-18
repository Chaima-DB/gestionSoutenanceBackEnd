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
import javax.persistence.Temporal;

/**
 *
 * @author HP
 */
@Entity
public class Communication extends Document{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String endroit;
    private String type;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCommunication;
    
    
    public Communication(String endroit, String type, Date dateCommunication) {
		super();
		this.endroit = endroit;
		this.type = type;
		this.dateCommunication = dateCommunication;
	}


	public Communication() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndroit() {
        return endroit;
    }

    public void setEndroit(String endroit) {
        this.endroit = endroit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateCommunication() {
        return dateCommunication;
    }

    public void setDateCommunication(Date dateCommunication) {
        this.dateCommunication = dateCommunication;
    }

    @Override
    public String toString() {
        return "Communication{" + "id=" + id + ", endroit=" + endroit + ", type=" + type + ", dateCommunication=" + dateCommunication + '}';
    }
   
    
}
