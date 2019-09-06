package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Articles;

public interface ArticlesDao extends JpaRepository<Articles, Integer>{

}
