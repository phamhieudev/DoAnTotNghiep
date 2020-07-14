package com.example.demo.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "sanpham_cty")
public class Sanpham_cty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sanpham_id")
	Long idSanphamcty;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sanphamcty")
	private Collection<Hinhanhchitietspcty> hinhanhchitietspctys;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sanphamcty")
	private Collection<Quantamsanphamcty> quantamsanphamctys;
	
	@ManyToOne
	@JoinColumn(name = "idloai_sanpham")
	private Loaisanpham loaisanpham;
	

	public Loaisanpham getLoaisanpham() {
		return loaisanpham;
	}


	public void setLoaisanpham(Loaisanpham loaisanpham) {
		this.loaisanpham = loaisanpham;
	}


	@ManyToOne
	@JoinColumn(name = "id_vungxa")
	private VungXa vungxa;
	

	public VungXa getVungxa() {
		return vungxa;
	}


	public void setVungxa(VungXa vungxa) {
		this.vungxa = vungxa;
	}

	@ManyToOne
	@JoinColumn(name = "id_huong")
	private Huong huong;
	
	public Huong getHuong() {
		return huong;
	}


	public void setHuong(Huong huong) {
		this.huong = huong;
	}

	@ManyToOne
	@JoinColumn(name = "id_donvigia")
	private Donvigia donvigia;
	
	

	public Donvigia getDonvigia() {
		return donvigia;
	}


	public void setDonvigia(Donvigia donvigia) {
		this.donvigia = donvigia;
	}


	@NotNull
	@Column(name = "tensanpham")
	String nameSanpham_cty;
	
	
	
