/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.Jury;
import com.zsmart.gestionDesSoutenances.bean.Soutenance;
import com.zsmart.gestionDesSoutenances.bean.SoutenanceJury;
import com.zsmart.gestionDesSoutenances.dao.SoutenanceJuryDao;
import com.zsmart.gestionDesSoutenances.service.facade.JuryService;
import com.zsmart.gestionDesSoutenances.service.facade.SoutenanceJuryService;
import com.zsmart.gestionDesSoutenances.service.facade.SoutenanceService;
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
public class SoutenanceJuryServiceImpl implements SoutenanceJuryService {

    @Autowired
    SoutenanceJuryDao soutenanceJuryDao;

    @Autowired
    JuryService juryService;

    @Autowired
    SoutenanceService soutenanceService;

    @Override
    public boolean validateSoutenanceJury(Soutenance soutenance, List<SoutenanceJury> soutenanceJurys) {
        List<SoutenanceJury> valideJurys = soutenanceJurys.stream().filter(sj -> (juryService.findByCin(sj.getJury().getCin()) != null)).collect(Collectors.toList());
        return valideJurys.size() == soutenanceJurys.size();
    }

    /* @Override
    public boolean validateJury(Soutenance soutenance, List<SoutenanceJury> soutenanceJurys) {
        List<SoutenanceJury> validespecialite = soutenanceJurys.stream().filter(sj -> (sj.getJury().getSpecialite().getReference().equals(soutenance.getDoctorant().getSpecialite().getReference()))).collect(Collectors.toList());
        return validespecialite.size() == soutenanceJurys.size();
    }
    */

    @Override
    public int save(Soutenance soutenance, List<SoutenanceJury> soutenanceJurys) {
        soutenanceJurys.forEach(j -> {
            j.setSoutenance(soutenance);
            Jury jury = juryService.findByCin(j.getJury().getCin());
            j.setJury(jury);
            soutenanceJuryDao.save(j);
        }
        );
        return 1;
    }

    @Override
    public List<SoutenanceJury> findBySoutenanceReference(String reference) {
        return soutenanceJuryDao.findBySoutenanceReference(reference);
    }

    @Transactional
    @Override
    public int deleteBySoutenanceReference(String reference) {
        return soutenanceJuryDao.deleteBySoutenanceReference(reference);
    }

}
