package fr.formation.inti.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "category_article", catalog = "pizza_db")
public class CategoryArticle implements Serializable {

	private Integer idcategory;
	private String nom;
	private Set<Article> articles = new HashSet<>(0);

	public CategoryArticle() {
	}

	public CategoryArticle(String nom, Set<Article> articles) {
		this.nom = nom;
		this.articles = articles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "IDCATEGORY", unique = true, nullable = false)
	public Integer getIdcategory() {
		return this.idcategory;
	}

	public void setIdcategory(Integer idcategory) {
		this.idcategory = idcategory;
	}

	@Column(name = "NOM", nullable = false, length = 45)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryArticle")
	public Set<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

}
