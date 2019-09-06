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
    
    public List<Livraison> getLivraison() {
        
                // do some business processing here ...
            //now call DAO layer
        return livraisondao.findAll();

  }
    
    
    public Livraison addLivraison(Livraison livraison) {
        
         // do some business processing  here ...
            //now call DAO layer
        return livraisondao.save(livraison);
        
    }
    
    public Livraison getSingleLivraison(Integer theId) {
        
        // do some business processing here ... 
            //now call DAO layer
        return livraisondao.findById(theId).get();
    }
    
    
    public void deleteLivraison(Integer theId) {
         // do some business processing here ...
         //now call DAO layer
    	livraisondao.deleteById(theId);
    }
}