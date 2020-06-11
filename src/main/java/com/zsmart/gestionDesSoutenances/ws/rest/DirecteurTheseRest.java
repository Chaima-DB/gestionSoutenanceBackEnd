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

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return directeurTheseService.deleteByCin(cin);
    }

    @GetMapping("/cin/{cin}")
    public DirecteurThese findByCin(@PathVariable String cin) {
        return directeurTheseService.findByCin(cin);
    }

    @PostMapping("/")
    public int save(@RequestBody DirecteurThese directeurThese) {
        return directeurTheseService.save(directeurThese);
    }

}
