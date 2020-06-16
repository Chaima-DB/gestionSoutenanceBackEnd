/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import com.zsmart.gestionDesSoutenances.bean.Professeur;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ProfesseurService {

    List<Professeur> findAll();

    Professeur findByCin(String cin);

    int save(Professeur professeur);

    int deleteByCin(String cin);
}
