/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;


import com.zsmart.gestionDesSoutenances.bean.Sujet;
import com.zsmart.gestionDesSoutenances.dao.SujetDao;
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
public class SujetServiceImpl implements SujetService{

    @Autowired
    SujetDao sujetDao;

    @Override
    public List<Sujet> findAll() {
        return sujetDao.findAll();
    }

    @Override
    public Sujet findByReference(String reference) {
        return sujetDao.findByReference(reference);
    }

    @Override
    public int save(Sujet sujet) {
        double i = Math.random();
        double j = Math.random();
        sujet.setReference("s"+i+j);
       sujetDao.save(sujet);
       
        return 1;
    }
   
    
    
    
    
    
}
