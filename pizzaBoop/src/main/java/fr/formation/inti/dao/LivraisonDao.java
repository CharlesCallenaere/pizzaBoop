package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Livraison;

public interface LivraisonDao extends JpaRepository<Livraison, Integer> {

}
