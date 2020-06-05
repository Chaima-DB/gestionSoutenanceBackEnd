/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.Soutenance;
import com.zsmart.gestionDesSoutenances.bean.SoutenanceJury;
import com.zsmart.gestionDesSoutenances.bean.Specialite;
import com.zsmart.gestionDesSoutenances.dao.SoutenanceDao;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import com.zsmart.gestionDesSoutenances.service.facade.SoutenanceJuryService;
import com.zsmart.gestionDesSoutenances.service.facade.SoutenanceService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author HP
 */
@Service
public class SoutenanceServiceImpl implements SoutenanceService {

    @Autowired
    SoutenanceDao soutenanceDao;

    @Autowired
    SoutenanceJuryService soutenanceJuryService;

    @Autowired
    DoctorantService doctorantService;

    @Override
    public Soutenance findByDoctorantCne(String cne) {
        return soutenanceDao.findByDoctorantCne(cne);
    }

    @Override
    public Soutenance findByDoctorantCin(String cin) {
        return soutenanceDao.findByDoctorantCin(cin);
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        int resSoutenanceJury = soutenanceJuryService.deleteBySoutenanceReference(reference);
        int resSoutenance = soutenanceDao.deleteByReference(reference);
        return resSoutenanceJury * resSoutenance;
    }

    @Override
    public int save(Soutenance soutenance, List<SoutenanceJury> soutenanceJurys) {
        Soutenance foundedsoutenance = findByReference(soutenance.getReference());
        Soutenance doctorantUniqueSoutenance = findByDoctorantCne(soutenance.getDoctorant().getCne());
        Doctorant doctorant = doctorantService.findByCne(soutenance.getDoctorant().getCne());
        if (foundedsoutenance != null) {
            return -1;
        } else if (doctorant == null) {
            return -2;
        } else if (doctorantUniqueSoutenance != null) {
            return -3;
        } else if (!soutenanceJuryService.validateSoutenanceJury(soutenance, soutenanceJurys)) {
            return -4;
        } else {
            
            soutenance.setDoctorant(doctorant);
            soutenanceDao.save(soutenance);
            soutenanceJuryService.save(soutenance, soutenanceJurys);
            return 1; 
           
        }
    }

    @Override
    public List<Soutenance> findAll() {
        return soutenanceDao.findAll();
    }

    @Override
    public Soutenance findByReference(String reference) {
        return soutenanceDao.findByReference(reference);
    }


    
}
