package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Articles;
import fr.formation.inti.entities.Commande;

public interface CommandeDao extends JpaRepository<Commande, Integer>{

}
