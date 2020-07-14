package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Nguoidung;
import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.repository.Sanpham_nguoidungRepository;



@Service
public class Sanpham_nguoidungService {

	@Autowired
	Sanpham_nguoidungRepository<Sanpham_nguoidung> sanpham_nguoidungRepository;
	
	

	@Transactional
	public List<Sanpham_nguoidung> getAllsanpham_nguoidung() {
		return (List<Sanpham_nguoidung>) sanpham_nguoidungRepository.findAll();
	}
	
	@Transactional
	public List<Sanpham_nguoidung> getAllsanpham_nguoidungtheonha(Integer idloai, Integer idtrang,Integer idtrangthaigd) {
		return (List<Sanpham_nguoidung>) sanpham_nguoidungRepository.findByIdSanphamnguoidung(idloai,idtrang,idtrangthaigd);
	}
	
	public List<Sanpham_nguoidung> findBytrangthaigd_idTrangthaigd(Long idTrangthaigd){
		return sanpham_nguoidungRepository.findBytrangthaigd_idTrangthaigd(idTrangthaigd);
	}
	// tìm vs từ khóa null
	@Transactional
	public List<Sanpham_nguoidung> getAllsanpham_nguoidungtukhoanull(Integer idtrang, Integer idloai,Integer idvung, Integer iddonvigia, float nhonhat,float lonnhat,Integer trangthaigd) {
		return (List<Sanpham_nguoidung>) sanpham_nguoidungRepository.timkiemvoitukhoanull(idtrang,idloai,idvung,iddonvigia,nhonhat,lonnhat,trangthaigd);
	}
	
	public List<Sanpham_nguoidung> findByloaisanpham_idLoaisp(Long idLoaisp){
		return sanpham_nguoidungRepository.findByloaisanpham_idLoaisp(idLoaisp);
	}
	
	public List<Sanpham_nguoidung> findByvungxa_idVungxa(Long idVungxa){
		return sanpham_nguoidungRepository.findByvungxa_idVungxa(idVungxa);
	}
	
	public List<Sanpham_nguoidung> findBynguoidung_idNguoidung(Long idNguoidung){
		return sanpham_nguoidungRepository.findBynguoidung_idNguoidung(idNguoidung);
	}
	
	public List<Sanpham_nguoidung> findBytrangthai_idTrangthai(Long idTrangthai){
		return sanpham_nguoidungRepository.findBytrangthai_idTrangthai(idTrangthai);
	}
	
	public List<Sanpham_nguoidung> findByidnguoidungtindang(Integer trangthaigd,Integer trangthai,Integer nguoidung){
		return sanpham_nguoidungRepository.findByidnguoidungtindang(trangthaigd,trangthai,nguoidung);
	}
	
	@Transactional
	public Optional<Sanpham_nguoidung> getById(Long id) {
		return sanpham_nguoidungRepository.findById(id);
	}
	
