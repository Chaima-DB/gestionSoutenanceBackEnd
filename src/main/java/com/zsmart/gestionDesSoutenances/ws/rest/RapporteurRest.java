package com.zsmart.gestionDesSoutenances.ws.rest;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsmart.gestionDesSoutenances.bean.Rapporteur;
import com.zsmart.gestionDesSoutenances.service.facade.RapporteurService;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;

@Api
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})

@RequestMapping("api/v1/gestionDesSoutenances-api/rapporteur")
public class RapporteurRest {

    @Autowired
    RapporteurService rapporteurService;
    
    @DeleteMapping("/profCin/{profCin}/docCin/{docCin}")
    public int deleteByProfesseurCinAndDoctorantCin(String profCin, String docCin) {
        return rapporteurService.deleteByProfesseurCinAndDoctorantCin(profCin, docCin);
    }
    @DeleteMapping("/cinDoc/{cin}")
    public int deleteByDoctorantCin(@PathVariable String cin) {
        return rapporteurService.deleteByDoctorantCin(cin);
    }

    @GetMapping("/cinDoc/{cin}")
    public List<Rapporteur> findByDoctorantCin(@PathVariable String cin) {
        return rapporteurService.findByDoctorantCin(cin);
    }

    @GetMapping("/cinProf/{cin}")
    public List<Rapporteur> findByProfesseurCin(@PathVariable String cin) {
        return rapporteurService.findByProfesseurCin(cin);
    }

    @GetMapping("/")
    public List<Rapporteur> findAll() {
        return rapporteurService.findAll();
    }

    @PutMapping("/id/{id}")
    public int update(@RequestBody Rapporteur rapporteur, @PathVariable Long id) {
        return rapporteurService.update(rapporteur, id);
    }

    @GetMapping("/UserEmail/{email}")
    public List<Rapporteur> findByProfesseurUserEmail(String email) {
        return rapporteurService.findByProfesseurUserEmail(email);
    }
    @PostMapping("/")
    public int save(@RequestBody List<Rapporteur> rapporteurs) {
        return rapporteurService.save(rapporteurs);
    }

}
