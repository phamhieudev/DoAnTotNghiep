package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Batdongsanyeuthichnguoidung;
import com.example.demo.entity.batdongsanyeuthichcty;
import com.example.demo.service.BatdongsanyeuthichnguoidungService;



@CrossOrigin
@Controller
public class BatdongsanyeuthichnguoidungController {

	@Autowired
	BatdongsanyeuthichnguoidungService batdongsanyeuthichnguoidungService;
	
	@RequestMapping(value = "/batdongsanyeuthichnguoidungs", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Batdongsanyeuthichnguoidung>> findAllbatdongsanyeuthichnguoidung() {
        List<Batdongsanyeuthichnguoidung> batdongsanyeuthichnguoidung = batdongsanyeuthichnguoidungService.getAllbatdongsanyeuthichnguoidung();
        if (batdongsanyeuthichnguoidung.isEmpty()) {
            return new ResponseEntity<List<Batdongsanyeuthichnguoidung>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Batdongsanyeuthichnguoidung>>(batdongsanyeuthichnguoidung, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/addspyeuthichnguoidung/{idnguoidung}/{idsp}"
			, method = RequestMethod.POST)
	@ResponseBody
    public void addsanphamyeuthich(@PathVariable(value = "idnguoidung") Integer idnguoidung
    		, @PathVariable(value = "idsp") Integer idsp){ 
		batdongsanyeuthichnguoidungService.addspcty(idnguoidung, idsp);
	}
	
	@RequestMapping(value = "/xoasanphamyeuthichnguoidung/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Batdongsanyeuthichnguoidung> deletesanphamyeuthich_nguoidung(@PathVariable(value = "id") Long id) {
        return batdongsanyeuthichnguoidungService.deletebatdongsanyeuthichnguoidung(id);
    }
	
	 @RequestMapping(value = "/findyeuthichnguoidungnd/{idNguoidung}", method = RequestMethod.GET)
		public @ResponseBody List<Batdongsanyeuthichnguoidung> getsachbyIdnd(@PathVariable(value="idNguoidung") Long idvidNguoidungung) {
			return batdongsanyeuthichnguoidungService.findBynguoidung_idNguoidung(idvidNguoidungung);
		}
}
