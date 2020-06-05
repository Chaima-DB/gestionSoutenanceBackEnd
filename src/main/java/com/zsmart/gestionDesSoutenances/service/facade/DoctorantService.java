/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import java.util.List;

/**
 *
 * @author HP
 */
public interface DoctorantService {

    List<Doctorant> findAll();

    int deleteByCin(String cin);

    Doctorant findByCin(String cin);
    Doctorant findByCne(String cne);

}
