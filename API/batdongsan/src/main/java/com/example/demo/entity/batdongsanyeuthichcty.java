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
@Table(name = "batdongsanyeuthichcty")
public class batdongsanyeuthichcty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_yeuthichcty")
	Long idYeuthichcty;

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
	@JoinColumn(name = "id_spcty")
	private Sanpham_cty sanphamcty;

	public Sanpham_cty getSanphamcty() {
		return sanphamcty;
	}

	public void setSanphamcty(Sanpham_cty sanphamcty) {
		this.sanphamcty = sanphamcty;
	}

	public Long getIdYeuthichcty() {
		return idYeuthichcty;
	}

	public void setIdYeuthichcty(Long idYeuthichcty) {
		this.idYeuthichcty = idYeuthichcty;
	}
	
}
