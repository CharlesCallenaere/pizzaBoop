package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}

