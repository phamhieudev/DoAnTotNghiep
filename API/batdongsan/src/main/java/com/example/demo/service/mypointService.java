package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Duong;
import com.example.demo.entity.Nguoidung;
import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.mypoint;
import com.example.demo.repository.mypointRepository;

@Service
public class mypointService {

	@Autowired
	mypointRepository<mypoint> mypointrepo;
	
	@Transactional
	public List<mypoint> getAll() {
		return (List<mypoint>) mypointrepo.findAll();
	}
	
	public void add(Integer id,float x, float y,String name,String url) {
		mypointrepo.addSPCTY(id,x,y,name,url);
	}
	
	public List<mypoint> findByid(Long id) {
		System.out.println("Received GET request service:" + id);
		return (List<mypoint>) mypointrepo.findOneById(id);
	}
	
	public void edit(Integer d,float b, float c,String a,Integer d1) {
		mypointrepo.updateSPCTY(d,b,c,a,d1);
	}
}
