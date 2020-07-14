package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.Sanpham_nguoidung;


public interface Sanpham_ctyRepository<P> extends CrudRepository<Sanpham_cty, Long> {

	@Modifying
	@Query(value = " insert into sanpham_cty (geom,idloai_sanpham,id_vungxa,id_huong,id_donvigia,ngaynhap,dientich,gia,mota,sotang,hem,phaply,thocu,sophongngu,sotoilet,tensanpham,id_duong,lon,lat,chieurong,chieudai,id_hinh,idtrangthaigd) values (ST_SetSRID(ST_MakePoint(:x, :y), 4326),:idloai_sanpham,:id_vungxa,:id_huong,:id_donvigia,:ngaynhap,:dientich,:gia,:mota,:sotang,:hem,:phaply,:thocu,:sophongngu,:sotoilet,:tensanpham,:id_duong,:x1,:y1,:chieurong,:chieudai,:id_hinh,:trangtahigd)", nativeQuery = true)	
	@Transactional
	void addSPCTY(@Param("x") float x
			,@Param("y") float y
			,@Param("idloai_sanpham") Integer idloai_sanpham
			,@Param("id_vungxa") Integer id_vungxa
			,@Param("id_huong") Integer id_huong
			,@Param("id_donvigia") Integer id_donvigia
			,@Param("ngaynhap") String ngaynhap
			,@Param("dientich") float dientich
			,@Param("gia") float gia
			,@Param("mota") Integer mota
			,@Param("sotang") Integer sotang
			,@Param("hem") Integer hem
			,@Param("phaply") Integer phaply
			,@Param("thocu") float thocu
			,@Param("sophongngu") Integer sophongngu
			,@Param("sotoilet") Integer sotoilet
			,@Param("tensanpham") String tensanpham
			,@Param("id_duong") Integer duong
			,@Param("x1") float x1
			,@Param("y1") float y1
			,@Param("chieurong") float chieurong
			,@Param("chieudai") float chieudai
			,@Param("id_hinh") Integer id_hinh
			,@Param("trangtahigd") Integer trangtahigd);
	
	@Modifying
	@Query(value = "update sanpham_cty set geom=ST_SetSRID(ST_MakePoint(:x, :y), 4326),idloai_sanpham=:idloai_sanpham,id_vungxa=:id_vungxa,id_huong=:id_huong,id_donvigia=:id_donvigia,ngaynhap=:ngaynhap,dientich=:dientich,gia=:gia,mota=:mota,sotang=:sotang,hem=:hem,phaply=:phaply,thocu=:thocu,sophongngu=:sophongngu,sotoilet=:sotoilet,tensanpham=:tensanpham,id_duong=:id_duong,lon=:x1,lat=:y1,chieurong=:chieurong,chieudai=:chieudai,id_hinh=:id_hinh,idtrangthaigd=:trangtahigd where sanpham_id =:id", nativeQuery = true)	
	@Transactional
	void updateSPCTY(@Param("x") float x
			,@Param("y") float y
			,@Param("idloai_sanpham") Integer idloai_sanpham
			,@Param("id_vungxa") Integer id_vungxa
			,@Param("id_huong") Integer id_huong
			,@Param("id_donvigia") Integer id_donvigia
			,@Param("ngaynhap") String ngaynhap
			,@Param("dientich") float dientich
			,@Param("gia") float gia
			,@Param("mota") Integer mota
			,@Param("sotang") Integer sotang
			,@Param("hem") Integer hem
			,@Param("phaply") Integer phaply
			,@Param("thocu") float thocu
			,@Param("sophongngu") Integer sophongngu
			,@Param("sotoilet") Integer sotoilet
			,@Param("tensanpham") String tensanpham
			,@Param("id_duong") Integer duong
			,@Param("x1") float x1
			,@Param("y1") float y1
			,@Param("chieurong") float chieurong
			,@Param("chieudai") float chieudai
			,@Param("id_hinh") Integer id_hinh
			,@Param("trangtahigd") Integer trangtahigd
			,@Param("id") Integer idsanpham);
//	@Query(value="SELECT sanpham_id,ST_X(st_transform(ST_SetSRID(geom, 4326), 4326)), ST_Y(st_transform(ST_SetSRID(geom, 4326), 4326)) ,idloai_sanpham,id_vungxa,id_huong,id_donvigia,ngaynhap,dientich,gia,mota,sotang,hem,phaply,thocu,sophongngu,sotoilet,hinhanh,tensanpham,id_duong FROM sanpham_cty WHERE sanpham_id = ?1",nativeQuery=true)
//	List<Sanpham_cty> findbyid(@Param("idSanphamcty")  Collection<Long> idSanphamcty);
	
	// Thống kê theo loại
	List<Sanpham_cty>findByloaisanpham_idLoaisp (Long idLoaisp);
	
	// Thống kê theo vùng
	
	List<Sanpham_cty>findByvungxa_idVungxa (Long idVungxa);
	List<Sanpham_cty>findBytrangthaigd_idTrangthaigd (Long idTrangthaigd);
	@Query(value = "SELECT * FROM sanpham_cty u WHERE u.idloai_sanpham = :idloai and u.id_vungxa = :idvung and u.id_donvigia = :iddonvigia and u.id_donvigia = :iddonvigia and u.gia BETWEEN :nhonhat and :lonnhat and tensanpham like %:ten%", nativeQuery = true)
	List<Sanpham_cty> timkiemvoitukhoanull(
			@Param("idloai") Integer idloai,
			@Param("idvung") Integer idvung,
			@Param("iddonvigia") Integer iddonvigia,
			@Param("nhonhat") float nho,
			@Param("lonnhat") float lon,
			@Param("ten") String tsp)
			;
	@Query(value = "SELECT * FROM sanpham_cty u WHERE u.idloai_sanpham = :idloai and u.idtrangthaigd = :idtrangthaigd", nativeQuery = true)
	List<Sanpham_cty> findByIdSanphamctyidtrangthai(@Param("idloai") Integer idloai,
			@Param("idtrangthaigd") Integer idtrangthaigd);

}
