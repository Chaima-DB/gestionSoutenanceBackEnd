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
    int deleteByCin(String cin);
   DirecteurThese findByCin(String cin);
   int save(DirecteurThese directeurThese);
}
