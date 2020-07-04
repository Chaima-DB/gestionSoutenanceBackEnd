/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import com.zsmart.gestionDesSoutenances.bean.DirecteurThese;
import java.util.List;

/**
 *
 * @author HP
 */
public interface DirecteurTheseService {

    List<DirecteurThese> findAll();

    int save(DirecteurThese directeurThese);
    
    int update(DirecteurThese directeurThese, Long id);

    int deleteByProfesseurCin(String cin);

    int deleteByDoctorantCin(String cin);

    DirecteurThese findByDoctorantCin(String cin);
    
    DirecteurThese findByDoctorantUserEmail(String email);

    List<DirecteurThese> findByProfesseurUserEmail(String email);

    
}
