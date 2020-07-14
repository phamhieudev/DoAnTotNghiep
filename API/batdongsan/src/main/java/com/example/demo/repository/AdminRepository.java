package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Admin;

public interface AdminRepository<P> extends CrudRepository<Admin, Long> {

}
