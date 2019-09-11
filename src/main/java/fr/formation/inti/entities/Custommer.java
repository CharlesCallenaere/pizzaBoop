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
@Table(name = "custommer", catalog = "pizza_db")
public class Custommer implements Serializable {

	private Integer idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String numTel;
	private Set<Commande> commandes = new HashSet<>(0);

	public Custommer() {
	}

	public Custommer(String nom, String prenom, String adresse, String numTel, Set<Commande> commandes) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numTel = numTel;
		this.commandes = commandes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_CLIENT", unique = true, nullable = false)
	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	@Column(name = "NOM", length = 30)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRENOM", length = 30)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "ADRESSE", length = 100)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "NUM_TEL", length = 15)
	public String getNumTel() {
		return this.numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "custommer")
	public Set<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

}
