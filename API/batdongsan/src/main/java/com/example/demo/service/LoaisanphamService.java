package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Loaisanpham;
import com.example.demo.repository.LoaisanphamRepository;


@Service
public class LoaisanphamService {


	@Autowired
	LoaisanphamRepository<Loaisanpham> loaisanphamRepository;
	
	
	@Transactional
	public List<Loaisanpham> getAllloaisanpham() {
		return (List<Loaisanpham>) loaisanphamRepository.findAll();
	}
	
	@Transactional
	public Optional<Loaisanpham> getById(Long id) {
		return loaisanphamRepository.findById(id);
	}
		
	
	
	   public ResponseEntity<Object> deleteLoaisanpham(Long loaisanphamId) {
	        Optional<Loaisanpham> loaisanphamEntity = loaisanphamRepository.findById(loaisanphamId);
	        if (loaisanphamEntity.isPresent()) {
	            Loaisanpham loaisanpham = loaisanphamEntity.get();
	            loaisanphamRepository.delete(loaisanpham);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   @Transactional
		public boolean addLoaisanpham(Loaisanpham loaisanpham) {
			return loaisanphamRepository.save(loaisanpham) != null;
		}

	public Loaisanpham updateLoaisanpham(Long idLoaisp, Loaisanpham loaisanphamEntity) {
		Loaisanpham updatedLoaisanpham;
		Optional<Loaisanpham> searchEntity = loaisanphamRepository.findById(idLoaisp);
		if (searchEntity.isPresent()) {
			Loaisanpham loaisanpham = searchEntity.get();
			loaisanpham.setTenLoaisp(loaisanphamEntity.getTenLoaisp());
			updatedLoaisanpham = loaisanphamRepository.save(loaisanpham);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedLoaisanpham;
	}
}
