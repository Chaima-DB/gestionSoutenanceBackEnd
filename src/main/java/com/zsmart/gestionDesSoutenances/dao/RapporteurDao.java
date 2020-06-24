/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.dao;


import com.zsmart.gestionDesSoutenances.bean.Rapporteur;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface RapporteurDao extends JpaRepository<Rapporteur, Long>{
   int deleteByProfesseurCin(String cin);
   int deleteByDoctorantCin(String cin);
   Rapporteur findByDoctorantCin(String cin);
   List<Rapporteur> findByProfesseurCin(String cin);
}
