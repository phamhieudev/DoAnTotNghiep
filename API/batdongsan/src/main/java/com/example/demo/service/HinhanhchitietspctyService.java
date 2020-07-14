package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hinhanhchitietspcty;
import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.entity.hinhanh;
import com.example.demo.repository.HinhanhchitietspctyRepository;

@Service
public class HinhanhchitietspctyService {

	

	@Autowired
	HinhanhchitietspctyRepository<Hinhanhchitietspcty> HinhanhchitietspctyRepository;
	
	
	@Transactional
	public List<Hinhanhchitietspcty> getAllHinhanhchitietspcty() {
		return (List<Hinhanhchitietspcty>) HinhanhchitietspctyRepository.findAll();
	}
	
	@Transactional
	public Optional<Hinhanhchitietspcty> getById(Long id) {
		return HinhanhchitietspctyRepository.findById(id);
	}
		
	@Transactional
	public List<Hinhanhchitietspcty> getAllhinhanhtheosp(Long idsp) {
		return (List<Hinhanhchitietspcty>) HinhanhchitietspctyRepository.findBysanphamcty_idSanphamcty(idsp);
	}
	
	   public ResponseEntity<Object> deleteHinhanhchitietspcty(Long HinhanhchitietspctyId) {
	        Optional<Hinhanhchitietspcty> HinhanhchitietspctyEntity = HinhanhchitietspctyRepository.findById(HinhanhchitietspctyId);
	        if (HinhanhchitietspctyEntity.isPresent()) {
	            Hinhanhchitietspcty Hinhanhchitietspcty = HinhanhchitietspctyEntity.get();
	            HinhanhchitietspctyRepository.delete(Hinhanhchitietspcty);
	        } else {
	            throw new EntityExistsException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   @Transactional
		public Hinhanhchitietspcty createhinhanh(Hinhanhchitietspcty hinhanh) {
	        return HinhanhchitietspctyRepository.save(hinhanh);
	    }

}
