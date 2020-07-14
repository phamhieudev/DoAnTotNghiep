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
@Table(name = "loaisanpham")
public class Loaisanpham {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idloai_sanpham")
	Long idLoaisp;

	@NotNull
	@Column(name = "tenloai_sanpham")
	String tenLoaisp;

	public Long getIdLoaisp() {
		return idLoaisp;
	}

	public void setIdLoaisp(Long idLoaisp) {
		this.idLoaisp = idLoaisp;
	}

	public String getTenLoaisp() {
		return tenLoaisp;
	}

	public void setTenLoaisp(String tenLoaisp) {
		this.tenLoaisp = tenLoaisp;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaisanpham")
	private Collection<Sanpham_cty> sanphamctys;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaisanpham")
	private Collection<Sanpham_nguoidung> sanphamnguoidungs;
	
	
}
