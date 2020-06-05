/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.dao;


import com.zsmart.gestionDesSoutenances.bean.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface SujetDao extends JpaRepository<Sujet, Long>{
   Sujet findByReference(String reference);
}
