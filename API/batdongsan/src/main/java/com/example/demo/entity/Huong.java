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
@Table(name = "huong")
public class Huong {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_huong")
	Long idHuong;

	@NotNull
	@Column(name = "ten_huong")
	String nameHuong;

	public Long getIdHuong() {
		return idHuong;
	}

	public void setIdHuong(Long idHuong) {
		this.idHuong = idHuong;
	}

	public String getNameHuong() {
		return nameHuong;
	}

	public void setNameHuong(String nameHuong) {
		this.nameHuong = nameHuong;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "huong")
	private Collection<Sanpham_cty> sanphamctys;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "huong")
	private Collection<Sanpham_nguoidung> sanphamnguoidung;
	
}
