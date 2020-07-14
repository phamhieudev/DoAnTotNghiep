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

import com.example.demo.entity.Hinhanhchitietspcty;
import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.entity.hinhanh;
import com.example.demo.service.HinhanhchitietspctyService;

@CrossOrigin
@Controller
public class HinhanhchitietspctyController {


	@Autowired
	HinhanhchitietspctyService HinhanhchitietspctyService;
	
	@RequestMapping(value = "/Hinhanhchitietspctys", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Hinhanhchitietspcty>> findAllHinhanhchitietspcty() {
        List<Hinhanhchitietspcty> Hinhanhchitietspcty = HinhanhchitietspctyService.getAllHinhanhchitietspcty();
        if (Hinhanhchitietspcty.isEmpty()) {
            return new ResponseEntity<List<Hinhanhchitietspcty>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Hinhanhchitietspcty>>(Hinhanhchitietspcty, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/Hinhanhchitietspcty/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Hinhanhchitietspcty> getAllHinhanhchitietspcty(@PathVariable Long id) {
			return HinhanhchitietspctyService.getById(id);
	 }
	 	
	 @RequestMapping(value = "/findhinhbyidspcty/{idsp}", method = RequestMethod.GET)
		public @ResponseBody List<Hinhanhchitietspcty> getsachbyIdloai(@PathVariable(value="idsp") Long idsp) {
			return HinhanhchitietspctyService.getAllhinhanhtheosp(idsp);
		}

	 
	 @RequestMapping(value = "/xoaHinhanhchitietspcty/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deleteHinhanhchitietspcty(@PathVariable(value = "id") Long id) {
	        return HinhanhchitietspctyService.deleteHinhanhchitietspcty(id);
	    }


//	 @RequestMapping(value = "/addHinhanhchitietspcty", method = RequestMethod.POST)
//		public HttpStatus insertHinhanhchitietspcty(@RequestBody Hinhanhchitietspcty Hinhanhchitietspcty) {
//			return HinhanhchitietspctyService.addHinhanhchitietspcty(Hinhanhchitietspcty) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
//		}
	 
	 @RequestMapping(value = "/addHinhanhchitietspcty", method = RequestMethod.POST)
	    public Hinhanhchitietspcty createhinhanh(@Valid @RequestBody Hinhanhchitietspcty Hinhanhchitietspcty) {
	        return  HinhanhchitietspctyService.createhinhanh(Hinhanhchitietspcty);
	    }
}
