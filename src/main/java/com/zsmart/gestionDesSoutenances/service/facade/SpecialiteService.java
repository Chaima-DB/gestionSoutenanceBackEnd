/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;


import com.zsmart.gestionDesSoutenances.bean.Specialite;
import java.util.List;

/**
 *
 * @author HP
 */
public interface SpecialiteService {
    List<Specialite> findAll();
    int deleteByReference(String reference);
    Specialite findByReference(String reference);
    int save(Specialite  specialite);
}
