package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "phanquyenadmin")
public class Phanquyenadmin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	Long idRoleadmin;

	@NotNull
	@Column(name = "name_role")
	String nameRole;

	public Long getIdRoleadmin() {
		return idRoleadmin;
	}

	public void setIdRoleadmin(Long idRoleadmin) {
		this.idRoleadmin = idRoleadmin;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phanquyenadmin")
	private Collection<Phanquyenadmin> phanquyenadmin;
	
}
