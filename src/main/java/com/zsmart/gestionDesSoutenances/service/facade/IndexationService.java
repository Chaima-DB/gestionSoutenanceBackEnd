/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import com.zsmart.gestionDesSoutenances.bean.Indexation;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IndexationService {

    List<Indexation> findAll();

    Indexation findByLibelle(String libelle);
    
    Indexation findByReference(String reference);

    int save(Indexation indexation);
}
