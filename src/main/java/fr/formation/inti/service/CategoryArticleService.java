package fr.formation.inti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.CategoryArticleDao;
import fr.formation.inti.entities.Article;
import fr.formation.inti.entities.CategoryArticle;

@Service
public class CategoryArticleService {

	@Autowired
	private CategoryArticleDao dao;

	public void setArticleDao(CategoryArticleDao dao) {
		this.dao = dao;
	}

	public List<CategoryArticle> findAll() {
		return dao.findAll();
	}

	public CategoryArticle save(CategoryArticle catArticle) {
		return dao.save(catArticle);
	}

	public CategoryArticle findById(Integer id) {
		return dao.findById(id).get();
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}