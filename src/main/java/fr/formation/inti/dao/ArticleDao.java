package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Article;

public interface ArticleDao extends JpaRepository<Article, Integer>{

}
