package fr.formation.inti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.CustommerDao;
import fr.formation.inti.entities.Custommer;


@Service
public class CustommerService {

    @Autowired
    private CustommerDao custommerDao;
    
    
    
    
    public void setCustommerDao(CustommerDao custommerDao) {
		this.custommerDao = custommerDao;
	}


    public List<Custommer> getCustommer() {
        
                // do some business processing here ...
            //now call DAO layer
        return custommerDao.findAll();

  }
    
    
    public Custommer addCustommer(Custommer custommer) {
        
         // do some business processing  here ...
            //now call DAO layer
        return custommerDao.save(custommer);
        
    }
    
    public Custommer getSingleCustommer(Integer theId) {
        
        // do some business processing here ... 
            //now call DAO layer
        return custommerDao.findById(theId).get();
    }
    
    
    @Transactional
    public void deleteCustommer(Integer theId) {
         // do some business processing here ...
         //now call DAO layer
    	custommerDao.deleteById(theId);
    }
}