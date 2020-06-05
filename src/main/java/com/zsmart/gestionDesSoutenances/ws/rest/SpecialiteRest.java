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

import com.zsmart.gestionDesSoutenances.bean.Specialite;
import com.zsmart.gestionDesSoutenances.service.facade.SpecialiteService;

import io.swagger.annotations.Api;
@Api
@RestController
//@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("api/v1/gestionDesSoutenances-api/specialite")
public class SpecialiteRest {

	@Autowired
        SpecialiteService specialiteService;

        @GetMapping("/")
    public List<Specialite> findAll() {
        return specialiteService.findAll();
    }
        @GetMapping("/reference/{reference}")
    public Specialite findByReference(@PathVariable String reference) {
        return specialiteService.findByReference(reference);
    }
        @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return specialiteService.deleteByReference(reference);
    }
        @PostMapping("/")
    public int save(@RequestBody Specialite specialite) {
        return specialiteService.save(specialite);
    }
        


}
