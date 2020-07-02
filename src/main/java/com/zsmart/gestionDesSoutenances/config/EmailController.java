/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.config;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@Api
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/email")
public class EmailController {
    @Autowired 
    EmailServiceImpl emailServiceImpl;
    
    @PostMapping("/")
    public void sendEmailToDoctorant(@RequestBody Doctorant doctorant) {
        emailServiceImpl.sendEmailToDoctorant(doctorant);
    }
}
