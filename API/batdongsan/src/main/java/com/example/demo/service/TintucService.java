package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tintuc;
import com.example.demo.repository.TintucRepository;



@Service
public class TintucService {
	
	@Autowired
	TintucRepository<Tintuc> tintucRepository;
	
	
	@Transactional
	public List<Tintuc> getAlltintuc() {
		return (List<Tintuc>) tintucRepository.findAll();
	}
	
	@Transactional
	public Optional<Tintuc> getById(Long id) {
		return tintucRepository.findById(id);
	}
		
	
	
	   public ResponseEntity<Object> deletetintuc(Long tintucId) {
	        Optional<Tintuc> tintucEntity = tintucRepository.findById(tintucId);
	        if (tintucEntity.isPresent()) {
	        	Tintuc tintuc = tintucEntity.get();
	        	tintucRepository.delete(tintuc);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   public Tintuc addTintuc(Tintuc tintuc) {
	        return tintucRepository.save(tintuc);
	    }

	public Tintuc updateTintuc(Long idTintuc, Tintuc tintucEntity) {
		Tintuc updatedTintuc;
		Optional<Tintuc> searchEntity = tintucRepository.findById(idTintuc);
		if (searchEntity.isPresent()) {
			Tintuc tintuc = searchEntity.get();
			tintuc.setTenTintuc(tintucEntity.getTenTintuc());
			tintuc.setNoidungTintuc(tintucEntity.getNoidungTintuc());
			tintuc.setNgaydangTintuc(tintucEntity.getNgaydangTintuc());
			tintuc.setHinhanhtintuc(tintucEntity.getHinhanhtintuc());
			updatedTintuc = tintucRepository.save(tintuc);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedTintuc;
	}

	
}
