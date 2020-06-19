/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.DirecteurThese;
import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.Professeur;
import com.zsmart.gestionDesSoutenances.bean.Specialite;
import com.zsmart.gestionDesSoutenances.dao.DirecteurTheseDao;
import com.zsmart.gestionDesSoutenances.service.facade.DirecteurTheseService;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import com.zsmart.gestionDesSoutenances.service.facade.ProfesseurService;
import com.zsmart.gestionDesSoutenances.service.facade.SpecialiteService;
import java.util.Date;
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
public class DirecteurTheseServiceImpl implements DirecteurTheseService {

    @Autowired
    DirecteurTheseDao directeurTheseDao;

    @Autowired
    SpecialiteService specialiteService;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    DoctorantService doctorantService;

    @Override
    public List<DirecteurThese> findAll() {
        return directeurTheseDao.findAll();
    }

    @Override
    public int save(DirecteurThese directeurThese) {
        DirecteurThese founded = directeurTheseDao.findByDoctorantCin(directeurThese.getDoctorant().getCin());
        Specialite sp1 = specialiteService.findByReference(directeurThese.getProfesseur().getSpecialite().getReference());
        Specialite sp2 = specialiteService.findByReference(directeurThese.getDoctorant().getSpecialite().getReference());
        Professeur professeur = professeurService.findByCin(directeurThese.getProfesseur().getCin());
        Doctorant doctorant = doctorantService.findByCin(directeurThese.getDoctorant().getCin());
        if (founded != null) {
            return -1;
        } else if (sp1 != sp2) {
            return -2;
        } else {
            directeurThese.setDoctorant(doctorant);
            directeurThese.setProfesseur(professeur);
            directeurThese.setDate(new Date());
            directeurTheseDao.save(directeurThese);
            return 1;
        }

    }

    @Transactional
    @Override
    public int deleteByProfesseurCin(String cin) {
        return directeurTheseDao.deleteByProfesseurCin(cin);
    }

    @Transactional
    @Override
    public int deleteByDoctorantCin(String cin) {
        return directeurTheseDao.deleteByDoctorantCin(cin);
    }

    @Override
    public DirecteurThese findByDoctorantCin(String cin) {
        return directeurTheseDao.findByDoctorantCin(cin);
    }

    @Override
    public List<DirecteurThese> findByProfesseurCin(String cin) {
        return directeurTheseDao.findByProfesseurCin(cin);
    }

    @Override
    public int update(DirecteurThese directeurThese, Long id) {
        Optional<DirecteurThese> founded = directeurTheseDao.findById(id);
        founded.get().setProfesseur(directeurThese.getProfesseur());
        founded.get().setDoctorant(directeurThese.getDoctorant());
        directeurTheseDao.save(directeurThese);
        return 1;
    }

}
