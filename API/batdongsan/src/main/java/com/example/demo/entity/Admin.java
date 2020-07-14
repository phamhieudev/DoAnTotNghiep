package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	Long idAdmin;

	@NotNull
	@Column(name = "admin_name")
	String nameAdmin;
	
	@NotNull
	@Column(name = "admin_mail")
	String mailAdmin;
	
	@NotNull
	@Column(name = "admin_dienthoai")
	String dienthoaiAdmin;
	
	@NotNull
	@Column(name = "matkhau")
	String matkhauAdmin;

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNameAdmin() {
		return nameAdmin;
	}

	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}

	public String getMailAdmin() {
		return mailAdmin;
	}

	public void setMailAdmin(String mailAdmin) {
		this.mailAdmin = mailAdmin;
	}

	public String getDienthoaiAdmin() {
		return dienthoaiAdmin;
	}

	public void setDienthoaiAdmin(String dienthoaiAdmin) {
		this.dienthoaiAdmin = dienthoaiAdmin;
	}

	public String getMatkhauAdmin() {
		return matkhauAdmin;
	}

	public void setMatkhauAdmin(String matkhauAdmin) {
		this.matkhauAdmin = matkhauAdmin;
	}
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Phanquyenadmin phanquyenadmin;

	public Phanquyenadmin getPhanquyenadmin() {
		return phanquyenadmin;
	}

	public void setPhanquyenadmin(Phanquyenadmin phanquyenadmin) {
		this.phanquyenadmin = phanquyenadmin;
	}
	
	
	
}