	public ResponseEntity<Sanpham_nguoidung> deletesanpham_nguoidung(Long sanpham_nguoidungId) {
        Optional<Sanpham_nguoidung> sanpham_nguoidungEntity = sanpham_nguoidungRepository.findById(sanpham_nguoidungId);
        if (sanpham_nguoidungEntity.isPresent()) {
        	Sanpham_nguoidung sanpham_cty = sanpham_nguoidungEntity.get();
        	sanpham_nguoidungRepository.delete(sanpham_cty);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
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
			,Integer h3,Integer h4,Integer h5,float h6,Integer h7,Integer h8,String h10,Integer h11,float h12,float h13,float h14,float h15,Integer h16,Integer h17,Integer h9
			,Integer ttgd) {
		sanpham_nguoidungRepository.addSPCTY(a
				, b
				, c
				, d
				, e
				, f
				, g
				, h, h1, h2, h3, h4, h5, h6, h7, h8,h10, h11,h12,h13,h14,h15,h16,h17,h9,ttgd);
	}
	
	public void upspnd(float a, float b
			,Integer c
			,Integer d
			,Integer e
			,Integer f
			,String g //ngaynhap
			,float h
			,float h1
			,Integer h2
			,Integer h3,Integer h4,Integer h5,float h6,Integer h7,Integer h8,String h10,Integer h11,float h12,float h13,float h14,float h15,Integer h16,Integer h17,Integer h9
			,Integer ttgd,Integer idspnd) {
		sanpham_nguoidungRepository.updateSPnd(a
				, b
				, c
				, d
				, e
				, f
				, g
				, h, h1, h2, h3, h4, h5, h6, h7, h8,h10, h11,h12,h13,h14,h15,h16,h17,h9,ttgd,idspnd);
		System.out.println(idspnd);
	}
	
//	public Sanpham_nguoidung updateSanpham_nguoidung(Long idSPNguoidung, Sanpham_nguoidung spnguoidungEntity) {
//		Sanpham_nguoidung updatedSanpham_nguoidung;
//		Optional<Sanpham_nguoidung> searchEntity = sanpham_nguoidungRepository.findById(idSPNguoidung);
//		if (searchEntity.isPresent()) {
//			Sanpham_nguoidung spnguoidung = searchEntity.get();
//			spnguoidung.setLoaisanpham(spnguoidungEntity.getLoaisanpham());
//			spnguoidung.setVungxa(spnguoidungEntity.getVungxa());
//			spnguoidung.setHuong(spnguoidungEntity.getHuong());
//			spnguoidung.setDonvigia(spnguoidungEntity.getDonvigia());
//			spnguoidung.setNameSanphamnguoidung(spnguoidungEntity.getNameSanphamnguoidung());
//			spnguoidung.setNgaynhapSanphamnguoidung(spnguoidungEntity.getNgaynhapSanphamnguoidung());
//			spnguoidung.setDientichSanphamnguoidung(spnguoidungEntity.getDientichSanphamnguoidung());
//			spnguoidung.setGiaSanphamnguoidung(spnguoidungEntity.getGiaSanphamnguoidung());
//			spnguoidung.setMotaSanphamnguoidung(spnguoidungEntity.getMotaSanphamnguoidung());
//			spnguoidung.setSotangSanphamnguoidung(spnguoidungEntity.getSotangSanphamnguoidung());
//			spnguoidung.setHemSanphamnguoidung(spnguoidungEntity.getHemSanphamnguoidung());
//			spnguoidung.setHemSanphamnguoidung(spnguoidungEntity.getPhaplySanphamnguoidung());
//			spnguoidung.setThocuSanphamnguoidung(spnguoidungEntity.getThocuSanphamnguoidung());
//			spnguoidung.setSophongnguSanphamnguoidung(spnguoidungEntity.getSophongnguSanphamnguoidung());
//			spnguoidung.setSotoiletSanphamnguoidung(spnguoidungEntity.getSotoiletSanphamnguoidung());
//			spnguoidung.setLonSanpham_nguoidung(spnguoidungEntity.getLonSanpham_nguoidung());
//			spnguoidung.setLatSanpham_nguoidung(spnguoidungEntity.getLatSanpham_nguoidung());
//			spnguoidung.setChieurongSanpham_nguoidung(spnguoidungEntity.getChieurongSanpham_nguoidung());
//			spnguoidung.setChieudaiSanpham_nguoidung(spnguoidungEntity.getChieudaiSanpham_nguoidung());
//			spnguoidung.setDuong(spnguoidungEntity.getDuong());
//			spnguoidung.setHinhanh(spnguoidungEntity.getHinhanh());
//			spnguoidung.setGeomSanphamnguoidung(spnguoidungEntity.getGeomSanphamnguoidung());
//			spnguoidung.setNguoidung(spnguoidungEntity.getNguoidung());
//			spnguoidung.setTrangthai(spnguoidungEntity.getTrangthai());
//			updatedSanpham_nguoidung = sanpham_nguoidungRepository.save(spnguoidung);
//		} else {
//			throw new EntityNotFoundException();
//		}
//		return updatedSanpham_nguoidung;
//	}

}
