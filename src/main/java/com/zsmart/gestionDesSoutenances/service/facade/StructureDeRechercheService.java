/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;


import com.zsmart.gestionDesSoutenances.bean.StructureDeRecherche;
import java.util.List;

/**
 *
 * @author HP
 */
public interface StructureDeRechercheService {
    List<StructureDeRecherche> findAll();
    List<StructureDeRecherche> findByEtablissementReference(String reference);
    StructureDeRecherche findByReference(String reference);
    int deleteByEtablissementNom(String nom);
    int deleteByReference(String reference);
    int save(StructureDeRecherche structureDeRecherche);
}
