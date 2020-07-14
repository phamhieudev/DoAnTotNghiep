package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Phaply;
import com.example.demo.repository.PhaplyRepository;

@Service
public class PhaplyService {

	@Autowired
	PhaplyRepository<Phaply> PhaplyRepository;
	
	
	@Transactional
	public List<Phaply> getAllPhaply() {
		return (List<Phaply>) PhaplyRepository.findAll();
	}
	
	@Transactional
	public Optional<Phaply> getById(Long id) {
		return PhaplyRepository.findById(id);
	}
		
	
	
	   public ResponseEntity<Object> deletePhaply(Long PhaplyId) {
	        Optional<Phaply> PhaplyEntity = PhaplyRepository.findById(PhaplyId);
	        if (PhaplyEntity.isPresent()) {
	        	Phaply Phaply = PhaplyEntity.get();
	        	PhaplyRepository.delete(Phaply);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   public Phaply addPhaply(Phaply Phaply) {
	        return PhaplyRepository.save(Phaply);
	    }
}
