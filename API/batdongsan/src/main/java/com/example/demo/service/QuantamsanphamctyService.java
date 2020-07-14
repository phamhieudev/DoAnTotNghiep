package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Loaisanpham;
import com.example.demo.entity.Quantamsanphamcty;
import com.example.demo.repository.QuantamsanphamctyRepository;



@Service
public class QuantamsanphamctyService {
	
	@Autowired
	QuantamsanphamctyRepository<Quantamsanphamcty> QuantamsanphamctyRepository;
	
	
	@Transactional
	public List<Quantamsanphamcty> getAllQuantamsanphamcty() {
		return (List<Quantamsanphamcty>) QuantamsanphamctyRepository.findAll();
	}
	
	@Transactional
	public Optional<Quantamsanphamcty> getById(Long id) {
		return QuantamsanphamctyRepository.findById(id);
	}
		
	
	
	   public ResponseEntity<Object> deleteQuantamsanphamcty(Long QuantamsanphamctyId) {
	        Optional<Quantamsanphamcty> QuantamsanphamctyEntity = QuantamsanphamctyRepository.findById(QuantamsanphamctyId);
	        if (QuantamsanphamctyEntity.isPresent()) {
	        	Quantamsanphamcty Quantamsanphamcty = QuantamsanphamctyEntity.get();
	        	QuantamsanphamctyRepository.delete(Quantamsanphamcty);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   @Transactional
		public boolean addQuantamsanphamcty(Quantamsanphamcty Quantamsanphamcty) {
			return QuantamsanphamctyRepository.save(Quantamsanphamcty) != null;
		}

	

}
