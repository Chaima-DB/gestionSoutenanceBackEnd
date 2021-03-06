/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;


import com.zsmart.gestionDesSoutenances.bean.Jury;
import com.zsmart.gestionDesSoutenances.bean.Professeur;
import com.zsmart.gestionDesSoutenances.bean.Specialite;
import com.zsmart.gestionDesSoutenances.dao.ProfesseurDao;
import com.zsmart.gestionDesSoutenances.service.facade.JuryService;
import com.zsmart.gestionDesSoutenances.service.facade.ProfesseurService;
import com.zsmart.gestionDesSoutenances.service.facade.SpecialiteService;
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
public class ProfesseurServiceImpl implements ProfesseurService{

    @Autowired
    ProfesseurDao professeurDao;
    @Autowired
    UserService userService;
    @Autowired
    SpecialiteService specialiteService;
    @Autowired
    JuryService  juryService;
   

    @Override
    public Professeur findByCin(String cin) {
        return professeurDao.findByCin(cin);
    }

    @Override
    public int save(Professeur professeur) {
        Professeur founded = professeurDao.findByCin(professeur.getCin());
        Specialite sp = specialiteService.findByReference(professeur.getSpecialite().getReference());
        if(founded != null){
        return -1;
        }else if (sp == null) {
            return -2;
        }else{
            professeur.setSpecialite(sp);
            userService.save(professeur.getUser());
            userService.addRoletouser(professeur.getUser().getEmail(), "ROLE_PROF");
            professeurDao.save(professeur);
        return 1;
        }
    }

    @Override
    public List<Professeur> findAll() {
        return professeurDao.findAll();
    }
    @Transactional
    @Override
    public int deleteByCin(String cin) {
        return professeurDao.deleteByCin(cin);
    }

    @Override
    public Professeur findByUserEmail(String email) {
        return professeurDao.findByUserEmail(email);
    }

    @Override
    public void addJuryToProfesseur(String cin, Long id) {
        Optional<Jury> jury = juryService.findById(id);
        Professeur professeur = professeurDao.findByCin(cin);
        professeur.getJurys().add(jury.get());
    }
   
    
    
    
    
    
}
