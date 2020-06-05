/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.facade;

import com.zsmart.gestionDesSoutenances.bean.Article;
import java.io.File;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
public interface ArticleService {

    List<Article> findAll();

    List<Article> findByDoctorantCne(String cne);

    List<Article> findByDoctorantCin(String cin);
    List<Article> findByIndexationLibelle(String libelle);

    int deleteByReference(String reference);
    
    void uploadFile(MultipartFile file);
    Article storeFile(MultipartFile file);
    Article getFile(String reference);

}
