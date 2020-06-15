/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;


import com.zsmart.gestionDesSoutenances.bean.Etablissement;
import com.zsmart.gestionDesSoutenances.bean.StructureDeRecherche;
import com.zsmart.gestionDesSoutenances.dao.EtablissementDao;
import com.zsmart.gestionDesSoutenances.service.facade.EtablissementService;
import com.zsmart.gestionDesSoutenances.service.facade.StructureDeRechercheService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class EtablissementServiceImpl implements EtablissementService{

    @Autowired
    EtablissementDao etablissementDao;
    
    @Autowired
    StructureDeRechercheService structureDeRechercheService;

    @Override
    public List<Etablissement> findAll() {
        return etablissementDao.findAll();
    }

    @Override
    public int save(Etablissement etablissement) {
        Etablissement founded = findByReference(etablissement.getReference());
        if (founded != null){
            return -1;
        }else if(etablissement.getReference()== null || "".equals(etablissement.getReference()) ) {
            return -2;
        }else{
            etablissementDao.save(etablissement);
        return 1;
        }
    }
    @Transactional
    @Override
    public int deleteByReference(String reference) {
        List<StructureDeRecherche> strs =  structureDeRechercheService.findByEtablissementReference(reference);
        strs.forEach(s -> {
        structureDeRechercheService.deleteByReference(s.getReference());
        });
        return etablissementDao.deleteByReference(reference);
    }

    @Override
    public Etablissement findByReference(String reference) {
        return etablissementDao.findByReference(reference);
    }

    @Override
    public Etablissement update(Etablissement etablissement) {
        return etablissementDao.save(etablissement);
        
    }
    
    
    
}
