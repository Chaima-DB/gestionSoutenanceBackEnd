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

import com.zsmart.gestionDesSoutenances.bean.DirecteurThese;
import com.zsmart.gestionDesSoutenances.service.facade.DirecteurTheseService;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;

@Api
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})

@RequestMapping("api/v1/gestionDesSoutenances-api/directeurThese")
public class DirecteurTheseRest {

    @Autowired
    DirecteurTheseService directeurTheseService;

    @GetMapping("/")
    public List<DirecteurThese> findAll() {
        return directeurTheseService.findAll();
    }

    @DeleteMapping("/profCin/{cin}")
    public int deleteByProfesseurCin(@PathVariable String cin) {
        return directeurTheseService.deleteByProfesseurCin(cin);
    }

    @DeleteMapping("/docCin/{cin}")
    public int deleteByDoctorantCin(@PathVariable String cin) {
        return directeurTheseService.deleteByDoctorantCin(cin);
    }

    @GetMapping("/docCin/{cin}")
    public DirecteurThese findByDoctorantCin(@PathVariable String cin) {
        return directeurTheseService.findByDoctorantCin(cin);
    }


    @PostMapping("/")
    public int save(@RequestBody DirecteurThese directeurThese) {
        return directeurTheseService.save(directeurThese);
    }

    @PutMapping("/id/{id}")
    public int update(@RequestBody DirecteurThese directeurThese, @PathVariable Long id) {
        return directeurTheseService.update(directeurThese, id);
    }
    @GetMapping("/email/{email}")
    public List<DirecteurThese> findByProfesseurUserEmail(@PathVariable String email) {
        return directeurTheseService.findByProfesseurUserEmail(email);
    }

}
