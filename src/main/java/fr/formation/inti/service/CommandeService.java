package fr.formation.inti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.CommandeDao;
import fr.formation.inti.entities.Commande;

@Service
public class CommandeService {

	@Autowired
	private CommandeDao dao;

	public void setArticleDao(CommandeDao dao) {
		this.dao = dao;
	}

	public List<Commande> findAll() {
		return dao.findAll();
	}

	public Commande save(Commande commande) {
		return dao.save(commande);
	}

	public Commande findById(Integer id) {
		return dao.findById(id).get();
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}