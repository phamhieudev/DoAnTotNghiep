package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.Sanpham_nguoidung;

public interface Sanpham_nguoidungRepository<P> extends CrudRepository<Sanpham_nguoidung, Long> {

	// Thống kê theo loại
	List<Sanpham_nguoidung> findByloaisanpham_idLoaisp(Long idLoaisp);

	// Thống kê theo vùng

	List<Sanpham_nguoidung> findByvungxa_idVungxa(Long idVungxa);

	List<Sanpham_nguoidung> findBynguoidung_idNguoidung(Long idNguoidung);

	List<Sanpham_nguoidung> findBytrangthai_idTrangthai(Long idTrangthai);
	
	List<Sanpham_nguoidung>findBytrangthaigd_idTrangthaigd (Long idTrangthaigd);

	@Modifying
	@Query(value = " insert into sanpham_nguoidung (geom,idloai_sanpham,id_vungxa,id_huong,id_donvigia,ngaynhap,dientich,gia,mota,sotang,hem,phaply,thocu,sophongngu,sotoilet,tensanpham,id_duong,lon,lat,chieurong,chieudai,id_nguoidung,id_trangthai,hinhanh,idtrangthaigd) values (ST_SetSRID(ST_MakePoint(:x, :y), 4326),:idloai_sanpham,:id_vungxa,:id_huong,:id_donvigia,:ngaynhap,:dientich,:gia,:mota,:sotang,:hem,:phaply,:thocu,:sophongngu,:sotoilet,:tensanpham,:id_duong,:x1,:y1,:chieurong,:chieudai,:id_nguoidung,:id_trangthai,:hinhanh,:trangthaigd)", nativeQuery = true)
	@Transactional
	void addSPCTY(@Param("x") float x, @Param("y") float y, @Param("idloai_sanpham") Integer idloai_sanpham,
			@Param("id_vungxa") Integer id_vungxa, @Param("id_huong") Integer id_huong,
			@Param("id_donvigia") Integer id_donvigia, @Param("ngaynhap") String ngaynhap,
			@Param("dientich") float dientich, @Param("gia") float gia, @Param("mota") Integer mota,
			@Param("sotang") Integer sotang, @Param("hem") Integer hem, @Param("phaply") Integer phaply,
			@Param("thocu") float thocu, @Param("sophongngu") Integer sophongngu, @Param("sotoilet") Integer sotoilet,
			@Param("tensanpham") String tensanpham, @Param("id_duong") Integer duong, @Param("x1") float x1,
			@Param("y1") float y1, @Param("chieurong") float chieurong, @Param("chieudai") float chieudai,
			 @Param("id_nguoidung") Integer id_nguoidung,
			@Param("id_trangthai") Integer id_trangthai
			,@Param("hinhanh") Integer id_hinh
			,@Param("trangthaigd") Integer idtrangthaigd);

	@Modifying
	@Query(value = "update sanpham_nguoidung set geom=ST_SetSRID(ST_MakePoint(:x, :y), 4326),idloai_sanpham=:idloai_sanpham,id_vungxa=:id_vungxa,id_huong=:id_huong,id_donvigia=:id_donvigia,ngaynhap=:ngaynhap,dientich=:dientich,gia=:gia,mota=:mota,sotang=:sotang,hem=:hem,phaply=:phaply,thocu=:thocu,sophongngu=:sophongngu,sotoilet=:sotoilet,tensanpham=:tensanpham,id_duong=:id_duong,lon=:x1,lat=:y1,chieurong=:chieurong,chieudai=:chieudai,id_nguoidung=:id_nguoidung,id_trangthai=:id_trangthai,hinhanh=:hinhanh,idtrangthaigd=:trangthaigd where id_sanphamnguoidung =:id", nativeQuery = true)
	@Transactional
	void updateSPnd(@Param("x") float x, @Param("y") float y, @Param("idloai_sanpham") Integer idloai_sanpham,
			@Param("id_vungxa") Integer id_vungxa, @Param("id_huong") Integer id_huong,
			@Param("id_donvigia") Integer id_donvigia, @Param("ngaynhap") String ngaynhap,
			@Param("dientich") float dientich, @Param("gia") float gia, @Param("mota") Integer mota,
			@Param("sotang") Integer sotang, @Param("hem") Integer hem, @Param("phaply") Integer phaply,
			@Param("thocu") float thocu, @Param("sophongngu") Integer sophongngu, @Param("sotoilet") Integer sotoilet,
			@Param("tensanpham") String tensanpham, @Param("id_duong") Integer duong, @Param("x1") float x1,
			@Param("y1") float y1, @Param("chieurong") float chieurong, @Param("chieudai") float chieudai,
			 @Param("id_nguoidung") Integer id_nguoidung,
			@Param("id_trangthai") Integer id_trangthai
			,@Param("hinhanh") Integer id_hinh
			,@Param("trangthaigd") Integer idtrangthaigd
			,@Param("id") Integer idsp);

	@Query(value = "SELECT * FROM sanpham_nguoidung u WHERE u.idloai_sanpham = :idloai and u.id_trangthai = :idtrang and u.idtrangthaigd = :idtrangthaigd", nativeQuery = true)
	List<Sanpham_nguoidung> findByIdSanphamnguoidung(@Param("idloai") Integer idloai,
			@Param("idtrang") Integer idtrang,
			@Param("idtrangthaigd") Integer idtrangthaigd);

	@Query(value = "SELECT * FROM sanpham_nguoidung u WHERE u.id_trangthai = :idtrang and u.idloai_sanpham = :idloai and u.id_vungxa = :idvung and u.id_donvigia = :iddonvigia and u.id_donvigia = :iddonvigia and u.gia BETWEEN :nhonhat and :lonnhat and u.idtrangthaigd = :trangthaigd", nativeQuery = true)
	List<Sanpham_nguoidung> timkiemvoitukhoanull(@Param("idtrang") Integer idtrang,
			@Param("idloai") Integer idloai,
			@Param("idvung") Integer idvung,
			@Param("iddonvigia") Integer iddonvigia,
			@Param("nhonhat") float nho,
			@Param("lonnhat") float lon,
			@Param("trangthaigd") Integer trangthaigd)
			;
	
	@Query(value = "SELECT * FROM sanpham_nguoidung u WHERE u.idtrangthaigd =:idtrangthaigd and u.id_trangthai = :idtrang and u.id_nguoidung = :idnguoidung", nativeQuery = true)
	List<Sanpham_nguoidung> findByidnguoidungtindang(@Param("idtrangthaigd") Integer idtrangthaigd,
			@Param("idtrang") Integer idTrangthai
			,@Param("idnguoidung") Integer idnguoidung);
}
