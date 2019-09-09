package fr.formation.inti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.ArticlesDao;
import fr.formation.inti.entities.Articles;


@Service
public class ArticleService {

    @Autowired
    private ArticlesDao articleDao;
    
    
    
    
    public void setArticleDao(ArticlesDao articleDao) {
		this.articleDao = articleDao;
	}


    public List<Articles> findAll() {
        
                // do some business processing here ...
            //now call DAO layer
        return articleDao.findAll();

  }
    
    
    public Articles add(Articles article) {
        
         // do some business processing  here ...
            //now call DAO layer
        return articleDao.save(article);
        
    }
    
    public Articles getById(Integer theId) {
        
        // do some business processing here ... 
            //now call DAO layer
        return articleDao.findById(theId).get();
    }
    
    
    @Transactional
    public void delete(Integer theId) {
         // do some business processing here ...
         //now call DAO layer
    	articleDao.deleteById(theId);
    }
}