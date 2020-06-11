package com.zsmart.gestionDesSoutenances.ws.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsmart.gestionDesSoutenances.bean.Etablissement;
import com.zsmart.gestionDesSoutenances.service.facade.EtablissementService;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
@Api
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("api/v1/gestionDesSoutenances-api/etablissement")
public class EtablissementRest {

	@Autowired
        EtablissementService etablissementService;

        @GetMapping("/")
    public List<Etablissement> findAll( ) {
        return etablissementService.findAll();
    }
        @GetMapping("/reference/{reference}")
    public Etablissement findByReference(@PathVariable String reference) {
        return etablissementService.findByReference(reference);
    }
        @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return etablissementService.deleteByReference(reference);
    }
        @PostMapping("/")
    public int save(@RequestBody Etablissement etablissement) {
        return etablissementService.save(etablissement);
    }
        


}
