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
@Table(name = "Donvigia")
public class Donvigia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_donvigia")
	Long idDonvigia;

	@NotNull
	@Column(name = "ten_donvigia")
	String tenDonvigia;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "donvigia")
	private Collection<Sanpham_cty> sanphamctys;

	public Long getIdDonvigia() {
		return idDonvigia;
	}

	public void setIdDonvigia(Long idDonvigia) {
		this.idDonvigia = idDonvigia;
	}

	public String getTenDonvigia() {
		return tenDonvigia;
	}

	public void setTenDonvigia(String tenDonvigia) {
		this.tenDonvigia = tenDonvigia;
	}


	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "donvigia")
	private Collection<Sanpham_nguoidung> sanphamnguoidungs;
	
}
