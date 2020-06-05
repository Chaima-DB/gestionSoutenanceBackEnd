/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;


import com.zsmart.gestionDesSoutenances.bean.Specialite;
import com.zsmart.gestionDesSoutenances.dao.SpecialiteDao;
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
public class SpecialiteServiceImpl implements SpecialiteService{

    @Autowired
    SpecialiteDao specialiteDao;
   
    @Override
    public List<Specialite> findAll() {
        return specialiteDao.findAll();
    }
    
    @Transactional 
   @Override
    public int deleteByReference(String reference) {
        return specialiteDao.deleteByReference(reference);
    }

    @Override
    public Specialite findByReference(String reference) {
        return specialiteDao.findByReference(reference);
    }

    @Override
    public int save(Specialite specialite) {
        Specialite founded = findByReference(specialite.getReference());
        if (founded != null){
            return -1;
        }else{
            specialiteDao.save(specialite);
        return 1;
        }
    }

    
    
    
    
}
