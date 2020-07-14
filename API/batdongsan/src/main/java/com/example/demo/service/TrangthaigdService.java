package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Trangthaigd;
import com.example.demo.repository.TrangthaigdRepository;


@Service
public class TrangthaigdService {


	@Autowired
	TrangthaigdRepository<Trangthaigd> TrangthaigdRepository;
	
	
	@Transactional
	public List<Trangthaigd> getAllTrangthaigd() {
		return (List<Trangthaigd>) TrangthaigdRepository.findAll();
	}
	
	@Transactional
	public Optional<Trangthaigd> getById(Long id) {
		return TrangthaigdRepository.findById(id);
	}
		
	
	
	   public ResponseEntity<Object> deleteTrangthaigd(Long TrangthaigdId) {
	        Optional<Trangthaigd> TrangthaigdEntity = TrangthaigdRepository.findById(TrangthaigdId);
	        if (TrangthaigdEntity.isPresent()) {
	            Trangthaigd Trangthaigd = TrangthaigdEntity.get();
	            TrangthaigdRepository.delete(Trangthaigd);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   @Transactional
		public boolean addTrangthaigd(Trangthaigd Trangthaigd) {
			return TrangthaigdRepository.save(Trangthaigd) != null;
		}

	
}
