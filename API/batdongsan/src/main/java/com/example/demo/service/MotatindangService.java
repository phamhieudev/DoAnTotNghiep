package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Motatindang;
import com.example.demo.repository.MotatindangRepository;





@Service
public class MotatindangService {

	@Autowired
	MotatindangRepository<Motatindang> MotatindangRepository;
	
	@Transactional
	public List<Motatindang> getAllMotatindang() {
		return (List<Motatindang>) MotatindangRepository.findAll();
	}
	
	@Transactional
	public Optional<Motatindang> getById(Long id) {
		return MotatindangRepository.findById(id);
	}
	
	@Transactional
	public Motatindang createMotatindang(Motatindang Motatindang) {
        return MotatindangRepository.save(Motatindang);
    }
	
	public Motatindang updateMotatindang(Long idhinh, Motatindang MotatindangEntity) {
		Motatindang updatedMotatindang;
		Optional<Motatindang> searchEntity = MotatindangRepository.findById(idhinh);
		if (searchEntity.isPresent()) {
			Motatindang Motatindang = searchEntity.get();
			Motatindang.setNoidung(MotatindangEntity.getNoidung());
			updatedMotatindang = MotatindangRepository.save(Motatindang);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedMotatindang;
	}
}
