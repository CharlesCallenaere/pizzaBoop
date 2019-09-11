package fr.formation.inti.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "article", catalog = "pizza_db")
public class Article implements Serializable {

	private Integer idArticle;
	private String nom;
	private BigDecimal prix;
	private String category;
	private Set<CommandeArticle> commandeArticles = new HashSet<>(0);

	public Article() {
	}

	public Article(String nom, BigDecimal prix, String category, Set<CommandeArticle> commandeArticles) {
		this.nom = nom;
		this.prix = prix;
		this.category = category;
		this.commandeArticles = commandeArticles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_ARTICLE", unique = true, nullable = false)
	public Integer getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	@Column(name = "NOM", length = 30)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRIX", precision = 5)
	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	@Column(name = "CATEGORY", length = 20)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
	public Set<CommandeArticle> getCommandeArticles() {
		return this.commandeArticles;
	}

	public void setCommandeArticles(Set<CommandeArticle> commandeArticles) {
		this.commandeArticles = commandeArticles;
	}

}
