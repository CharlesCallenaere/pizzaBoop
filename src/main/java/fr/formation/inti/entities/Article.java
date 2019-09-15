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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "article", catalog = "pizza_db")
public class Article implements Serializable {

	private Integer idArticle;
	private String nom;
	private BigDecimal prix;
	private CategoryArticle categoryArticle;
	private Set<CommandeArticle> commandeArticles = new HashSet<>(0);

	public Article() {
	}

	public Article(CategoryArticle categoryArticle, String nom, BigDecimal prix,
			Set<CommandeArticle> commandeArticles) {
		this.categoryArticle = categoryArticle;
		this.nom = nom;
		this.prix = prix;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCATEGORY", nullable = false)
	public CategoryArticle getCategoryArticle() {
		return this.categoryArticle;
	}

	public void setCategoryArticle(CategoryArticle categoryArticle) {
		this.categoryArticle = categoryArticle;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
	public Set<CommandeArticle> getCommandeArticles() {
		return this.commandeArticles;
	}

	public void setCommandeArticles(Set<CommandeArticle> commandeArticles) {
		this.commandeArticles = commandeArticles;
	}

}
