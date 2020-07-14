package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;



@Service
public class AdminService {

	@Autowired
	AdminRepository<Admin> adminRepository;
	
	
	@Transactional
	public List<Admin> getAlladmin() {
		return (List<Admin>) adminRepository.findAll();
	}
	
	@Transactional
	public Optional<Admin> getById(Long id) {
		return adminRepository.findById(id);
	}
		
	
	
	   public ResponseEntity<Admin> deleteadmin(Long adminId) {
	        Optional<Admin> adminEntity = adminRepository.findById(adminId);
	        if (adminEntity.isPresent()) {
	        	Admin admin = adminEntity.get();
	        	adminRepository.delete(admin);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   public Admin addAdmin(Admin admin) {
	        return adminRepository.save(admin);
	    }

	public Admin updateAdmin(Long idAdmin, Admin adminEntity) {
		Admin updatedAdmin;
		Optional<Admin> searchEntity = adminRepository.findById(idAdmin);
		if (searchEntity.isPresent()) {
			Admin admin = searchEntity.get();
			admin.setNameAdmin(adminEntity.getNameAdmin());
			admin.setMailAdmin(adminEntity.getMailAdmin());
			admin.setDienthoaiAdmin(adminEntity.getDienthoaiAdmin());
			admin.setMatkhauAdmin(adminEntity.getMatkhauAdmin());
			admin.setPhanquyenadmin(adminEntity.getPhanquyenadmin());
			updatedAdmin = adminRepository.save(admin);
		} else {
			throw new EntityNotFoundException();
		}
		return updatedAdmin;
	}
}
