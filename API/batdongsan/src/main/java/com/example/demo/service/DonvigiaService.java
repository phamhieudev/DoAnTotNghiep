package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donvigia;
import com.example.demo.repository.DonvigiaRepository;


@Service
public class DonvigiaService {

	@Autowired
	DonvigiaRepository<Donvigia> donvigiaRepository;
	
	
	@Transactional
	public List<Donvigia> getAlldonvigia() {
		return (List<Donvigia>) donvigiaRepository.findAll();
	}
	
	@Transactional
	public Optional<Donvigia> getById(Long id) {
		return donvigiaRepository.findById(id);
	}
		
	
	
	   public ResponseEntity<Object> deletedonvigia(Long donvigiaId) {
	        Optional<Donvigia> donvigiaEntity = donvigiaRepository.findById(donvigiaId);
	        if (donvigiaEntity.isPresent()) {
	        	Donvigia donvigia = donvigiaEntity.get();
	        	donvigiaRepository.delete(donvigia);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   public Donvigia addDonvigia(Donvigia donvigia) {
	        return donvigiaRepository.save(donvigia);
	    }

	public Donvigia updateDonvigia(Long idDonvigia, Donvigia adminEntity) {
		Donvigia updatedDonvigia;
		Optional<Donvigia> searchEntity = donvigiaRepository.findById(idDonvigia);
		if (searchEntity.isPresent()) {
			Donvigia donvigia = searchEntity.get();
			donvigia.setTenDonvigia(adminEntity.getTenDonvigia());
			updatedDonvigia = donvigiaRepository.save(donvigia);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedDonvigia;
	}
}
