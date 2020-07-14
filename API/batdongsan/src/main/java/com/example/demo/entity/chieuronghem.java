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
@Table(name = "chieuronghem")
public class chieuronghem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hem")
	Long idhem;

	@NotNull
	@Column(name = "tenloai_hem")
	String tenHem;

	public Long getIdhem() {
		return idhem;
	}

	public void setIdhem(Long idhem) {
		this.idhem = idhem;
	}

	public String getTenHem() {
		return tenHem;
	}

	public void setTenHem(String tenHem) {
		this.tenHem = tenHem;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chieuronghem")
	private Collection<Sanpham_cty> sanphamctys;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chieuronghem")
	private Collection<Sanpham_nguoidung> sanphamnguoidungs;
	
}
