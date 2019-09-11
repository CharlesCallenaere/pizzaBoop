package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.inti.service.ArticleService;
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
	@Autowired
	private ArticleService service;
	
	@GetMapping(path={"/"})
	public String view(Model model) {
		return "accueil";
	}
	
	@GetMapping(path = {"/livraison"})
	public String viewForm(Model model) {
		model.addAttribute("custommer", custommerService.getCustommer());
		
		return "livraison2";
		
	}
	@GetMapping(path={"/test"})
	public String viewTest(Model model) {
		model.addAttribute("articles",service.findAll());
		return "test";
	}
	
	@GetMapping(path={"/login"})
	public String viewLogin(Model model) {
		return "login";
	}
	@GetMapping(path={"/signUp"})
	public String viewSignUp(Model model) {
		return "signUp";
	}
	
	
}
