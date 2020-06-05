/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.Jury;
import com.zsmart.gestionDesSoutenances.bean.Specialite;
import com.zsmart.gestionDesSoutenances.dao.JuryDao;
import com.zsmart.gestionDesSoutenances.service.facade.JuryService;
import com.zsmart.gestionDesSoutenances.service.facade.SpecialiteService;
import java.util.List;
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
    SpecialiteService specialiteService;

   
    @Override
    public int save(Jury jury) {
        Jury founded = juryDao.findByCin(jury.getCin());
        Specialite sp = specialiteService.findByReference(jury.getSpecialite().getReference());
        if (founded != null) {
            return -1;
        } else if (sp == null) {
            return -2;
        } else {
            jury.setSpecialite(sp);
            juryDao.save(jury);
            return 1;
        }

    }

    @Override
    public List<Jury> findAll() {
        return juryDao.findAll();
    }
    @Transactional
    @Override
    public int deleteByCin(String cin) {
        return juryDao.deleteByCin(cin);
    }

    @Override
    public Jury findByCin(String cin) {
        return juryDao.findByCin(cin);
    }


}
