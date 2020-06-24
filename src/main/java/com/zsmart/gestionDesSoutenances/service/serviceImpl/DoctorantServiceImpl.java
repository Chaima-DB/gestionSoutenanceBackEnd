/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.Specialite;
import com.zsmart.gestionDesSoutenances.bean.StructureDeRecherche;
import com.zsmart.gestionDesSoutenances.dao.DoctorantDao;
import com.zsmart.gestionDesSoutenances.service.facade.DirecteurTheseService;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import com.zsmart.gestionDesSoutenances.service.facade.SpecialiteService;
import com.zsmart.gestionDesSoutenances.service.facade.StructureDeRechercheService;
import com.zsmart.gestionDesSoutenances.service.facade.SujetService;
import com.zsmart.gestionDesSoutenances.service.facade.UserService;

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
public class DoctorantServiceImpl implements DoctorantService {

    @Autowired
    DoctorantDao doctorantDao;
    @Autowired
    DirecteurTheseService directeurTheseService;
    @Autowired
    SujetService sujetService;
    @Autowired
    StructureDeRechercheService structureDeRechercheService;
    @Autowired
    SpecialiteService specialiteService;
    @Autowired
    UserService userService;

    @Override
    public List<Doctorant> findAll() {
        return doctorantDao.findAll();
    }

    @Transactional
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
        Specialite specialite = specialiteService.findByReference(doctorant.getSpecialite().getReference());
        StructureDeRecherche structure = structureDeRechercheService
                .findByReference(doctorant.getStructureDeRecherche().getReference());
        if (founded != null) {
            return -1;
        } else {
            userService.save(doctorant.getUser());
            sujetService.save(doctorant.getSujet());
            doctorant.setSpecialite(specialite);
            doctorant.setStructureDeRecherche(structure);
            userService.addRoletouser(doctorant.getUser().getEmail(), "ROLE_USER");
            doctorantDao.save(doctorant);
            return 1;
        }

    }

    @Override
    public int update(Doctorant doctorant, Long id) {
        Optional<Doctorant> founded = doctorantDao.findById(id);
        if (founded != null) {
            founded.get().setCne(doctorant.getCne());
            founded.get().setCin(doctorant.getCin());
            founded.get().setDateInscription(doctorant.getDateInscription());
            founded.get().setTel(doctorant.getTel());
            founded.get().setSexe(doctorant.getSexe());

            doctorantDao.save((founded.get()));
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int updateDoctorat(Doctorant doctorant, Long id) {
        Optional<Doctorant> founded = doctorantDao.findById(id);
        if (founded != null) {
            founded.get().setStructureDeRecherche(doctorant.getStructureDeRecherche());
            founded.get().setSpecialite(doctorant.getSpecialite());
            founded.get().setDirecteurThese(doctorant.getDirecteurThese());
            doctorantDao.save((founded.get()));
            return 1;
        } else {
            return -1;
        }
    }

}
