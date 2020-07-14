package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Phaply;

public interface PhaplyRepository<P> extends CrudRepository<Phaply, Long> {

}
