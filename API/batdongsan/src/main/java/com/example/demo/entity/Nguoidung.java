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
@Table(name = "nguoidung")
public class Nguoidung {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nguoidung")
	Long idNguoidung;

	
	
	@NotNull
	@Column(name = "matkhau_nguoidung")
	String password;

	@NotNull
	@Column(name = "email_nguoidung")
	String mail;
	
	@NotNull
	@Column(name = "dienthoai_nguoidung")
	Integer phone;
	
	@NotNull
	@Column(name = "ten_nguoidung")
	String tenNguoidung;

	
	
	public Long getIdNguoidung() {
		return idNguoidung;
	}



	public void setIdNguoidung(Long idNguoidung) {
		this.idNguoidung = idNguoidung;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
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



	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nguoidung")
	private Collection<Sanpham_nguoidung> sanphamnguoidungs;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nguoidung")
	private Collection<batdongsanyeuthichcty> batdongsanyeuthichs;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nguoidung")
	private Collection<Batdongsanyeuthichnguoidung> batdongsanyeuthichnds;
}
