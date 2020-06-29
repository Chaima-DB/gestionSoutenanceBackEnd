/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.dao;

import com.zsmart.gestionDesSoutenances.bean.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface ProfesseurDao extends JpaRepository<Professeur, Long> {

    Professeur findByCin(String cin);

    int deleteByCin(String cin);
    
    Professeur findByUserEmail(String email);

}
