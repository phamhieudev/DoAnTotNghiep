package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Trangthai;

public interface TrangthaiRepository<P> extends CrudRepository<Trangthai, Long> {

}
