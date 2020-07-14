package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.entity.batdongsanyeuthichcty;

public interface BatdongsanyeuthichctyRepository<P> extends CrudRepository<batdongsanyeuthichcty, Long> {

	@Modifying
	@Query(value = " insert into batdongsanyeuthichcty (id_nguoidung,id_spcty) values (:id_nguoidung,:id_spcty)", nativeQuery = true)	
	@Transactional
	void addspyeuthich(
			@Param("id_nguoidung") Integer id_nguoidung
			,@Param("id_spcty") Integer id_spcty);
	
	List<batdongsanyeuthichcty> findBynguoidung_idNguoidung(Long idNguoidung);

}
