package fr.formation.inti.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "commande_article", catalog = "pizza_db")
public class CommandeArticle implements Serializable {

	private Integer idCommandeArticle;
	private Article article;
	private Commande commande;
	private Integer articleQuantity;

	public CommandeArticle() {
	}

	public CommandeArticle(Article article, Commande commande, Integer articleQuantity) {
		this.article = article;
		this.commande = commande;
		this.articleQuantity = articleQuantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_COMMANDE_ARTICLE", unique = true, nullable = false)
	public Integer getIdCommandeArticle() {
		return this.idCommandeArticle;
	}

	public void setIdCommandeArticle(Integer idCommandeArticle) {
		this.idCommandeArticle = idCommandeArticle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ARTICLE", nullable = false)
	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COMMANDE", nullable = false)
	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Column(name = "ARTICLE_QUANTITY")
	public Integer getArticleQuantity() {
		return this.articleQuantity;
	}

	public void setArticleQuantity(Integer articleQuantity) {
		this.articleQuantity = articleQuantity;
	}

}
