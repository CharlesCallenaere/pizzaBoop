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
    private CommandeDao commandeDao;
    
    
    
    
    public void setCommandeDao(CommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}


    public List<Commande> getCommande() {
        
                // do some business processing here ...
            //now call DAO layer
        return commandeDao.findAll();

  }
    
    
    public Commande addCommande(Commande commande) {
        
         // do some business processing  here ...
            //now call DAO layer
        return commandeDao.save(commande);
        
    }
    
    public Commande getSingleCommandes(Integer theId) {
        
        // do some business processing here ... 
            //now call DAO layer
        return commandeDao.findById(theId).get();
    }
    
    
    @Transactional
    public void deleteCommande(Integer theId) {
         // do some business processing here ...
         //now call DAO layer
    	commandeDao.deleteById(theId);
    }
}