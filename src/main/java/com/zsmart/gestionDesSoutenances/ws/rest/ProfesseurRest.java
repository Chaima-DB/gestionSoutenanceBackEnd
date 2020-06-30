/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.ws.rest;

import com.zsmart.gestionDesSoutenances.bean.Professeur;
import com.zsmart.gestionDesSoutenances.service.facade.ProfesseurService;

import io.swagger.annotations.Api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("api/v1/gestionDesSoutenances-api/professeur")
public class ProfesseurRest {
    @Autowired
    ProfesseurService professeurService;
@GetMapping("/")
    public List<Professeur> findAll() {
        return professeurService.findAll();
    }
@GetMapping("/cin/{cin}")
    public Professeur findByCin(@PathVariable String cin) {
        return professeurService.findByCin(cin);
    }
@PostMapping("/")
    public int save(@RequestBody Professeur professeur) {
        return professeurService.save(professeur);
    }
@DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return professeurService.deleteByCin(cin);
    }
@GetMapping("/email/{email}")
    public Professeur findByUserEmail(@PathVariable String email) {
        return professeurService.findByUserEmail(email);
    }
    
    
    
    
}
