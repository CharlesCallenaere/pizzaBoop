package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.inti.service.CustommerService;

@Controller
public class HelloController {
	@Autowired
	private CustommerService custommerService;

	/**
	 * @GetMapping to get rid of the @RequestMapping(path={"/"}, method=RequestMethod.GET) annotation which is noncompliant
	 * but still the same
	 * @param model
	 * @return
	 */
//	@GetMapping(path={"/"})
//	public String viewForm(Model model) {
//		return "accueil";
//		
//	}
	@GetMapping(path={"/"})
	public String viewForm(Model model) {
		model.addAttribute("custommer", custommerService.getCustommer());
		
		return "livraison2";
		
	}
	
	@GetMapping(path={"/commande"})
	public String viewCommande(Model model) {
		return "commande";
		
	}
	
	
}
