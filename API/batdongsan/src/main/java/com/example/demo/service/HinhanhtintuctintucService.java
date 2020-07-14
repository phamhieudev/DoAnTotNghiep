package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Loaisanpham;
import com.example.demo.entity.hinhanhtintuc;
import com.example.demo.repository.HinhanhtintucRepository;

@Service
public class HinhanhtintuctintucService {

	@Autowired
	HinhanhtintucRepository<hinhanhtintuc> HinhanhtintucRepository;
	
	@Transactional
	public List<hinhanhtintuc> getAllHinhanhtintuc() {
		return (List<hinhanhtintuc>) HinhanhtintucRepository.findAll();
	}
	
	@Transactional
	public Optional<hinhanhtintuc> getById(Long id) {
		return HinhanhtintucRepository.findById(id);
	}
	
	@Transactional
	public hinhanhtintuc createHinhanhtintuc(hinhanhtintuc Hinhanhtintuc) {
        return HinhanhtintucRepository.save(Hinhanhtintuc);
    }
	
	public hinhanhtintuc updateHinhanhtintuc(Long idhinh, hinhanhtintuc HinhanhtintucEntity) {
		hinhanhtintuc updatedHinhanhtintuc;
		Optional<hinhanhtintuc> searchEntity = HinhanhtintucRepository.findById(idhinh);
		if (searchEntity.isPresent()) {
			hinhanhtintuc Hinhanhtintuc = searchEntity.get();
			Hinhanhtintuc.setUrl(HinhanhtintucEntity.getUrl());
			updatedHinhanhtintuc = HinhanhtintucRepository.save(Hinhanhtintuc);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedHinhanhtintuc;
	}
}
