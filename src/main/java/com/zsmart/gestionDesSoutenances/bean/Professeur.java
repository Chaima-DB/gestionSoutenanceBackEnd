/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.bean;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author HP
 */
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Professeur extends Personnel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDernierePublication;
    
    @OneToMany
    private List<Jury> jurys;

    public List<Jury> getJurys() {
        return jurys;
    }

    public void setJurys(List<Jury> jurys) {
        this.jurys = jurys;
    }
    
    
    public Professeur() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDernierePublication() {
        return dateDernierePublication;
    }

    public void setDateDernierePublication(Date dateDernierePublication) {
        this.dateDernierePublication = dateDernierePublication;
    }

}
