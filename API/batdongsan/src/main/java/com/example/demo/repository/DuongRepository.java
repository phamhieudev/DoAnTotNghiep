package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Duong;

public interface DuongRepository<P> extends CrudRepository<Duong, Long> {
	
	List<Duong> findByvungxa_idVungxa(Long idVungxa);

}
