package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Loaisanpham;
import com.example.demo.entity.Phanquyenadmin;
import com.example.demo.repository.PhanquyenadminRepository;





@Service
public class PhanquyenadminService {

	@Autowired
	PhanquyenadminRepository<Phanquyenadmin> PhanquyenadminRepository;
	
	@Transactional
	public List<Phanquyenadmin> getAllPhanquyenadmin() {
		return (List<Phanquyenadmin>) PhanquyenadminRepository.findAll();
	}
	
	@Transactional
	public Optional<Phanquyenadmin> getById(Long id) {
		return PhanquyenadminRepository.findById(id);
	}
	
	@Transactional
	public Phanquyenadmin createPhanquyenadmin(Phanquyenadmin Phanquyenadmin) {
        return PhanquyenadminRepository.save(Phanquyenadmin);
    }
	
	public Phanquyenadmin updatePhanquyenadmin(Long idhinh, Phanquyenadmin PhanquyenadminEntity) {
		Phanquyenadmin updatedPhanquyenadmin;
		Optional<Phanquyenadmin> searchEntity = PhanquyenadminRepository.findById(idhinh);
		if (searchEntity.isPresent()) {
			Phanquyenadmin Phanquyenadmin = searchEntity.get();
			Phanquyenadmin.setNameRole(PhanquyenadminEntity.getNameRole());
			updatedPhanquyenadmin = PhanquyenadminRepository.save(Phanquyenadmin);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedPhanquyenadmin;
	}
}
