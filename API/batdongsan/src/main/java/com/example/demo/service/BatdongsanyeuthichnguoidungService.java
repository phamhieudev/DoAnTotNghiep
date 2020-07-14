package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Batdongsanyeuthichnguoidung;
import com.example.demo.entity.batdongsanyeuthichcty;
import com.example.demo.repository.BatdongsanyeuthichnguoidungRepository;


@Service
public class BatdongsanyeuthichnguoidungService {

	@Autowired
	BatdongsanyeuthichnguoidungRepository<Batdongsanyeuthichnguoidung> batdongsanyeuthichnguoidungRepository;
	
	
	@Transactional
	public List<Batdongsanyeuthichnguoidung> getAllbatdongsanyeuthichnguoidung() {
		return (List<Batdongsanyeuthichnguoidung>) batdongsanyeuthichnguoidungRepository.findAll();
	}
	public void addspcty(
			Integer c
			,Integer d) {
		batdongsanyeuthichnguoidungRepository.addspyeuthichnd(c,d);
	}
	
	public List<Batdongsanyeuthichnguoidung> findBynguoidung_idNguoidung(Long idNguoidung){
		return batdongsanyeuthichnguoidungRepository.findBynguoidung_idNguoidung(idNguoidung);
	}
	@Transactional
	public Optional<Batdongsanyeuthichnguoidung> getById(Long id) {
		return batdongsanyeuthichnguoidungRepository.findById(id);
	}
		
	   public ResponseEntity<Batdongsanyeuthichnguoidung> deletebatdongsanyeuthichnguoidung(Long batdongsanyeuthichnguoidungId) {
	        Optional<Batdongsanyeuthichnguoidung> batdongsanyeuthichnguoidungEntity = batdongsanyeuthichnguoidungRepository.findById(batdongsanyeuthichnguoidungId);
	        if (batdongsanyeuthichnguoidungEntity.isPresent()) {
	        	Batdongsanyeuthichnguoidung batdongsanyeuthichnguoidung = batdongsanyeuthichnguoidungEntity.get();
	        	batdongsanyeuthichnguoidungRepository.delete(batdongsanyeuthichnguoidung);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }
}
