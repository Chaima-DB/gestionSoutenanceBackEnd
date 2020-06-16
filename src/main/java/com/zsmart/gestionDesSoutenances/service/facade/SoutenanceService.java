/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import com.zsmart.gestionDesSoutenances.bean.Jury;
import com.zsmart.gestionDesSoutenances.bean.Soutenance;
import java.util.List;

/**
 *
 * @author HP
 */
public interface SoutenanceService {

    List<Soutenance> findAll();

    Soutenance findByReference(String reference);

    Soutenance findByDoctorantCne(String cne);

    Soutenance findByDoctorantCin(String cin);

    int deleteByReference(String reference);

    int save(Soutenance soutenance, List<Jury> jurys);
   

}
