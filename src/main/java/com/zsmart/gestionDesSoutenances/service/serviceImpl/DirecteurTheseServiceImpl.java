/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.DirecteurThese;
import com.zsmart.gestionDesSoutenances.bean.Specialite;
import com.zsmart.gestionDesSoutenances.dao.DirecteurTheseDao;
import com.zsmart.gestionDesSoutenances.service.facade.DirecteurTheseService;
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
public class DirecteurTheseServiceImpl implements DirecteurTheseService {

    @Autowired
    DirecteurTheseDao directeurTheseDao;

    @Autowired
    SpecialiteService specialiteService;

    @Override
    public List<DirecteurThese> findAll() {
        return directeurTheseDao.findAll();
    }
    
    @Transactional
    @Override
    public int deleteByCin(String cin) {
        return directeurTheseDao.deleteByCin(cin);
    }

    @Override
    public DirecteurThese findByCin(String cin) {
        return directeurTheseDao.findByCin(cin);
    }

    @Override
    public int save(DirecteurThese directeurThese) {
        DirecteurThese founded = directeurTheseDao.findByCin(directeurThese.getCin());
        Specialite sp = specialiteService.findByReference(directeurThese.getSpecialite().getReference());
        if (founded != null) {
            return -1;
        } else if (sp == null) {
            return -2;
        } else {
            directeurThese.setSpecialite(sp);
            directeurTheseDao.save(directeurThese);
            return 1;
        }

    }

}
