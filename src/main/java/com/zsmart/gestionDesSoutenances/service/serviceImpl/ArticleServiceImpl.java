/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsmart.gestionDesSoutenances.bean.Article;
import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.Indexation;
import com.zsmart.gestionDesSoutenances.dao.ArticleDao;
import com.zsmart.gestionDesSoutenances.service.facade.ArticleService;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import com.zsmart.gestionDesSoutenances.service.facade.IndexationService;
import com.zsmart.gestionDesSoutenances.service.facade.SaveFileService;

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
	SaveFileService saveFileService;

	@Override
	public List<Article> findAll() {
            
		return articleDao.findAll();
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
            Indexation indexation = indexationService.findByReference(article.getIndexation().getReference());
            Doctorant doctorant = doctorantService.findByUserEmail(article.getDoctorant().getUser().getEmail());
            
		Date date = new Date();
		article.setDatePublicationArticle(date);
		article.setIndexation(indexation);
                article.setDoctorant(doctorant);
		String ref = "article_" + date.getTime();
		article.setReference(ref);
		articleDao.save(article);
		return 1;

	}

}
