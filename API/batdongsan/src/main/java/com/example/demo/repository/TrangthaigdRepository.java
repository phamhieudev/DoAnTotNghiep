package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Loaisanpham;
import com.example.demo.entity.Trangthaigd;

public interface TrangthaigdRepository<P> extends CrudRepository<Trangthaigd, Long> {

}
