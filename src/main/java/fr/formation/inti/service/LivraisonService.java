package fr.formation.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.LivraisonDao;
import fr.formation.inti.entities.Livraison;



@Service
public class LivraisonService {

    @Autowired
    private LivraisonDao livraisondao;
    
    public List<Livraison> findAll() {
        
                // do some business processing here ...
            //now call DAO layer
        return livraisondao.findAll();

  }
    
    
    public Livraison add(Livraison livraison) {
        
         // do some business processing  here ...
            //now call DAO layer
        return livraisondao.save(livraison);
        
    }
    
    public Livraison findById(Integer theId) {
        
        // do some business processing here ... 
            //now call DAO layer
        return livraisondao.findById(theId).get();
    }
    
    
    public void delete(Integer theId) {
         // do some business processing here ...
         //now call DAO layer
    	livraisondao.deleteById(theId);
    }
}