package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.VungXa;
import com.example.demo.repository.VungXaRepository;




@Service
public class VungXaService {

	@Autowired
	VungXaRepository<VungXa> vungxaRepository;
	
	
	@Transactional
	public List<VungXa> getAllvungxa() {
		return (List<VungXa>) vungxaRepository.findAll();
	}
	
	@Transactional
	public Optional<VungXa> getById(Long id) {
		return vungxaRepository.findById(id);
	}
	
	
	
	 public VungXa findxy(float x, float y){
			return vungxaRepository.selectxy(x,y);
		}
	
	public VungXa updateDVungXa(Long idVungxa, VungXa adminEntity) {
		VungXa updatedVungXa;
		Optional<VungXa> searchEntity = vungxaRepository.findById(idVungxa);
		if (searchEntity.isPresent()) {
			VungXa vungxa = searchEntity.get();
			vungxa.setTenVungxa(adminEntity.getTenVungxa());
			//vungxa.setDulieugisVungxa(adminEntity.getDulieugisVungxa());
			updatedVungXa = vungxaRepository.save(vungxa);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedVungXa;
	}
}
