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
@Table(name = "duong")
public class Duong {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_duong")
	Long idDuong;

	@NotNull
	@Column(name = "tenduong")
	String tenDuong;
	
//	@NotNull
//	@Column(name = "geom")
//	String dulieugisDuong;
	
	@ManyToOne
	@JoinColumn(name = "id_vungxa")
	private VungXa vungxa;
	

	public VungXa getVungxa() {
		return vungxa;
	}

	public void setVungxa(VungXa vungxa) {
		this.vungxa = vungxa;
	}

	public Long getIdDuong() {
		return idDuong;
	}

	public void setIdDuong(Long idDuong) {
		this.idDuong = idDuong;
	}

	public String getTenDuong() {
		return tenDuong;
	}

	public void setTenDuong(String tenDuong) {
		this.tenDuong = tenDuong;
	}

//	public String getDulieugisDuong() {
//		return dulieugisDuong;
//	}
//
//	public void setDulieugisDuong(String dulieugisDuong) {
//		this.dulieugisDuong = dulieugisDuong;
//	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "duong")
	private Collection<Sanpham_cty> sanphamctys;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "duong")
	private Collection<Sanpham_nguoidung> sanphamnguoidung;
}
