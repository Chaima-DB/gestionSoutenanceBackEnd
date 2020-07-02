/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.Professeur;
import com.zsmart.gestionDesSoutenances.bean.Rapporteur;
import com.zsmart.gestionDesSoutenances.dao.RapporteurDao;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import com.zsmart.gestionDesSoutenances.service.facade.ProfesseurService;
import com.zsmart.gestionDesSoutenances.service.facade.RapporteurService;
import com.zsmart.gestionDesSoutenances.service.facade.SpecialiteService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class RapporteurServiceImpl implements RapporteurService {

    @Autowired
    SpecialiteService specialiteService;
    @Autowired
    RapporteurDao rapporteurDao;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    DoctorantService doctorantService;
    
    @Transactional
    @Override
    public int deleteByProfesseurCinAndDoctorantCin(String prof, String doc) {
        return rapporteurDao.deleteByProfesseurCinAndDoctorantCin(prof, doc);
    }
    @Transactional
    @Override
    public int deleteByDoctorantCin(String cin) {
        return rapporteurDao.deleteByDoctorantCin(cin);
    }

    @Override
    public List<Rapporteur> findByDoctorantCin(String cin) {
        return rapporteurDao.findByDoctorantCin(cin);
    }

    @Override
    public List<Rapporteur> findByProfesseurCin(String cin) {
        return rapporteurDao.findByProfesseurCin(cin);
    }

    @Override
    public List<Rapporteur> findAll() {
        return rapporteurDao.findAll();
    }
@Override
    public boolean validateRapporteur(Doctorant doctorant, List<Rapporteur> rapporteurs) {
           List<Rapporteur> valideRapporteur = rapporteurs.stream().filter(j -> professeurService.findByCin(j.getProfesseur().getCin()) != null ).collect(Collectors.toList());
        return valideRapporteur.size() == rapporteurs.size();
    }
    @Override
    public int save(List<Rapporteur> rapporteurs ) {
        rapporteurs.forEach(r -> {
            Professeur professeur = professeurService.findByCin(r.getProfesseur().getCin());
            Doctorant doctorant = doctorantService.findByCin(r.getDoctorant().getCin());
            r.setProfesseur(professeur);
            r.setDoctorant(doctorant);
            r.setDateAffectation(new Date());
            rapporteurDao.save(r);
        }
        );
        return 1;
        
   
    }

    @Override
    public int update(Rapporteur rapporteur, Long id) {
        Optional<Rapporteur> founded = rapporteurDao.findById(id);
        founded.get().setProfesseur(rapporteur.getProfesseur());
        founded.get().setDoctorant(rapporteur.getDoctorant());
        founded.get().setAvis(rapporteur.getAvis());
        rapporteurDao.save(rapporteur);
        return 1;
    }

    @Override
    public List<Rapporteur> findByProfesseurUserEmail(String email) {
        return rapporteurDao.findByProfesseurUserEmail(email);
    }

   
}
