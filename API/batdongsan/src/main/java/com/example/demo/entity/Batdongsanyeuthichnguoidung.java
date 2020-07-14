package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "batdongsanyeuthichnguoidung")
public class Batdongsanyeuthichnguoidung {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_yeuthichnguoidung")
	Long idYeuthichnguoidung;

	@ManyToOne
	@JoinColumn(name = "id_nguoidung")
	private Nguoidung nguoidung;
	
	public Nguoidung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(Nguoidung nguoidung) {
		this.nguoidung = nguoidung;
	}

	@ManyToOne
	@JoinColumn(name = "id_sanphamnguoidung")
	private Sanpham_nguoidung sanphamnguoidung;

	public Sanpham_nguoidung getSanphamnguoidung() {
		return sanphamnguoidung;
	}

	public void setSanphamnguoidung(Sanpham_nguoidung sanphamnguoidung) {
		this.sanphamnguoidung = sanphamnguoidung;
	}
	
	public Long getIdYeuthichnguoidung() {
		return idYeuthichnguoidung;
	}

	public void setIdYeuthichnguoidung(Long idYeuthichnguoidung) {
		this.idYeuthichnguoidung = idYeuthichnguoidung;
	}
	
}
