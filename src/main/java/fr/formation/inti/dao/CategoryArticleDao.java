package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.CategoryArticle;

public interface CategoryArticleDao extends JpaRepository<CategoryArticle, Integer>{

}
