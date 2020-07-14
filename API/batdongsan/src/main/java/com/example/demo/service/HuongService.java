package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Huong;
import com.example.demo.repository.HuongRepository;


@Service
public class HuongService {


	@Autowired
	HuongRepository<Huong> huongRepository;
	
	
	@Transactional
	public List<Huong> getAllhuong() {
		return (List<Huong>) huongRepository.findAll();
	}
}
