/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.Jury;
import com.zsmart.gestionDesSoutenances.bean.Soutenance;
import com.zsmart.gestionDesSoutenances.dao.SoutenanceDao;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import com.zsmart.gestionDesSoutenances.service.facade.JuryService;
import com.zsmart.gestionDesSoutenances.service.facade.SoutenanceService;
import java.util.List;
import java.util.Optional;

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
    JuryService juryService;

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
        int resJury = juryService.deleteBySoutenanceReference(reference);
        int resSoutenance = soutenanceDao.deleteByReference(reference);
        return resJury * resSoutenance;
    }

    @Override
    public int save(Soutenance soutenance, List<Jury> jurys) {
        Soutenance foundedsoutenance = findByReference(soutenance.getReference());
        Soutenance doctorantUniqueSoutenance = findByDoctorantCin(soutenance.getDoctorant().getCin());
        Doctorant doctorant = doctorantService.findByCin(soutenance.getDoctorant().getCin());
        if (foundedsoutenance != null) {
            return -1;
        } else if (doctorant == null) {
            return -2;
        } else if (doctorantUniqueSoutenance != null) {
            return -3;
        } else if (!juryService.validateJury(soutenance, jurys)) {
            return -4;
        } else {
            soutenance.setDoctorant(doctorant);
            soutenanceDao.save(soutenance);
            juryService.save(soutenance, jurys);
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

    @Override
    public int update(Soutenance soutenance, Long id) {
        Optional<Soutenance> founded = soutenanceDao.findById(id);
        if (founded != null) {
            founded.get().setDoctorant(soutenance.getDoctorant());
            founded.get().setReference(soutenance.getReference());
            founded.get().setDateSoutenance(soutenance.getDateSoutenance());
            founded.get().setHeureSoutenance(soutenance.getHeureSoutenance());
            soutenanceDao.save((founded.get()));
            return 1;
        }
        return -1;
    }

}
