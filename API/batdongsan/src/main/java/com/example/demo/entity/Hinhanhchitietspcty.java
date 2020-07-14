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
@Table(name = "hinhanhchitietspcty")
public class Hinhanhchitietspcty {
	

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
	@JoinColumn(name = "idspcty")
	private Sanpham_cty sanphamcty;



	public Sanpham_cty getSanphamcty() {
		return sanphamcty;
	}



	public void setSanphamcty(Sanpham_cty sanphamcty) {
		this.sanphamcty = sanphamcty;
	}
	
	




	
}
