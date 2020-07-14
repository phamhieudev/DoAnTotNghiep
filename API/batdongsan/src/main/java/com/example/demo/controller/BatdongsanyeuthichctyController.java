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

import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.batdongsanyeuthichcty;
import com.example.demo.service.BatdongsanyeuthichctyService;


@CrossOrigin
@Controller
public class BatdongsanyeuthichctyController {

	@Autowired
	BatdongsanyeuthichctyService batdongsanyeuthichctyService;
	
	@RequestMapping(value = "/batdongsanyeuthichctys", method = RequestMethod.GET)
	
	 public ResponseEntity<List<batdongsanyeuthichcty>> findAllbatdongsanyeuthichcty() {
        List<batdongsanyeuthichcty> batdongsanyeuthichcty = batdongsanyeuthichctyService.getAllbatdongsanyeuthichcty();
        if (batdongsanyeuthichcty.isEmpty()) {
            return new ResponseEntity<List<batdongsanyeuthichcty>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<batdongsanyeuthichcty>>(batdongsanyeuthichcty, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/addspyeuthichcty/{idnguoidung}/{idsp}"
			, method = RequestMethod.POST)
	@ResponseBody
    public void addsanphamyeuthich(@PathVariable(value = "idnguoidung") Integer idnguoidung
    		, @PathVariable(value = "idsp") Integer idsp){ 
		batdongsanyeuthichctyService.addspcty(idnguoidung, idsp);
	}
	
	@RequestMapping(value = "/xoasanphamyeuthichcty/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<batdongsanyeuthichcty> deletesanphamyeuthich_cty(@PathVariable(value = "id") Long id) {
        return batdongsanyeuthichctyService.deletebatdongsanyeuthichcty(id);
    }
    
    @RequestMapping(value = "/findyeuthichnguoidung/{idNguoidung}", method = RequestMethod.GET)
	public @ResponseBody List<batdongsanyeuthichcty> getsachbyIdnd(@PathVariable(value="idNguoidung") Long idvidNguoidungung) {
		return batdongsanyeuthichctyService.findBynguoidung_idNguoidung(idvidNguoidungung);
	}
}