//	@NotNull
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "mm-dd-yyyy")
//	@Column(name = "ngaynhap")
//	Date ngaynhapSanpham_cty;
	@NotNull
	@Column(name = "ngaynhap")
	String ngaynhapSanpham_cty;
	
	@NotNull
	@Column(name = "dientich")
	Float dientichSanpham_cty;
	
	@NotNull
	@Column(name = "gia")
	Float giaSanpham_cty;
	
	@ManyToOne
	@JoinColumn(name = "mota")
	private Motatindang Motatindang;
	

	
	public Motatindang getMotatindang() {
		return Motatindang;
	}


	public void setMotatindang(Motatindang motatindang) {
		Motatindang = motatindang;
	}


	@Column(name = "sotang")
	Integer sotangSanpham_cty;
	
	@ManyToOne
	@JoinColumn(name = "hem")
	private chieuronghem chieuronghem;
	
	
	public chieuronghem getChieuronghem() {
		return chieuronghem;
	}


	public void setChieuronghem(chieuronghem chieuronghem) {
		this.chieuronghem = chieuronghem;
	}


	@ManyToOne
	@JoinColumn(name = "phaply")
	private Phaply phaply;
	
	
	public Phaply getPhaply() {
		return phaply;
	}


	public void setPhaply(Phaply phaply) {
		this.phaply = phaply;
	}


	@NotNull
	@Column(name = "thocu")
	Float thocuSanpham_cty;
	
	@Column(name = "sophongngu")
	Integer sophongnguSanpham_cty;
	
	@Column(name = "sotoilet")
	Integer sotoiletSanpham_cty;
	

	
	@NotNull
	@Column(name = "lon")
	String lonSanpham_cty;
	
	@NotNull
	@Column(name = "lat")
	String latSanpham_cty;
	
	@NotNull
	@Column(name = "chieurong")
	Float chieurongSanpham_cty;
	
	@NotNull
	@Column(name = "chieudai")
	Float chieudaiSanpham_cty;
	
	@ManyToOne
	@JoinColumn(name = "id_duong")
	private Duong duong;

	public Duong getDuong() {
		return duong;
	}

	public void setDuong(Duong duong) {
		this.duong = duong;
	}

	@ManyToOne
	@JoinColumn(name = "id_hinh")
	private hinhanh hinhanh;
	
	
	
	public hinhanh getHinhanh() {
		return hinhanh;
	}


	public void setHinhanh(hinhanh hinhanh) {
		this.hinhanh = hinhanh;
	}


	@NotNull
	@Column(name = "geom")
	String dulieugisSanpham_cty;

	public Long getIdSanphamcty() {
		return idSanphamcty;
	}


	public void setIdSanphamcty(Long idSanphamcty) {
		this.idSanphamcty = idSanphamcty;
	}


	


	public String getNameSanpham_cty() {
		return nameSanpham_cty;
	}


	public void setNameSanpham_cty(String nameSanpham_cty) {
		this.nameSanpham_cty = nameSanpham_cty;
	}


	


	public String getNgaynhapSanpham_cty() {
		return ngaynhapSanpham_cty;
	}


	public void setNgaynhapSanpham_cty(String ngaynhapSanpham_cty) {
		this.ngaynhapSanpham_cty = ngaynhapSanpham_cty;
	}


	public Float getDientichSanpham_cty() {
		return dientichSanpham_cty;
	}


	public void setDientichSanpham_cty(Float dientichSanpham_cty) {
		this.dientichSanpham_cty = dientichSanpham_cty;
	}





	public Float getGiaSanpham_cty() {
		return giaSanpham_cty;
	}


	public void setGiaSanpham_cty(Float giaSanpham_cty) {
		this.giaSanpham_cty = giaSanpham_cty;
	}



	public Integer getSotangSanpham_cty() {
		return sotangSanpham_cty;
	}


	public void setSotangSanpham_cty(Integer sotangSanpham_cty) {
		this.sotangSanpham_cty = sotangSanpham_cty;
	}






	public Float getThocuSanpham_cty() {
		return thocuSanpham_cty;
	}


	public void setThocuSanpham_cty(Float thocuSanpham_cty) {
		this.thocuSanpham_cty = thocuSanpham_cty;
	}


	public Integer getSophongnguSanpham_cty() {
		return sophongnguSanpham_cty;
	}


	public void setSophongnguSanpham_cty(Integer sophongnguSanpham_cty) {
		this.sophongnguSanpham_cty = sophongnguSanpham_cty;
	}


	public Integer getSotoiletSanpham_cty() {
		return sotoiletSanpham_cty;
	}


	public void setSotoiletSanpham_cty(Integer sotoiletSanpham_cty) {
		this.sotoiletSanpham_cty = sotoiletSanpham_cty;
	}


	public String getDulieugisSanpham_cty() {
		return dulieugisSanpham_cty;
	}


	public void setDulieugisSanpham_cty(String dulieugisSanpham_cty) {
		this.dulieugisSanpham_cty = dulieugisSanpham_cty;
	}


	public String getLonSanpham_cty() {
		return lonSanpham_cty;
	}


	public void setLonSanpham_cty(String lonSanpham_cty) {
		this.lonSanpham_cty = lonSanpham_cty;
	}


	public String getLatSanpham_cty() {
		return latSanpham_cty;
	}


	public void setLatSanpham_cty(String latSanpham_cty) {
		this.latSanpham_cty = latSanpham_cty;
	}


	public Float getChieurongSanpham_cty() {
		return chieurongSanpham_cty;
	}


	public void setChieurongSanpham_cty(Float chieurongSanpham_cty) {
		this.chieurongSanpham_cty = chieurongSanpham_cty;
	}


	public Float getChieudaiSanpham_cty() {
		return chieudaiSanpham_cty;
	}


	public void setChieudaiSanpham_cty(Float chieudaiSanpham_cty) {
		this.chieudaiSanpham_cty = chieudaiSanpham_cty;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "idtrangthaigd")
	private Trangthaigd trangthaigd;

	public Trangthaigd getTrangthaigd() {
		return trangthaigd;
	}

	public void setTrangthaigd(Trangthaigd trangthaigd) {
		this.trangthaigd = trangthaigd;
	}
		

}
