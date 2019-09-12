package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Article;
import fr.formation.inti.service.ArticleService;



@Controller
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@GetMapping("/list")
	public String listArticle(Model model) {
		model.addAttribute("article", articleService.findAll());

		return "list-article";
	}

//	@GetMapping("/addarticle")
//	public String addArticle(Model model) {
//		Article article = new Article();
//		model.addAttribute(article);
//		return "show-article-form";
//	}
//
//	@PostMapping("/processform")
//	public String processForm(Model model, @ModelAttribute("article") Article article) {
//
//		// adding logic here
//		articleService.save(article);
//
//		// display
//		model.addAttribute("article", articleService.findAll());
//
//		return "list-article";
//	}
//
//	@GetMapping("/update")
//	public String updateArticle(Model model, @RequestParam("idArticle") Integer id) {
//
//		model.addAttribute("article", articleService.findById(id));
//
//		return "show-article-form";
//
//	}
//
//	@GetMapping("/delete")
//	public String deleteArticle(Model model, @RequestParam("idLivraison") Integer id) {
//
//		// adding logic here
//		articleService.deleteById(id);
//
//		// display
//		model.addAttribute("article", articleService.findAll());
//
//		return "list-article";
//
//	}

}