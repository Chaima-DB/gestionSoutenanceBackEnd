/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import com.zsmart.gestionDesSoutenances.bean.Jury;
import java.util.List;

/**
 *
 * @author HP
 */
public interface JuryService {

    List<Jury> findAll();

    int deleteByCin(String cin);

    Jury findByCin(String cin);

    int save(Jury jury);
}
