package fr.formation.inti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.CustomerDao;
import fr.formation.inti.entities.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;

	public void setArticleDao(CustomerDao dao) {
		this.dao = dao;
	}

	public List<Customer> findAll() {
		return dao.findAll();
	}

	public Customer save(Customer custommer) {
		return dao.save(custommer);
	}

	public Customer findById(Integer id) {
		return dao.findById(id).get();
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}