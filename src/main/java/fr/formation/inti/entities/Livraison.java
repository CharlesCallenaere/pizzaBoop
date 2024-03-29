package fr.formation.inti.entities;
// Generated 5 sept. 2019 14:31:58 by Hibernate Tools 5.0.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Livraison generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "livraison", catalog = "pizza_db")
public class Livraison implements java.io.Serializable {

	private Integer idLivraison;
	private Commande commande;
	private Livreur livreur;
	private Date heureDepart;
	private Date heureClient;
	private Date heureRetour;

	public Livraison() {
	}

	public Livraison(Commande commande, Livreur livreur, Date heureDepart, Date heureClient, Date heureRetour) {
		this.commande = commande;
		this.livreur = livreur;
		this.heureDepart = heureDepart;
		this.heureClient = heureClient;
		this.heureRetour = heureRetour;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_LIVRAISON", unique = true, nullable = false)
	public Integer getIdLivraison() {
		return this.idLivraison;
	}

	public void setIdLivraison(Integer idLivraison) {
		this.idLivraison = idLivraison;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COMMANDE")
	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LIVREUR")
	public Livreur getLivreur() {
		return this.livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HEURE_DEPART", length = 8)
	public Date getHeureDepart() {
		return this.heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HEURE_CLIENT", length = 8)
	public Date getHeureClient() {
		return this.heureClient;
	}

	public void setHeureClient(Date heureClient) {
		this.heureClient = heureClient;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HEURE_RETOUR", length = 8)
	public Date getHeureRetour() {
		return this.heureRetour;
	}

	public void setHeureRetour(Date heureRetour) {
		this.heureRetour = heureRetour;
	}

}
