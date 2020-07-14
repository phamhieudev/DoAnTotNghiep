package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hinhanhchitietspnd;
import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.entity.hinhanh;
import com.example.demo.repository.HinhanhchitietspndRepository;

@Service
public class HinhanhchitietspndService {

	

	@Autowired
	HinhanhchitietspndRepository<Hinhanhchitietspnd> HinhanhchitietspndRepository;
	
	
	@Transactional
	public List<Hinhanhchitietspnd> getAllHinhanhchitietspnd() {
		return (List<Hinhanhchitietspnd>) HinhanhchitietspndRepository.findAll();
	}
	
	@Transactional
	public Optional<Hinhanhchitietspnd> getById(Long id) {
		return HinhanhchitietspndRepository.findById(id);
	}
		
	@Transactional
	public List<Hinhanhchitietspnd> getAllhinhanhtheosp(Long idsp) {
		return (List<Hinhanhchitietspnd>) HinhanhchitietspndRepository.findBysanphamnguoidung_idSanphamnguoidung(idsp);
	}
	
	   public ResponseEntity<Object> deleteHinhanhchitietspnd(Long HinhanhchitietspndId) {
	        Optional<Hinhanhchitietspnd> HinhanhchitietspndEntity = HinhanhchitietspndRepository.findById(HinhanhchitietspndId);
	        if (HinhanhchitietspndEntity.isPresent()) {
	            Hinhanhchitietspnd Hinhanhchitietspnd = HinhanhchitietspndEntity.get();
	            HinhanhchitietspndRepository.delete(Hinhanhchitietspnd);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   @Transactional
		public Hinhanhchitietspnd createhinhanh(Hinhanhchitietspnd hinhanh) {
	        return HinhanhchitietspndRepository.save(hinhanh);
	    }

}
