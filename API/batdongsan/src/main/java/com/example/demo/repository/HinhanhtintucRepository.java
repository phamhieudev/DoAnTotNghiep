package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.hinhanh;
import com.example.demo.entity.hinhanhtintuc;

public interface HinhanhtintucRepository<P> extends CrudRepository<hinhanhtintuc, Long> {

}
