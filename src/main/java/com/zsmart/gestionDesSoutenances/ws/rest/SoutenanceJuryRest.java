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
import com.zsmart.gestionDesSoutenances.bean.SoutenanceJury;
import com.zsmart.gestionDesSoutenances.service.facade.SoutenanceJuryService;

import io.swagger.annotations.Api;
@Api
@RestController
//@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("api/v1/gestionDesSoutenances-api/soutenanceJury")
public class SoutenanceJuryRest {

    @Autowired
    SoutenanceJuryService soutenanceJuryService;

    @PostMapping("/")
    public int save(@RequestBody Soutenance soutenance) {
        return soutenanceJuryService.save(soutenance, soutenance.getSoutenanceJurys());
    }

    @GetMapping("/soutenance/reference/{reference}")
    public List<SoutenanceJury> findBySoutenanceReference(@PathVariable String reference) {
        return soutenanceJuryService.findBySoutenanceReference(reference);
    }

    @DeleteMapping("/soutenance/reference/{reference}")
    public int deleteBySoutenanceReference(@PathVariable String reference) {
        return soutenanceJuryService.deleteBySoutenanceReference(reference);
    }
@GetMapping("/validate")
    public boolean validateSoutenanceJury(@RequestBody Soutenance soutenance) {
        return soutenanceJuryService.validateSoutenanceJury(soutenance, soutenance.getSoutenanceJurys());
    }

    
}
