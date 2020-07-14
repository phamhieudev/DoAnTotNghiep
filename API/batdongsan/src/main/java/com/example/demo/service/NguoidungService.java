package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Loaisanpham;
import com.example.demo.entity.Nguoidung;
import com.example.demo.repository.NguoidungRepository;



@Service
public class NguoidungService {
	
	@Autowired
	NguoidungRepository<Nguoidung> nguoidungRepository;
	
	
	@Transactional
	public List<Nguoidung> getAllnguoidung() {
		return (List<Nguoidung>) nguoidungRepository.findAll();
	}
	
	@Transactional
	public Optional<Nguoidung> getById(Long id) {
		return nguoidungRepository.findById(id);
	}
		
	
	
	   public ResponseEntity<Object> deletenguoidung(Long nguoidungId) {
	        Optional<Nguoidung> nguoidungEntity = nguoidungRepository.findById(nguoidungId);
	        if (nguoidungEntity.isPresent()) {
	        	Nguoidung nguoidung = nguoidungEntity.get();
	        	nguoidungRepository.delete(nguoidung);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   @Transactional
		public boolean addNguoidung(Nguoidung nguoidung) {
			return nguoidungRepository.save(nguoidung) != null;
		}

	public Nguoidung updateNguoidung(Long idNguoidung, Nguoidung nguoidungEntity) {
		Nguoidung updatedNguoidung;
		Optional<Nguoidung> searchEntity = nguoidungRepository.findById(idNguoidung);
		if (searchEntity.isPresent()) {
			Nguoidung nguoidung = searchEntity.get();
			nguoidung.setTenNguoidung(nguoidungEntity.getTenNguoidung());
			nguoidung.setMail(nguoidungEntity.getMail());
			nguoidung.setPhone(nguoidungEntity.getPhone());
			nguoidung.setPassword(nguoidungEntity.getPassword());
			updatedNguoidung = nguoidungRepository.save(nguoidung);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedNguoidung;
	}

}
