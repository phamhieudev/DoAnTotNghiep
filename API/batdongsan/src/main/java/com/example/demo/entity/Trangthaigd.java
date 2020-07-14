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
@Table(name = "trangthaigiaodichbds")
public class Trangthaigd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtrangthaigd")
	Long idTrangthaigd;

	@NotNull
	@Column(name = "tentrangthaigd")
	String tenTrangthaigd;


	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaisanpham")
//	private Collection<Sanpham_cty> sanphamctys;
	
	public Long getIdTrangthaigd() {
		return idTrangthaigd;
	}



	public void setIdTrangthaigd(Long idTrangthaigd) {
		this.idTrangthaigd = idTrangthaigd;
	}



	public String getTenTrangthaigd() {
		return tenTrangthaigd;
	}



	public void setTenTrangthaigd(String tenTrangthaigd) {
		this.tenTrangthaigd = tenTrangthaigd;
	}



	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trangthaigd")
	private Collection<Sanpham_nguoidung> sanphamnguoidungs;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trangthaigd")
	private Collection<Sanpham_cty> sanphamctys;
	
}
