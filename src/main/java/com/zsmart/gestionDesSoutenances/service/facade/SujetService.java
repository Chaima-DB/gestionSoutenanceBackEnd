/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;



import com.zsmart.gestionDesSoutenances.bean.Sujet;
import java.util.List;

/**
 *
 * @author HP
 */
public interface SujetService {
    List<Sujet> findAll();
    Sujet findByReference(String reference);
    int save(Sujet  sujet);
}
