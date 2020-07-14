package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Huong;

public interface HuongRepository<P> extends CrudRepository<Huong, Long> {

}
