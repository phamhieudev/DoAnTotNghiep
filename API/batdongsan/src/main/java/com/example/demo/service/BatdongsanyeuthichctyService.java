package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.batdongsanyeuthichcty;
import com.example.demo.repository.BatdongsanyeuthichctyRepository;



@Service
public class BatdongsanyeuthichctyService {

	@Autowired
	BatdongsanyeuthichctyRepository<batdongsanyeuthichcty> batdongsanyeuthichctyRepository;
	
	
	@Transactional
	public List<batdongsanyeuthichcty> getAllbatdongsanyeuthichcty() {
		return (List<batdongsanyeuthichcty>) batdongsanyeuthichctyRepository.findAll();
	}
	public void addspcty(
			Integer c
			,Integer d) {
		batdongsanyeuthichctyRepository.addspyeuthich(c,d);
	}
	
	public List<batdongsanyeuthichcty> findBynguoidung_idNguoidung(Long idNguoidung){
		return batdongsanyeuthichctyRepository.findBynguoidung_idNguoidung(idNguoidung);
	}
	
	@Transactional
	public Optional<batdongsanyeuthichcty> getById(Long id) {
		return batdongsanyeuthichctyRepository.findById(id);
	}
		
	   public ResponseEntity<batdongsanyeuthichcty> deletebatdongsanyeuthichcty(Long batdongsanyeuthichctyId) {
	        Optional<batdongsanyeuthichcty> batdongsanyeuthichctyEntity = batdongsanyeuthichctyRepository.findById(batdongsanyeuthichctyId);
	        if (batdongsanyeuthichctyEntity.isPresent()) {
	        	batdongsanyeuthichcty batdongsanyeuthichcty = batdongsanyeuthichctyEntity.get();
	        	batdongsanyeuthichctyRepository.delete(batdongsanyeuthichcty);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }
}
