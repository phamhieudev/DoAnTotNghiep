package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Loaisanpham;
import com.example.demo.entity.hinhanh;
import com.example.demo.repository.HinhanhRepository;





@Service
public class HinhanhService {

	@Autowired
	HinhanhRepository<hinhanh> hinhanhRepository;
	
	@Transactional
	public List<hinhanh> getAllhinhanh() {
		return (List<hinhanh>) hinhanhRepository.findAll();
	}
	
	@Transactional
	public Optional<hinhanh> getById(Long id) {
		return hinhanhRepository.findById(id);
	}
	
	@Transactional
	public hinhanh createhinhanh(hinhanh hinhanh) {
        return hinhanhRepository.save(hinhanh);
    }
	
	public hinhanh updatehinhanh(Long idhinh, hinhanh hinhanhEntity) {
		hinhanh updatedhinhanh;
		Optional<hinhanh> searchEntity = hinhanhRepository.findById(idhinh);
		if (searchEntity.isPresent()) {
			hinhanh hinhanh = searchEntity.get();
			hinhanh.setUrl(hinhanhEntity.getUrl());
			updatedhinhanh = hinhanhRepository.save(hinhanh);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedhinhanh;
	}
}
