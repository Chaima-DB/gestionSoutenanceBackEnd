/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.dao;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface DoctorantDao extends JpaRepository<Doctorant, Long>{
 Doctorant findByCin(String cin);
 Doctorant findByCne(String cne);
 int deleteByCin(String cin);
 Doctorant findByUserEmail(String email);
 
}
