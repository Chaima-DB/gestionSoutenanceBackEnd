package com.zsmart.gestionDesSoutenances.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsmart.gestionDesSoutenances.bean.These;
import com.zsmart.gestionDesSoutenances.service.facade.TheseService;

import io.swagger.annotations.Api;

@Api
@RestController

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("api/v1/gestionDesSoutenances-api/these")
public class TheseRest {

    @Autowired
    TheseService theseService;

    @GetMapping("/cin/{cin}")
    public List<These> findByDoctorantCin(@PathVariable String cin) {
        return theseService.findByDoctorantCin(cin);
    }
    @GetMapping("/email/{email}")
    public List<These> findByDoctorantUserEmail(@PathVariable String email) {
        return theseService.findByDoctorantUserEmail(email);
    }
    
}
