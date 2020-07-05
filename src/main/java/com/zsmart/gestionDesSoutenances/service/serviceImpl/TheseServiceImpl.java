/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsmart.gestionDesSoutenances.bean.These;
import com.zsmart.gestionDesSoutenances.dao.TheseDao;
import com.zsmart.gestionDesSoutenances.service.facade.TheseService;

/**
 *
 * @author HP
 */
@Service

public class TheseServiceImpl implements TheseService {

	@Autowired
	TheseDao theseDao;
	

    @Override
    public List<These> findAll() {
        return theseDao.findAll();
    }

    @Override
    public boolean save(These these) {
        if(these != null){
        theseDao.save(these);
        return true;
        }else {
            return false;
        }
    }
	

}
