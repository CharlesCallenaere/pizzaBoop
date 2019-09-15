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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "users", catalog = "pizza_db")
public class Users implements Serializable {

	private Integer idUser;
	private String nom;
	private String mdp;
	private RoleUsers roleUsers;
	private Set<Livraison> livraisons = new HashSet<>(0);

	public Users() {
	}

	public Users(RoleUsers roleUsers, String nom, String mdp, Set<Livraison> livraisons) {
		this.roleUsers = roleUsers;
		this.nom = nom;
		this.mdp = mdp;
		this.livraisons = livraisons;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_USER", unique = true, nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ROLE_USER", nullable = false)
	public RoleUsers getRoleUsers() {
		return this.roleUsers;
	}

	public void setRoleUsers(RoleUsers roleUsers) {
		this.roleUsers = roleUsers;
	}

	@Column(name = "NOM", length = 30)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "MDP", length = 15)
	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Livraison> getLivraisons() {
		return this.livraisons;
	}

	public void setLivraisons(Set<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

}
