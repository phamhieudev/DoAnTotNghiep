package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Nguoidung;
import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.repository.Sanpham_nguoidungRepository;
import com.example.demo.service.Sanpham_nguoidungService;



@CrossOrigin
@Controller
public class Sanpham_nguoidungController {


	@Autowired
	Sanpham_nguoidungService sanpham_nguoidungService;
	Sanpham_nguoidungRepository<Sanpham_nguoidung> sanphamreository;
	
	@RequestMapping(value = "/sanphamnguoidungs", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Sanpham_nguoidung>> findAllsanpham_nguoidung() {
        List<Sanpham_nguoidung> sanpham_nguoidung = sanpham_nguoidungService.getAllsanpham_nguoidung();
        if (sanpham_nguoidung.isEmpty()) {
            return new ResponseEntity<List<Sanpham_nguoidung>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Sanpham_nguoidung>>(sanpham_nguoidung, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/sanphamnguoidungtheonha/{loai}/{trang}/{trangthaigd}", method = RequestMethod.GET)
	public @ResponseBody List<Sanpham_nguoidung> getAllsanpham_nguoidungtheonha(@PathVariable(value="loai") Integer idloai,@PathVariable(value="trang") Integer idtrang
			,@PathVariable(value="trangthaigd") Integer trangthaigd) {
		return sanpham_nguoidungService.getAllsanpham_nguoidungtheonha(idloai, idtrang,trangthaigd);
	}
	
	@RequestMapping(value = "/sanphamnguoidungtheoidnguoidung/{trangthaigd}/{trangthai}//{nguoidung}", method = RequestMethod.GET)
	public @ResponseBody List<Sanpham_nguoidung> getAllsanpham_nguoidungtheoidnguoidung(@PathVariable(value="trangthaigd") Integer trangthaigd
			,@PathVariable(value="trangthai") Integer trangthai
			,@PathVariable(value="nguoidung") Integer nguoidung) {
		return sanpham_nguoidungService.findByidnguoidungtindang(trangthaigd,trangthai,nguoidung);
	}
	
	@RequestMapping(value = "/findbyidtrangthaigdnd/{idtrangthai}", method = RequestMethod.GET)
	public @ResponseBody List<Sanpham_nguoidung> findBytrangthaigd_idTrangthaigd(@PathVariable(value="idtrangthai") Long idtrangthai) {
		return sanpham_nguoidungService.findBytrangthaigd_idTrangthaigd(idtrangthai);
	}
	
//tim vs tu khoa null
	@RequestMapping(value = "/sanphamnguoidungtukhoanull/{trang}/{loai}/{vung}/{donvigia}/{nhonhat}/{lonnhat}/{trangthaigd}", method = RequestMethod.GET)
	public @ResponseBody List<Sanpham_nguoidung> getAllsanpham_nguoidungtukhoanull(@PathVariable(value="trang") Integer idtrang,
			@PathVariable(value="loai") Integer idloai,
			@PathVariable(value="vung") Integer idvung,
			@PathVariable(value="donvigia") Integer iddonvigia,
			@PathVariable(value="nhonhat") float nhonhat,
			@PathVariable(value="lonnhat") float lonnhat,
			@PathVariable(value="trangthaigd") Integer trangthaigd
		) {
		return sanpham_nguoidungService.getAllsanpham_nguoidungtukhoanull(idtrang, idloai, idvung, iddonvigia,nhonhat,lonnhat,trangthaigd);
	}
	
	
	@RequestMapping(value = "/sanphamnguoidung/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Sanpham_nguoidung> getAllsanpham_nguoidung(@PathVariable Long id) {
		return sanpham_nguoidungService.getById(id);
	}
	
	@RequestMapping(value = "/findbyidloaind/{idloai}", method = RequestMethod.GET)
	public @ResponseBody List<Sanpham_nguoidung> getsachbyIdloai(@PathVariable(value="idloai") Long idloai) {
		return sanpham_nguoidungService.findByloaisanpham_idLoaisp(idloai);
	}
	
	@RequestMapping(value = "/findbyivungnd/{idvung}", method = RequestMethod.GET)
	public @ResponseBody List<Sanpham_nguoidung> getsachbyIdvung(@PathVariable(value="idvung") Long idvung) {
		return sanpham_nguoidungService.findByvungxa_idVungxa(idvung);
	}
	
	@RequestMapping(value = "/findbyidnguoidung/{idnguoidung}", method = RequestMethod.GET)
	public @ResponseBody List<Sanpham_nguoidung> getsachbyIdnguoidung(@PathVariable(value="idnguoidung") Long idnguoidung) {
		return sanpham_nguoidungService.findBynguoidung_idNguoidung(idnguoidung);
	}
	
	@RequestMapping(value = "/findbyidtrangthai/{idtrangthai}", method = RequestMethod.GET)
	public @ResponseBody List<Sanpham_nguoidung> findBytrangthai_idTrangthai(@PathVariable(value="idtrangthai") Long idtrangthai) {
		return sanpham_nguoidungService.findBytrangthai_idTrangthai(idtrangthai);
	}
	
	@RequestMapping(value = "/xoasanphamnguoidung/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Sanpham_nguoidung> deleteSanpham_nguoidung(@PathVariable(value = "id") Long id) {
        return sanpham_nguoidungService.deletesanpham_nguoidung(id);
    }
	
	@RequestMapping(value = "/addsanpham/{x}/{y}/{idloai_sanpham}/{id_vungxa}/{id_huong}/{id_donvigia}/{ngaynhap}/{dientich}/{gia}/{mota}/{sotang}/{hem}/{phaply}/{thocu}/{sophongngu}/{sotoilet}/{tensanpham}/{duong}/{x1}/{y1}/{chieurong}/{chieudai}/{nguoidung}/{trangthai}/{hinhanh}/{trangthaigd}"
			, method = RequestMethod.POST)
	@ResponseBody
    public void addsanphamc(
    		 @PathVariable(value = "x") float x
    		, @PathVariable(value = "y") float y
    		, @PathVariable(value = "idloai_sanpham") Integer idloai_sanpham
    		, @PathVariable(value = "id_vungxa") Integer id_vungxa
    		, @PathVariable(value = "id_huong") Integer id_huong
    		, @PathVariable(value = "id_donvigia") Integer id_donvigia
    		, @PathVariable(value = "ngaynhap") String ngaynhap
    		, @PathVariable(value = "dientich") float dientich
    		, @PathVariable(value = "gia") float gia
    		, @PathVariable(value = "mota") Integer mota
    		, @PathVariable(value = "sotang") Integer sotang
    		, @PathVariable(value = "hem") Integer hem
    		, @PathVariable(value = "phaply") Integer phaply
    		, @PathVariable(value = "thocu") float thocu
    		, @PathVariable(value = "sophongngu") Integer sophongngu
    		, @PathVariable(value = "sotoilet") Integer sotoilet
    		, @PathVariable(value = "tensanpham") String tensanpham
    		, @PathVariable(value = "duong") Integer duong
    		,@PathVariable(value = "x1") float x1
    		, @PathVariable(value = "y1") float y1
    		, @PathVariable(value = "chieurong") float chieurong
    		, @PathVariable(value = "chieudai") float chieudai
    		, @PathVariable(value = "nguoidung") Integer nguoidung
    		, @PathVariable(value = "trangthai") Integer trangthai
    		, @PathVariable(value = "hinhanh") Integer hinhanh
    		, @PathVariable(value = "trangthaigd") Integer trangthaigd){ 
		sanpham_nguoidungService.addspcty(x, y, idloai_sanpham, id_vungxa, id_huong, id_donvigia, ngaynhap, dientich, gia, mota, sotang, hem, phaply, thocu, sophongngu, sotoilet, tensanpham, duong,x1,y1,chieurong,chieudai,nguoidung,trangthai,hinhanh,trangthaigd);
	}
	
	@RequestMapping(value = "/upsanphamnd/{x}/{y}/{idloai_sanpham}/{id_vungxa}/{id_huong}/{id_donvigia}/{ngaynhap}/{dientich}/{gia}/{mota}/{sotang}/{hem}/{phaply}/{thocu}/{sophongngu}/{sotoilet}/{tensanpham}/{duong}/{x1}/{y1}/{chieurong}/{chieudai}/{nguoidung}/{trangthai}/{hinhanh}/{trangthaigd}/{id}"
			, method = RequestMethod.POST)
	@ResponseBody
    public void upsanphamnd(
    		 @PathVariable(value = "x") float x
     		, @PathVariable(value = "y") float y
     		, @PathVariable(value = "idloai_sanpham") Integer idloai_sanpham
     		, @PathVariable(value = "id_vungxa") Integer id_vungxa
     		, @PathVariable(value = "id_huong") Integer id_huong
     		, @PathVariable(value = "id_donvigia") Integer id_donvigia
     		, @PathVariable(value = "ngaynhap") String ngaynhap
     		, @PathVariable(value = "dientich") float dientich
     		, @PathVariable(value = "gia") float gia
     		, @PathVariable(value = "mota") Integer mota
     		, @PathVariable(value = "sotang") Integer sotang
     		, @PathVariable(value = "hem") Integer hem
     		, @PathVariable(value = "phaply") Integer phaply
     		, @PathVariable(value = "thocu") float thocu
     		, @PathVariable(value = "sophongngu") Integer sophongngu
     		, @PathVariable(value = "sotoilet") Integer sotoilet
     		, @PathVariable(value = "tensanpham") String tensanpham
     		, @PathVariable(value = "duong") Integer duong
     		,@PathVariable(value = "x1") float x1
     		, @PathVariable(value = "y1") float y1
     		, @PathVariable(value = "chieurong") float chieurong
     		, @PathVariable(value = "chieudai") float chieudai
     		, @PathVariable(value = "nguoidung") Integer nguoidung
     		, @PathVariable(value = "trangthai") Integer trangthai
     		, @PathVariable(value = "hinhanh") Integer hinhanh
     		, @PathVariable(value = "trangthaigd") Integer trangthaigd
    		, @PathVariable(value = "id") Integer sanphamid){ 
		sanpham_nguoidungService.upspnd(x, y, idloai_sanpham, id_vungxa, id_huong, id_donvigia, ngaynhap, dientich, gia, mota, sotang, hem, phaply, thocu, sophongngu, sotoilet, tensanpham, duong,x1,y1,chieurong,chieudai,nguoidung,trangthai,hinhanh,trangthaigd,sanphamid);
		System.out.println(sanphamid);
		System.out.println(x1);
	}
	
	
}
