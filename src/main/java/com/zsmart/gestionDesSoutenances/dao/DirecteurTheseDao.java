/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.dao;


import com.zsmart.gestionDesSoutenances.bean.DirecteurThese;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface DirecteurTheseDao extends JpaRepository<DirecteurThese, Long>{
   int deleteByProfesseurCin(String cin);
   int deleteByDoctorantCin(String cin);
   DirecteurThese findByDoctorantCin(String cin);
   DirecteurThese findByDoctorantUserEmail(String email);
   List<DirecteurThese> findByProfesseurCin(String cin);
   List<DirecteurThese> findByProfesseurUserEmail(String email);
}
