package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.chieuronghem;
import com.example.demo.repository.ChieuronghemRepository;

@Service
public class ChieuronghemService {

	@Autowired
	ChieuronghemRepository<chieuronghem> ChieuronghemRepository;
	
	
	@Transactional
	public List<chieuronghem> getAllChieuronghem() {
		return (List<chieuronghem>) ChieuronghemRepository.findAll();
	}
	
	@Transactional
	public Optional<chieuronghem> getById(Long id) {
		return ChieuronghemRepository.findById(id);
	}
		
	   public ResponseEntity<Object> deleteChieuronghem(Long ChieuronghemId) {
	        Optional<chieuronghem> ChieuronghemEntity = ChieuronghemRepository.findById(ChieuronghemId);
	        if (ChieuronghemEntity.isPresent()) {
	        	chieuronghem Chieuronghem = ChieuronghemEntity.get();
	        	ChieuronghemRepository.delete(Chieuronghem);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   public chieuronghem addChieuronghem(chieuronghem Chieuronghem) {
	        return ChieuronghemRepository.save(Chieuronghem);
	    }
}
