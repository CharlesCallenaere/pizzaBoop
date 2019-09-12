package fr.formation.inti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.LivraisonDao;
import fr.formation.inti.entities.Livraison;

@Service
public class LivraisonService {

	@Autowired
	private LivraisonDao dao;

	public void setArticleDao(LivraisonDao dao) {
		this.dao = dao;
	}

	public List<Livraison> findAll() {
		return dao.findAll();
	}

	public Livraison save(Livraison livraison) {
		return dao.save(livraison);
	}

	public Livraison findById(Integer id) {
		return dao.findById(id).get();
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}