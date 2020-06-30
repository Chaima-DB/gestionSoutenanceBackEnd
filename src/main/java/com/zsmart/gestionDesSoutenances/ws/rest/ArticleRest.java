package com.zsmart.gestionDesSoutenances.ws.rest;

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

import com.zsmart.gestionDesSoutenances.bean.Article;
import com.zsmart.gestionDesSoutenances.service.facade.ArticleService;

import io.swagger.annotations.Api;

@Api
@RestController

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("api/v1/gestionDesSoutenances-api/article")
public class ArticleRest {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return articleService.deleteByReference(reference);
    }

    @GetMapping("/indexation/libelle/{libelle}")
    public List<Article> findByIndexationLibelle(@PathVariable String libelle) {
        return articleService.findByIndexationLibelle(libelle);
    }

    @PostMapping("/")
    public int save(@RequestBody Article article) {
        return articleService.save(article);
    }
    
}
