package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.repository.Sanpham_ctyRepository;
import com.example.demo.service.Sanpham_ctyService;


@CrossOrigin
@Controller
public class SanphamCty_Controller {
	
	@Autowired
	Sanpham_ctyService sanpham_ctyService;
	Sanpham_ctyRepository<Sanpham_cty> sanphamreository;
	
	@RequestMapping(value = "/sanphamctys", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Sanpham_cty>> findAllsanpham_cty() {
        List<Sanpham_cty> sanpham_cty = sanpham_ctyService.getAllsanpham_cty();
        if (sanpham_cty.isEmpty()) {
            return new ResponseEntity<List<Sanpham_cty>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Sanpham_cty>>(sanpham_cty, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/sanphamcty/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Sanpham_cty> getAllsanpham_cty(@PathVariable Long id) {
			return sanpham_ctyService.getById(id);
		}
	 	
		@RequestMapping(value = "/findbyidloai/{idloai}", method = RequestMethod.GET)
		public @ResponseBody List<Sanpham_cty> getsachbyIdloai(@PathVariable(value="idloai") Long idloai) {
			return sanpham_ctyService.findByloaisanpham_idLoaisp(idloai);
		}
		
		@RequestMapping(value = "/sanphamctytheoloaitrangthaigd/{idloai}/{trangthaigd}", method = RequestMethod.GET)
		public @ResponseBody List<Sanpham_cty> findByIdSanphamctyidtrangthai(@PathVariable(value="trangthaigd") Integer trangthaigd
				,@PathVariable(value="idloai") Integer idloai) {
			return sanpham_ctyService.findByIdSanphamctyidtrangthai(idloai,trangthaigd);
		}
		
		@RequestMapping(value = "/findbyidtrangthaigd/{idtrangthai}", method = RequestMethod.GET)
		public @ResponseBody List<Sanpham_cty> findBytrangthaigd_idTrangthaigd(@PathVariable(value="idtrangthai") Long idtrangthai) {
			return sanpham_ctyService.findBytrangthaigd_idTrangthaigd(idtrangthai);
		}
		
		@RequestMapping(value = "/findbyivung/{idvung}", method = RequestMethod.GET)
		public @ResponseBody List<Sanpham_cty> getsachbyIdvung(@PathVariable(value="idvung") Long idvung) {
			return sanpham_ctyService.findByvungxa_idVungxa(idvung);
		}

	 @RequestMapping(value = "/xoasanphamcty/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Sanpham_cty> deletesanpham_cty(@PathVariable(value = "id") Long id) {
	        return sanpham_ctyService.deletesanpham_cty(id);
	    }

	  //tim vs tu khoa null
		@RequestMapping(value = "/searchspcty/{loai}/{vung}/{donvigia}/{nhonhat}/{lonnhat}/{ten}", method = RequestMethod.GET)
		public @ResponseBody List<Sanpham_cty> getAllsanpham_ctytukhoanull(
				@PathVariable(value="loai") Integer idloai,
				@PathVariable(value="vung") Integer idvung,
				@PathVariable(value="donvigia") Integer iddonvigia,
				@PathVariable(value="nhonhat") float nhonhat,
				@PathVariable(value="lonnhat") float lonnhat,
				@PathVariable(value="ten") String ten
			) {
			return sanpham_ctyService.getAllsanpham_ctytukhoanull(idloai, idvung, iddonvigia,nhonhat,lonnhat,ten);
		}


//	@RequestMapping(value = "/updatesanphamcty/{id_sanphamcty}", method = RequestMethod.PUT)
//    public Sanpham_cty updatetintuc(@PathVariable(value = "id_sanphamcty") Long id_sanphamcty, @Valid @RequestBody Sanpham_cty sanphamcty){ 
//        return sanpham_ctyService.updateSanpham_cty(id_sanphamcty, sanphamcty);
//	}
//	
	@RequestMapping(value = "/addsanphamcty/{x}/{y}/{idloai_sanpham}/{id_vungxa}/{id_huong}/{id_donvigia}/{ngaynhap}/{dientich}/{gia}/{mota}/{sotang}/{hem}/{phaply}/{thocu}/{sophongngu}/{sotoilet}/{tensanpham}/{duong}/{x1}/{y1}/{chieurong}/{chieudai}/{hinhanh}/{trangthaigd}"
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
    		, @PathVariable(value = "hinhanh") Integer hinhanh
    		, @PathVariable(value = "trangthaigd") Integer trangthaigd){ 
		sanpham_ctyService.addspcty(x, y, idloai_sanpham, id_vungxa, id_huong, id_donvigia, ngaynhap, dientich, gia, mota, sotang, hem, phaply, thocu, sophongngu, sotoilet, tensanpham, duong,x1,y1,chieurong,chieudai,hinhanh,trangthaigd);
	}
	
	@RequestMapping(value = "/updatesanphamcty/{x}/{y}/{idloai_sanpham}/{id_vungxa}/{id_huong}/{id_donvigia}/{ngaynhap}/{dientich}/{gia}/{mota}/{sotang}/{hem}/{phaply}/{thocu}/{sophongngu}/{sotoilet}/{tensanpham}/{duong}/{x1}/{y1}/{chieurong}/{chieudai}/{hinhanh}/{trangthaigd}/{id}"
			, method = RequestMethod.PUT)
	@ResponseBody
    public void updatesanphamc(
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
     		, @PathVariable(value = "hinhanh") Integer hinhanh
     		, @PathVariable(value = "trangthaigd") Integer trangthaigd
    		,@PathVariable(value = "id") Integer sanphamid){ 
		sanpham_ctyService.updatespcty(x, y, idloai_sanpham, id_vungxa, id_huong, id_donvigia, ngaynhap, dientich, gia, mota, sotang, hem, phaply, thocu, sophongngu, sotoilet, tensanpham, duong,x1,y1,chieurong,chieudai, hinhanh,trangthaigd,sanphamid);
	}

}
