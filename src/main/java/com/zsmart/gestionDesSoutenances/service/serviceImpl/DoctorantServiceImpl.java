/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;


import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.dao.DoctorantDao;
import com.zsmart.gestionDesSoutenances.service.facade.DirecteurTheseService;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import com.zsmart.gestionDesSoutenances.service.facade.StructureDeRechercheService;
import com.zsmart.gestionDesSoutenances.service.facade.SujetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class DoctorantServiceImpl implements DoctorantService{

    @Autowired
    DoctorantDao doctorantDao;
    @Autowired
    DirecteurTheseService directeurTheseService;
    @Autowired
    SujetService sujetService;
    @Autowired
    StructureDeRechercheService structureDeRechercheService;

    @Override
    public List<Doctorant> findAll() {
        return doctorantDao.findAll();
    }

    @Override
    public int deleteByCin(String cin) {
        return doctorantDao.deleteByCin(cin);
    }

    @Override
    public Doctorant findByCin(String cin) {
        return doctorantDao.findByCin(cin);
    }

    @Override
    public Doctorant findByCne(String cne) {
       return doctorantDao.findByCne(cne);
    }

    @Override
    public int save(Doctorant doctorant) {
        Doctorant founded = doctorantDao.findByCin(doctorant.getCin());
        if(founded!= null){
        return -1;
        }else{
        doctorant.setStructureDeRecherche(doctorant.getStructureDeRecherche());
        sujetService.save(doctorant.getSujet());
        return 1;
        }
    }

    
    
    
    
    
}
