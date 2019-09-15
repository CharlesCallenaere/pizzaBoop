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
@Table(name = "role_users", catalog = "pizza_db")
public class RoleUsers implements Serializable {

	private Integer idRoleUser;
	private String nom;
	private Set<Customer> customers = new HashSet<>(0);
	private Set<Users> userses = new HashSet<>(0);

	public RoleUsers() {
	}

	public RoleUsers(String nom, Set<Customer> customers, Set<Users> userses) {
		this.nom = nom;
		this.customers = customers;
		this.userses = userses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_ROLE_USER", unique = true, nullable = false)
	public Integer getIdRoleUser() {
		return this.idRoleUser;
	}

	public void setIdRoleUser(Integer idRoleUser) {
		this.idRoleUser = idRoleUser;
	}

	@Column(name = "NOM", nullable = false, length = 45)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roleUsers")
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roleUsers")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
