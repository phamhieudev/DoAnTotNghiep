package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "quantambdscty")
public class Quantamsanphamcty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_quantam")
	Long idQuantam;

	@NotNull
	@Column(name = "email")
	String mail;
	
	@NotNull
	@Column(name = "sdt")
	Integer phone;
	
	@NotNull
	@Column(name = "tennguoidung")
	String tenNguoidung;

	public Long getIdQuantam() {
		return idQuantam;
	}

	public void setIdQuantam(Long idQuantam) {
		this.idQuantam = idQuantam;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getTenNguoidung() {
		return tenNguoidung;
	}

	public void setTenNguoidung(String tenNguoidung) {
		this.tenNguoidung = tenNguoidung;
	}

	@ManyToOne
	@JoinColumn(name = "idspcty")
	private Sanpham_cty sanphamcty;

	public Sanpham_cty getSanphamcty() {
		return sanphamcty;
	}

	public void setSanphamcty(Sanpham_cty sanphamcty) {
		this.sanphamcty = sanphamcty;
	}
	
	
	
	

}
