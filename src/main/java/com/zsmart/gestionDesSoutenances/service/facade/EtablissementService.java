/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;


import com.zsmart.gestionDesSoutenances.bean.Etablissement;
import java.util.List;
import net.bytebuddy.TypeCache.Sort;

/**
 *
 * @author HP
 */
public interface EtablissementService {
    List<Etablissement> findAll();
    int deleteByReference(String reference);
   Etablissement findByReference(String reference);
    int save(Etablissement etablissement);
}
