/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.dao;


import com.zsmart.gestionDesSoutenances.bean.Indexation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface IndexationDao extends JpaRepository<Indexation, Long>{
   Indexation findByLibelle(String libelle);
   Indexation findByReference(String reference);
}
