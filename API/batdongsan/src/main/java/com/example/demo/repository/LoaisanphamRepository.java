package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Loaisanpham;

public interface LoaisanphamRepository<P> extends CrudRepository<Loaisanpham, Long> {

}
