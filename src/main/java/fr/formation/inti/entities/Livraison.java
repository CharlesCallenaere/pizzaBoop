package fr.formation.inti.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "livraison", catalog = "pizza_db")
public class Livraison implements Serializable {

	private Integer idLivraison;
	private Commande commande;
	private Users users;
	private Date heureDepart;
	private Date heureClient;
	private Date heureRetour;
	private Boolean validation;

	public Livraison() {
	}

	public Livraison(Commande commande, Users users, Date heureDepart, Date heureClient, Date heureRetour, Boolean validation) {
		this.commande = commande;
		this.users = users;
		this.heureDepart = heureDepart;
		this.heureClient = heureClient;
		this.heureRetour = heureRetour;
		this.validation = validation;
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
	@JoinColumn(name = "ID_USER")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
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

	@Column(name = "VALIDATION")
	public Boolean getValidation() {
		return this.validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

}
