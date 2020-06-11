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

import com.zsmart.gestionDesSoutenances.bean.Soutenance;
import com.zsmart.gestionDesSoutenances.service.facade.SoutenanceService;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
@Api
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("api/v1/gestionDesSoutenances-api/soutenance")
public class SoutenanceRest {

    @Autowired
    SoutenanceService soutenanceService;

    @GetMapping("/")
    public List<Soutenance> findAll() {
        return soutenanceService.findAll();
    }

    @GetMapping("/reference/{reference}")
    public Soutenance findByReference(@PathVariable String reference) {
        return soutenanceService.findByReference(reference);
    }

    @GetMapping("/doctorant/cne/{cne}")
    public Soutenance findByDoctorantCne(@PathVariable String cne) {
        return soutenanceService.findByDoctorantCne(cne);
    }

    @GetMapping("/doctorant/cin/{cin}")
    public Soutenance findByDoctorantCin(@PathVariable String cin) {
        return soutenanceService.findByDoctorantCin(cin);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return soutenanceService.deleteByReference(reference);
    }

    @PostMapping("/")
    public int save(@RequestBody Soutenance soutenance) {
        return soutenanceService.save(soutenance, soutenance.getSoutenanceJurys());
    }

    
    

}
