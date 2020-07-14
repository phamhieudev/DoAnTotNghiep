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
@Table(name = "phaply")
public class Phaply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_phaply")
	Long idphaply;

	@NotNull
	@Column(name = "ten_phaply")
	String tenphaply;

	public Long getIdphaply() {
		return idphaply;
	}

	public void setIdphaply(Long idphaply) {
		this.idphaply = idphaply;
	}

	public String getTenphaply() {
		return tenphaply;
	}

	public void setTenphaply(String tenphaply) {
		this.tenphaply = tenphaply;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phaply")
	private Collection<Sanpham_cty> sanphamctys;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phaply")
	private Collection<Sanpham_nguoidung> sanphamnguoidungs;
	

}
