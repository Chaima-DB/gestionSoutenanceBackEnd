/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import com.zsmart.gestionDesSoutenances.bean.Article;
import com.zsmart.gestionDesSoutenances.dao.ArticleDao;
import com.zsmart.gestionDesSoutenances.service.facade.ArticleService;
import java.io.File;
import java.io.IOException;
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
    public void uploadFile(MultipartFile file) {

        try {
            Article article = new Article();
            article.setPdf(file.getBytes());
            articleDao.save(article);
        } catch (IOException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Article storeFile(MultipartFile file) {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Article dbFile = new Article(fileName, file.getBytes());
            return articleDao.save(dbFile);
        } catch (IOException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//
//        public Article getFile(String reference) {
//            return articleDao.findById(articleId)
//                    .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
//        }
    @Override
    public Article getFile(String reference) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Article> findByIndexationLibelle(String libelle) {
        return articleDao.findByIndexationLibelle(libelle);
    }

}
