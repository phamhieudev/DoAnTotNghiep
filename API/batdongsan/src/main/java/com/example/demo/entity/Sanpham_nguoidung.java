package com.example.demo.entity;

import java.util.Collection;

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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sanpham_nguoidung")
public class Sanpham_nguoidung {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sanphamnguoidung")
	Long idSanphamnguoidung;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sanphamnguoidung")
	private Collection<Hinhanhchitietspnd> hinhanhchitietspnds;
	

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
	String nameSanphamnguoidung;
	
	@NotNull
	@Column(name = "ngaynhap")
	String ngaynhapSanphamnguoidung;
	
	@NotNull
	@Column(name = "dientich")
	Float dientichSanphamnguoidung;
	
	@NotNull
	@Column(name = "gia")
	Float giaSanphamnguoidung;
	
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
	Integer sotangSanphamnguoidung;
	
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
	Float thocuSanphamnguoidung;
	
	@Column(name = "sophongngu")
	Integer sophongnguSanphamnguoidung;
	
	@Column(name = "sotoilet")
	Integer sotoiletSanphamnguoidung;
	
	@NotNull
	@Column(name = "lon")
	String lonSanpham_nguoidung;
	
	@NotNull
	@Column(name = "lat")
	String latSanpham_nguoidung;
	
	@NotNull
	@Column(name = "chieurong")
	Float chieurongSanpham_nguoidung;
	
	@NotNull
	@Column(name = "chieudai")
	Float chieudaiSanpham_nguoidung;
	
	@ManyToOne
	@JoinColumn(name = "id_duong")
	private Duong duong;

	public Duong getDuong() {
		return duong;
	}

	public void setDuong(Duong duong) {
		this.duong = duong;
	}
	

	
	@NotNull
	@Column(name = "geom")
	String geomSanphamnguoidung;
	
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
	@JoinColumn(name = "id_trangthai")
	private Trangthai trangthai;

	public Trangthai getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Trangthai trangthai) {
		this.trangthai = trangthai;
	}

	public Long getIdSanphamnguoidung() {
		return idSanphamnguoidung;
	}

	public void setIdSanphamnguoidung(Long idSanphamnguoidung) {
		this.idSanphamnguoidung = idSanphamnguoidung;
	}

	public String getNameSanphamnguoidung() {
		return nameSanphamnguoidung;
	}

	public void setNameSanphamnguoidung(String nameSanphamnguoidung) {
		this.nameSanphamnguoidung = nameSanphamnguoidung;
	}

	public String getNgaynhapSanphamnguoidung() {
		return ngaynhapSanphamnguoidung;
	}

	public void setNgaynhapSanphamnguoidung(String ngaynhapSanphamnguoidung) {
		this.ngaynhapSanphamnguoidung = ngaynhapSanphamnguoidung;
	}

	public Float getDientichSanphamnguoidung() {
		return dientichSanphamnguoidung;
	}

	public void setDientichSanphamnguoidung(Float dientichSanphamnguoidung) {
		this.dientichSanphamnguoidung = dientichSanphamnguoidung;
	}

	public Float getGiaSanphamnguoidung() {
		return giaSanphamnguoidung;
	}

	public void setGiaSanphamnguoidung(Float giaSanphamnguoidung) {
		this.giaSanphamnguoidung = giaSanphamnguoidung;
	}

	

	public Integer getSotangSanphamnguoidung() {
		return sotangSanphamnguoidung;
	}

	public void setSotangSanphamnguoidung(Integer sotangSanphamnguoidung) {
		this.sotangSanphamnguoidung = sotangSanphamnguoidung;
	}





	public Float getThocuSanphamnguoidung() {
		return thocuSanphamnguoidung;
	}

	public void setThocuSanphamnguoidung(Float thocuSanphamnguoidung) {
		this.thocuSanphamnguoidung = thocuSanphamnguoidung;
	}

	public Integer getSophongnguSanphamnguoidung() {
		return sophongnguSanphamnguoidung;
	}

	public void setSophongnguSanphamnguoidung(Integer sophongnguSanphamnguoidung) {
		this.sophongnguSanphamnguoidung = sophongnguSanphamnguoidung;
	}

	public Integer getSotoiletSanphamnguoidung() {
		return sotoiletSanphamnguoidung;
	}

	public void setSotoiletSanphamnguoidung(Integer sotoiletSanphamnguoidung) {
		this.sotoiletSanphamnguoidung = sotoiletSanphamnguoidung;
	}

	public String getLonSanpham_nguoidung() {
		return lonSanpham_nguoidung;
	}

	public void setLonSanpham_nguoidung(String lonSanpham_nguoidung) {
		this.lonSanpham_nguoidung = lonSanpham_nguoidung;
	}

	public String getLatSanpham_nguoidung() {
		return latSanpham_nguoidung;
	}

	public void setLatSanpham_nguoidung(String latSanpham_nguoidung) {
		this.latSanpham_nguoidung = latSanpham_nguoidung;
	}

	public Float getChieurongSanpham_nguoidung() {
		return chieurongSanpham_nguoidung;
	}

	public void setChieurongSanpham_nguoidung(Float chieurongSanpham_nguoidung) {
		this.chieurongSanpham_nguoidung = chieurongSanpham_nguoidung;
	}

	public Float getChieudaiSanpham_nguoidung() {
		return chieudaiSanpham_nguoidung;
	}

	public void setChieudaiSanpham_nguoidung(Float chieudaiSanpham_nguoidung) {
		this.chieudaiSanpham_nguoidung = chieudaiSanpham_nguoidung;
	}

	public String getGeomSanphamnguoidung() {
		return geomSanphamnguoidung;
	}

	public void setGeomSanphamnguoidung(String geomSanphamnguoidung) {
		this.geomSanphamnguoidung = geomSanphamnguoidung;
	}

	
	@ManyToOne
	@JoinColumn(name = "hinhanh")
	private hinhanh hinhanhnd;
	
	
	
	public hinhanh getHinhanh() {
		return hinhanhnd;
	}


	public void setHinhanh(hinhanh hinhanh) {
		this.hinhanhnd = hinhanh;
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
