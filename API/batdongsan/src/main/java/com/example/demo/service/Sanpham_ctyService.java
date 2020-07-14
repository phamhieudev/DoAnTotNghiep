package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Nguoidung;
import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.repository.Sanpham_ctyRepository;


@Service
public class Sanpham_ctyService {

	@Autowired
	Sanpham_ctyRepository<Sanpham_cty> sanpham_ctyRepository;
	
	
	@Transactional
	public List<Sanpham_cty> findByIdSanphamctyidtrangthai(Integer idloai,Integer idtrangthaigd) {
		return (List<Sanpham_cty>) sanpham_ctyRepository.findByIdSanphamctyidtrangthai(idloai,idtrangthaigd);
	}
	
	@Transactional
	public List<Sanpham_cty> getAllsanpham_cty() {
		return (List<Sanpham_cty>) sanpham_ctyRepository.findAll();
	}
	
	public List<Sanpham_cty> findByloaisanpham_idLoaisp(Long idLoaisp){
		return sanpham_ctyRepository.findByloaisanpham_idLoaisp(idLoaisp);
	}
	
	public List<Sanpham_cty> findByvungxa_idVungxa(Long idVungxa){
		return sanpham_ctyRepository.findByvungxa_idVungxa(idVungxa);
	}
	public List<Sanpham_cty> findBytrangthaigd_idTrangthaigd(Long idTrangthaigd){
		return sanpham_ctyRepository.findBytrangthaigd_idTrangthaigd(idTrangthaigd);
	}
	
	@Transactional
	public Optional<Sanpham_cty> getById(Long id) {
		return sanpham_ctyRepository.findById(id);
	}

	// tìm vs từ khóa null
		@Transactional
		public List<Sanpham_cty> getAllsanpham_ctytukhoanull(Integer idloai,Integer idvung, Integer iddonvigia, float nhonhat,float lonnhat,String ten) {
			return (List<Sanpham_cty>) sanpham_ctyRepository.timkiemvoitukhoanull(idloai,idvung,iddonvigia,nhonhat,lonnhat,ten);
		}
		
		
	public void addspcty(float a, float b
			,Integer c
			,Integer d
			,Integer e
			,Integer f
			,String g //ngaynhap
			,float h
			,float h1
			,Integer h2
			,Integer h3,Integer h4,Integer h5,float h6,Integer h7,Integer h8,String h10,Integer h11,float h12,float h13,float h14,float h15,Integer h9,Integer h16) {
		sanpham_ctyRepository.addSPCTY(a
				, b
				, c
				, d
				, e
				, f
				, g
				, h, h1, h2, h3, h4, h5, h6, h7, h8,h10, h11,h12,h13,h14,h15,h9,h16);
	}
	public void updatespcty(float a, float b
			,Integer c
			,Integer d
			,Integer e
			,Integer f
			,String g //ngaynhap
			,float h
			,float h1
			,Integer h2
			,Integer h3,Integer h4,Integer h5,float h6,Integer h7,Integer h8,String h10,Integer h11,float h12,float h13,float h14,float h15,Integer h9,Integer h16,Integer h17) {
		sanpham_ctyRepository.updateSPCTY(a
				, b
				, c
				, d
				, e
				, f
				, g
				, h, h1, h2, h3, h4, h5, h6, h7, h8, h10, h11,h12,h13,h14,h15,h9,h16,h17);
	}
	
	
	   public ResponseEntity<Sanpham_cty> deletesanpham_cty(Long sanpham_ctyId) {
	        Optional<Sanpham_cty> sanpham_ctyEntity = sanpham_ctyRepository.findById(sanpham_ctyId);
	        if (sanpham_ctyEntity.isPresent()) {
	        	Sanpham_cty sanpham_cty = sanpham_ctyEntity.get();
	        	sanpham_ctyRepository.delete(sanpham_cty);
	        } else {
	            throw new EntityNotFoundException();
	        }
	        return ResponseEntity.ok().build();
	    }

	   public Sanpham_cty addsanpham_cty(Sanpham_cty sanpham_cty) {
	        return sanpham_ctyRepository.save(sanpham_cty);
	    }
	   
	   

	
}
