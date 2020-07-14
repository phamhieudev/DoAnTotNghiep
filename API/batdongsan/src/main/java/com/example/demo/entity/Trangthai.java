package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trangthai")
public class Trangthai {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trangthai_id")
	Long idTrangthai;

	@NotNull
	@Column(name = "trangthai_name")
	String nameTrangthai;

	public Long getIdTrangthai() {
		return idTrangthai;
	}

	public void setIdTrangthai(Long idTrangthai) {
		this.idTrangthai = idTrangthai;
	}

	public String getNameTrangthai() {
		return nameTrangthai;
	}

	public void setNameTrangthai(String nameTrangthai) {
		this.nameTrangthai = nameTrangthai;
	}
	
	
}
