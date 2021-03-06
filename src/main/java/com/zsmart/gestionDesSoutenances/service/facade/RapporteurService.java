/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.Rapporteur;
import java.util.List;

/**
 *
 * @author HP
 */
public interface RapporteurService {

    int deleteByProfesseurCinAndDoctorantCin(String profCin, String docCin);
    
    Rapporteur findByProfesseurCinAndDoctorantCin(String profCin, String docCin);

    int deleteByDoctorantCin(String cin);

    List<Rapporteur> findByDoctorantCin(String cin);

    List<Rapporteur> findByProfesseurCin(String cin);

    List<Rapporteur> findAll();

    int save(List<Rapporteur> rapporteurs);

    int update(Rapporteur rapporteur, Long id);

    List<Rapporteur> findByProfesseurUserEmail(String email);
    
    boolean validateRapporteur(Doctorant doctorant, List<Rapporteur> rapporteurs);

}
