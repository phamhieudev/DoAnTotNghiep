package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Donvigia;

public interface DonvigiaRepository<P> extends CrudRepository<Donvigia, Long> {

}
