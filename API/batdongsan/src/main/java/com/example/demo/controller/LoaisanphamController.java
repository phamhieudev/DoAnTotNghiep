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


import com.example.demo.entity.Loaisanpham;
import com.example.demo.service.LoaisanphamService;

@CrossOrigin
@Controller
public class LoaisanphamController {
	

	@Autowired
	LoaisanphamService loaisanphamService;
	
	@RequestMapping(value = "/loaisanphams", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Loaisanpham>> findAllLoaisanpham() {
        List<Loaisanpham> loaisanpham = loaisanphamService.getAllloaisanpham();
        if (loaisanpham.isEmpty()) {
            return new ResponseEntity<List<Loaisanpham>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Loaisanpham>>(loaisanpham, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/loaisanpham/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Loaisanpham> getAllloaisanpham(@PathVariable Long id) {
			return loaisanphamService.getById(id);
		}
	 	
	

	 @RequestMapping(value = "/xoaloaisanpham/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deleteLoaisanpham(@PathVariable(value = "id") Long id) {
	        return loaisanphamService.deleteLoaisanpham(id);
	    }

	
//	  @RequestMapping(value = "/addloaisanpham", method = RequestMethod.POST)
//	    public Loaisanpham insertLoaisanpham(@Valid @RequestBody Loaisanpham loaisanpham) {
//	        return loaisanphamService.addLoaisanpham(loaisanpham);
//	    }
	 @RequestMapping(value = "/addloaisanpham", method = RequestMethod.POST)
		public HttpStatus insertLoaisanpham(@RequestBody Loaisanpham loaisanpham) {
			return loaisanphamService.addLoaisanpham(loaisanpham) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
		}
	 

	@RequestMapping(value = "/updateloaisanpham/{id_Loai}", method = RequestMethod.PUT)
    public Loaisanpham updateLoaisanpham(@PathVariable(value = "id_Loai") Long id_Loai, @Valid @RequestBody Loaisanpham loaisanpham){ 
        return loaisanphamService.updateLoaisanpham(id_Loai, loaisanpham);
	}
	

}
