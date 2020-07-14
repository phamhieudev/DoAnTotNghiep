package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Hinhanhchitietspcty;
import com.example.demo.entity.Hinhanhchitietspnd;


public interface HinhanhchitietspctyRepository<P> extends CrudRepository<Hinhanhchitietspcty, Long> {

	List<Hinhanhchitietspcty> findBysanphamcty_idSanphamcty(Long idSanphamcty);
}
