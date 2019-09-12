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
	private ArticleDao dao;

	public void setArticleDao(ArticleDao dao) {
		this.dao = dao;
	}

	public List<Article> findAll() {
		return dao.findAll();
	}

	public Article save(Article article) {
		return dao.save(article);
	}

	public Article findById(Integer id) {
		return dao.findById(id).get();
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}