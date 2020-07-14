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
@Table(name = "hinhanhchitietspnd")
public class Hinhanhchitietspnd {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idhinh")
	Long idHinh;

	@NotNull
	@Column(name = "url")
	String urlhinh;
	
	
	
	public Long getIdHinh() {
		return idHinh;
	}



	public void setIdHinh(Long idHinh) {
		this.idHinh = idHinh;
	}



	public String getUrlhinh() {
		return urlhinh;
	}



	public void setUrlhinh(String urlhinh) {
		this.urlhinh = urlhinh;
	}




	
	@ManyToOne
	@JoinColumn(name = "idspnd")
	private Sanpham_nguoidung sanphamnguoidung;



	public Sanpham_nguoidung getSanphamnguoidung() {
		return sanphamnguoidung;
	}



	public void setSanpham_nguoidung(Sanpham_nguoidung sanphamnguoidung) {
		this.sanphamnguoidung = sanphamnguoidung;
	}
	
	



	
	
}
