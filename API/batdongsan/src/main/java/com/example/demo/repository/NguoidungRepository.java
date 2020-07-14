package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Nguoidung;

public interface NguoidungRepository<P> extends CrudRepository<Nguoidung, Long> {

}
