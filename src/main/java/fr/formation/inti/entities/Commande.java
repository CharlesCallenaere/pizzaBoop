package fr.formation.inti.entities;
// Generated 5 sept. 2019 14:31:58 by Hibernate Tools 5.0.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Commande generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "commande", catalog = "pizza_db")
public class Commande implements java.io.Serializable {

	private Integer idCommande;
	private Custommer custommer;
	private Date dateCmd;
	private Date heure;
	private String articles;
	private Set<Livraison> livraisons = new HashSet<Livraison>(0);
	private Set<CommandeArticle> commandeArticles = new HashSet<CommandeArticle>(0);

	public Commande() {
	}

	public Commande(Custommer custommer, Date dateCmd, Date heure, String articles, Set<Livraison> livraisons,
			Set<CommandeArticle> commandeArticles) {
		this.custommer = custommer;
		this.dateCmd = dateCmd;
		this.heure = heure;
		this.articles = articles;
		this.livraisons = livraisons;
		this.commandeArticles = commandeArticles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_COMMANDE", unique = true, nullable = false)
	public Integer getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENT")
	public Custommer getCustommer() {
		return this.custommer;
	}

	public void setCustommer(Custommer custommer) {
		this.custommer = custommer;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CMD", length = 10)
	public Date getDateCmd() {
		return this.dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HEURE", length = 8)
	public Date getHeure() {
		return this.heure;
	}

	public void setHeure(Date heure) {
		this.heure = heure;
	}

	@Column(name = "ARTICLES", length = 50)
	public String getArticles() {
		return this.articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commande")
	public Set<Livraison> getLivraisons() {
		return this.livraisons;
	}

	public void setLivraisons(Set<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commande")
	public Set<CommandeArticle> getCommandeArticles() {
		return this.commandeArticles;
	}

	public void setCommandeArticles(Set<CommandeArticle> commandeArticles) {
		this.commandeArticles = commandeArticles;
	}
}
