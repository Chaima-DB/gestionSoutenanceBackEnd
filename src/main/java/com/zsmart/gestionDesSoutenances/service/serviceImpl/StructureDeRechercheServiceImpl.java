/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import java.util.List;
import com.zsmart.gestionDesSoutenances.bean.Etablissement;
import com.zsmart.gestionDesSoutenances.bean.StructureDeRecherche;
import com.zsmart.gestionDesSoutenances.dao.StructureDeRechercheDao;
import com.zsmart.gestionDesSoutenances.service.facade.EtablissementService;
import com.zsmart.gestionDesSoutenances.service.facade.StructureDeRechercheService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class StructureDeRechercheServiceImpl implements StructureDeRechercheService{

    @Autowired
    StructureDeRechercheDao structureDeRechercheDao;
    
    @Autowired
    EtablissementService etablissementService;
    
    @Override
    public List<StructureDeRecherche> findAll() {
        return  structureDeRechercheDao.findAll();
    }

    @Override
    public List<StructureDeRecherche> findByEtablissementReference(String reference) {
        return structureDeRechercheDao.findByEtablissementReference(reference);
    }

    @Override
    public int save(StructureDeRecherche structureDeRecherche) {
        StructureDeRecherche founded = findByReference(structureDeRecherche.getReference());
        Etablissement etablissement = etablissementService
                .findByReference(structureDeRecherche.getEtablissement().getReference());
        if(founded != null){
            return -1;
        }else if(etablissement != null){
        structureDeRecherche.setEtablissement(etablissement);
        structureDeRechercheDao.save(structureDeRecherche);
        return 1;
        }
        else{
        return -3;
        }
        
    }

    @Override
    public int deleteByEtablissementNom(String nom) {
       return structureDeRechercheDao.deleteByEtablissementNom(nom);
    }
    
    @Override
    public StructureDeRecherche findByReference(String reference) {
        return structureDeRechercheDao.findByReference(reference);
}
    @Transactional
    @Override
    public int deleteByReference(String reference) {
        StructureDeRecherche str = structureDeRechercheDao.findByReference(reference);
        if(str != null){
        return structureDeRechercheDao.deleteByReference(reference);
        }else return -1;
    }
}