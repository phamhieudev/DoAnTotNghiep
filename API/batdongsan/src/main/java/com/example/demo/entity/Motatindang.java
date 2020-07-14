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
@Table(name = "motatindang")
public class Motatindang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mota")
	Long idMota;

	@NotNull
	@Column(name = "noidung")
	String noidung;

	
	
public Long getIdMota() {
		return idMota;
	}



	public void setIdMota(Long idMota) {
		this.idMota = idMota;
	}



	public String getNoidung() {
		return noidung;
	}



	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}



	//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hinhanh")
//	private Collection<Sanpham_cty> sanphamctys;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Motatindang")
	private Collection<Sanpham_nguoidung> sanphamnguoidungs;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Motatindang")
	private Collection<Sanpham_cty> sanphamctys;

}
