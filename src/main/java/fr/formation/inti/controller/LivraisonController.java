package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Livraison;
import fr.formation.inti.service.LivraisonService;



@Controller
@RequestMapping("/livraison")
public class LivraisonController {

	@Autowired
	private LivraisonService livraisonService;

	@GetMapping("/list")
	public String listLivraison(Model themodel) {
		themodel.addAttribute("livraison", livraisonService.findAll());

		return "list-livraison";
	}

	@GetMapping("/addlivraison")
	public String addLivraison(Model themodel) {
		Livraison livraison = new Livraison();
		themodel.addAttribute(livraison);
		return "show-livraison-form";
	}

	@PostMapping("/processform")
	public String processForm(Model themodel, @ModelAttribute("livraison") Livraison livraison) {

		// adding logic here
		livraisonService.add(livraison);

		// display
		themodel.addAttribute("livraison", livraisonService.findAll());

		return "list-livraison";
	}

	@GetMapping("/update")
	public String updateLivraison(Model themodel, @RequestParam("idLivraison") Integer theId) {

		themodel.addAttribute("livraison", livraisonService.findById(theId));

		return "show-livraison-form";

	}

	@GetMapping("/delete")
	public String deleteLivraison(Model themodel, @RequestParam("idLivraison") Integer theId) {

		// adding logic here
		livraisonService.delete(theId);

		// display
		themodel.addAttribute("livraison", livraisonService.findAll());

		return "list-livraison";

	}

}