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
@Table(name = "tintuc")
public class Tintuc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tintuc")
	Long idTintuc;
	

	@NotNull
	@Column(name = "ten_tintuc")
	String tenTintuc;

	@NotNull
	@Column(name = "noidung")
	String noidungTintuc;
	
	@NotNull
	@Column(name = "ngaydang")
	String ngaydangTintuc;
	
	@ManyToOne
	@JoinColumn(name = "idhinh")
	private hinhanhtintuc hinhanhtintuc;
	
	
	
	public hinhanhtintuc getHinhanhtintuc() {
		return hinhanhtintuc;
	}

	public void setHinhanhtintuc(hinhanhtintuc hinhanhtintuc) {
		this.hinhanhtintuc = hinhanhtintuc;
	}

	public Long getIdTintuc() {
		return idTintuc;
	}

	public void setIdTintuc(Long idTintuc) {
		this.idTintuc = idTintuc;
	}

	public String getTenTintuc() {
		return tenTintuc;
	}

	public void setTenTintuc(String tenTintuc) {
		this.tenTintuc = tenTintuc;
	}

	public String getNoidungTintuc() {
		return noidungTintuc;
	}

	public void setNoidungTintuc(String noidungTintuc) {
		this.noidungTintuc = noidungTintuc;
	}

	public String getNgaydangTintuc() {
		return ngaydangTintuc;
	}

	public void setNgaydangTintuc(String ngaydangTintuc) {
		this.ngaydangTintuc = ngaydangTintuc;
	}

	

	
	

}
