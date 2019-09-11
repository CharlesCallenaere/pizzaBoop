package fr.formation.inti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.ArticleDao;
import fr.formation.inti.entities.Article;


@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;
    
    
    
    
    public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}


    public List<Article> findAll() {
        
                // do some business processing here ...
            //now call DAO layer
        return articleDao.findAll();

  }
    
    
    public Article add(Article article) {
        
         // do some business processing  here ...
            //now call DAO layer
        return articleDao.save(article);
        
    }
    
    public Article getById(Integer theId) {
        
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