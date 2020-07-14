package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Hinhanhchitietspnd;


public interface HinhanhchitietspndRepository<P> extends CrudRepository<Hinhanhchitietspnd, Long> {

	List<Hinhanhchitietspnd> findBysanphamnguoidung_idSanphamnguoidung(Long idSanphamnguoidung);
}
