/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.dao;


import com.zsmart.gestionDesSoutenances.bean.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Long>{
    List<Article> findByDoctorantCne(String cne);
    List<Article> findByDoctorantCin(String cin);
    int deleteByReference(String reference);
    List<Article> findByIndexationLibelle(String libelle);
}
