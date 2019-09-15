package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloController {

	/**
	 * @GetMapping to get rid of the @RequestMapping(path={"/"}, method=RequestMethod.GET) annotation which is noncompliant
	 * but still the same
	 * @param model
	 * @return
	 */
	
	@GetMapping(path={"/"})
	public String view(Model model) {
		return "accueil";
	}

	@GetMapping(path={"/login"})
	public String viewLogin(Model model) {
		return "auth/login";
	}
	@GetMapping(path={"/signUp"})
	public String viewSignUp(Model model) {
		return "auth/signUp";
	}
	
	
}
