package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Batdongsanyeuthichnguoidung;
import com.example.demo.entity.batdongsanyeuthichcty;

public interface BatdongsanyeuthichnguoidungRepository<P> extends CrudRepository<Batdongsanyeuthichnguoidung, Long> {

	@Modifying
	@Query(value = " insert into batdongsanyeuthichnguoidung (id_nguoidung,id_sanphamnguoidung) values (:id_nguoidung,:id_sanphamnguoidung)", nativeQuery = true)	
	@Transactional
	void addspyeuthichnd(
			@Param("id_nguoidung") Integer id_nguoidung
			,@Param("id_sanphamnguoidung") Integer id_sanphamnguoidung);
	
	List<Batdongsanyeuthichnguoidung> findBynguoidung_idNguoidung(Long idNguoidung);

}
