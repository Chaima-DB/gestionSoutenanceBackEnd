/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.Article;
import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.Indexation;
import com.zsmart.gestionDesSoutenances.dao.ArticleDao;
import com.zsmart.gestionDesSoutenances.service.facade.ArticleService;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import com.zsmart.gestionDesSoutenances.service.facade.IndexationService;
import com.zsmart.gestionDesSoutenances.uploads.model.FileInfo;
import com.zsmart.gestionDesSoutenances.uploads.service.FileInfoService;
import com.zsmart.gestionDesSoutenances.uploads.service.FilesStorageService;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Service

public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;
    @Autowired
    IndexationService indexationService;
    @Autowired
    DoctorantService doctorantService;
    @Autowired
    FilesStorageService filesStorageService;

    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    @Override
    public List<Article> findByDoctorantCne(String cne) {
        return articleDao.findByDoctorantCne(cne);
    }

    @Override
    public List<Article> findByDoctorantCin(String cin) {
        return articleDao.findByDoctorantCin(cin);
    }

    @Transactional
    @Override
    public int deleteByReference(String reference) {
        return articleDao.deleteByReference(reference);
    }

    @Override
    public List<Article> findByIndexationLibelle(String libelle) {
        return articleDao.findByIndexationLibelle(libelle);
    }

    @Override
    public int save(Article article) {
        Date  date = new Date();
        article.setDatePublicationArticle(date);
        article.setDoctorant(article.getDoctorant());
        article.setIndexation(article.getIndexation());
        String ref = "art" + date.getTime();
        article.setReference(ref);
        articleDao.save(article);
        return 1;
    }

}
