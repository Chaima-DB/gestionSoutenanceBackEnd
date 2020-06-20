/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.ws.rest;

import com.zsmart.gestionDesSoutenances.bean.Sujet;
import com.zsmart.gestionDesSoutenances.service.facade.SujetService;

import io.swagger.annotations.Api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api
@RestController
//@CrossOrigin(origins = {"http://localhost:4200"})
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/gestionDesSoutenances-api/sujet")
public class SujetRest {
    @Autowired
    SujetService sujetService;
    
    @GetMapping("/")
    public List<Sujet> findAll() {
        return sujetService.findAll();
    }
    @GetMapping("/reference/{reference}")
    public Sujet findByReference(@PathVariable String reference) {
        return sujetService.findByReference(reference);
    }
    @PostMapping("/")
    public int save(@RequestBody Sujet sujet) {
        return sujetService.save(sujet);
    }
    
    
}
