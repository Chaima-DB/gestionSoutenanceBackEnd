package com.zsmart.gestionDesSoutenances.ws.rest;

import com.zsmart.gestionDesSoutenances.bean.Jury;
import com.zsmart.gestionDesSoutenances.bean.Soutenance;
import com.zsmart.gestionDesSoutenances.service.facade.JuryService;

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
@RequestMapping("api/v1/gestionDesSoutenances-api/jury")
public class JuryRest {

    @Autowired
    JuryService juryService;

    @PostMapping("/")
    public int save(@RequestBody Soutenance soutenance) {
        return juryService.save(soutenance, soutenance.getJurys());
    }

    public boolean validateJury(Soutenance soutenance, List<Jury> jurys) {
        return juryService.validateJury(soutenance, jurys);
    }

    @GetMapping("/soutenance/reference/{reference}")
    public List<Jury> findBySoutenanceReference(@PathVariable String reference) {
        return juryService.findBySoutenanceReference(reference);
    }

    @DeleteMapping("/soutenance/reference/{reference}")
    public int deleteBySoutenanceReference(@PathVariable String reference) {
        return juryService.deleteBySoutenanceReference(reference);
    }
    @GetMapping("/")
    public List<Jury> findAll() {
        return juryService.findAll();
    }

}
