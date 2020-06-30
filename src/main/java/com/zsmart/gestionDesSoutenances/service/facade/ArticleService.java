/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import java.util.List;

import com.zsmart.gestionDesSoutenances.bean.Article;

/**
 *
 * @author HP
 */
public interface ArticleService {

    List<Article> findAll();

    List<Article> findByIndexationLibelle(String libelle);

    int deleteByReference(String reference);

    int save(Article article);

}
