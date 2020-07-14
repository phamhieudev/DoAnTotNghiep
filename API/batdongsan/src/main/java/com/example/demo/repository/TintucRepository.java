package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Tintuc;

public interface TintucRepository<P> extends CrudRepository<Tintuc, Long> {

}
