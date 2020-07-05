/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import java.util.List;

import com.zsmart.gestionDesSoutenances.bean.These;

/**
 *
 * @author HP
 */
public interface TheseService {

    List<These> findAll();

    boolean save(These these);

}
