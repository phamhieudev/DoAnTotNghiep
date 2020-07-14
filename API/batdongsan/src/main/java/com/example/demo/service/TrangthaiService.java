package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Trangthai;
import com.example.demo.repository.TrangthaiRepository;

@Service
public class TrangthaiService {
	
	@Autowired
	TrangthaiRepository<Trangthai> trangthaiRepo;
	
	@Transactional
	public List<Trangthai> getAlltrangthai() {
		return (List<Trangthai>) trangthaiRepo.findAll();
	}

}
