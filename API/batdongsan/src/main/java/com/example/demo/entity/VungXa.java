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
@Table(name = "vungtdm")
public class VungXa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vungxa")
	Long idVungxa;

	@NotNull
	@Column(name = "tenphuong")
	String tenVungxa;
	
//	@NotNull
//	@Column(name = "geom")
//	String dulieugisVungxa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vungxa")
	private Collection<Sanpham_cty> sanphamctys;

	public Long getIdVungxa() {
		return idVungxa;
	}

	public void setIdVungxa(Long idVungxa) {
		this.idVungxa = idVungxa;
	}

	public String getTenVungxa() {
		return tenVungxa;
	}

	public void setTenVungxa(String tenVungxa) {
		this.tenVungxa = tenVungxa;
	}

//	public String getDulieugisVungxa() {
//		return dulieugisVungxa;
//	}
//
//	public void setDulieugisVungxa(String dulieugisVungxa) {
//		this.dulieugisVungxa = dulieugisVungxa;
//	}
	

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vungxa")
	private Collection<Sanpham_nguoidung> sanphamnguoidung;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vungxa")
	private Collection<Duong> duong;

}
