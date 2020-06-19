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
public interface JuryService {

    int save(Soutenance soutenance, List<Jury> jurys);

    boolean validateJury(Soutenance soutenance, List<Jury> jurys);

    List<Jury> findBySoutenanceReference(String reference);

    int deleteBySoutenanceReference(String reference);
    
    List<Jury> findAll();
    
    int update(Jury jury, Long id);

}
