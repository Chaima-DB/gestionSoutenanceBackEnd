/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;


import com.zsmart.gestionDesSoutenances.bean.Indexation;
import com.zsmart.gestionDesSoutenances.bean.Sujet;
import com.zsmart.gestionDesSoutenances.dao.IndexationDao;
import com.zsmart.gestionDesSoutenances.dao.SujetDao;
import com.zsmart.gestionDesSoutenances.service.facade.IndexationService;
import com.zsmart.gestionDesSoutenances.service.facade.SujetService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class IndexationServiceImpl implements IndexationService{

    @Autowired
    IndexationDao indexationDao;

    @Override
    public List<Indexation> findAll() {
        return indexationDao.findAll();
    }

    @Override
    public Indexation findByLibelle(String libelle) {
        return indexationDao.findByLibelle(libelle);
    }

    @Override
    public int save(Indexation indexation) {
        Indexation indexationFound = indexationDao.findByLibelle(indexation.getLibelle());
        if(indexationFound != null) {
        return -1;
        }else {
            indexationDao.save(indexation);
            return 1;
        }
    }

       
}
