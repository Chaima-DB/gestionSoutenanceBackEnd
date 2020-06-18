/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.Jury;
import com.zsmart.gestionDesSoutenances.bean.Professeur;
import com.zsmart.gestionDesSoutenances.bean.Soutenance;
import com.zsmart.gestionDesSoutenances.dao.JuryDao;
import com.zsmart.gestionDesSoutenances.service.facade.JuryService;
import com.zsmart.gestionDesSoutenances.service.facade.ProfesseurService;
import com.zsmart.gestionDesSoutenances.service.facade.SoutenanceService;
import com.zsmart.gestionDesSoutenances.service.facade.SpecialiteService;
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
public class JuryServiceImpl implements JuryService {

    @Autowired
    JuryDao juryDao;
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    SoutenanceService soutenanceService;

    @Autowired
    SpecialiteService specialiteService;

    @Override
    public int save(Soutenance soutenance, List<Jury> jurys) {
        jurys.forEach(j -> {
            j.setSoutenance(soutenance);
            Professeur professeur = professeurService.findByCin(j.getProfesseur().getCin());
            j.setProfesseur(professeur);
            juryDao.save(j);
        }
        );
        return 1;
    }

    @Override
    public boolean validateJury(Soutenance soutenance, List<Jury> jurys) {
           List<Jury> valideJury = jurys.stream().filter(j -> professeurService.findByCin(j.getProfesseur().getCin()) != null ).collect(Collectors.toList());
        return valideJury.size() == jurys.size();
    }

    @Override
    public List<Jury> findBySoutenanceReference(String reference) {
        return juryDao.findBySoutenanceReference(reference);
    }
@Transactional
    @Override
    public int deleteBySoutenanceReference(String reference) {
        return juryDao.deleteBySoutenanceReference(reference);
    }

    @Override
    public List<Jury> findAll() {
        return juryDao.findAll();
    }

   


}
