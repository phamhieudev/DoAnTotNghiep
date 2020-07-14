package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entity.hinhanh;
import com.example.demo.service.HinhanhService;




@CrossOrigin
@Controller
public class HinhanhController {
	
	@Autowired
	HinhanhService hinhanhService;

	@RequestMapping(value = "/hinhanhs", method = RequestMethod.GET)
	
	 public ResponseEntity<List<hinhanh>> findAllhinhanh() {
       List<hinhanh> hinhanh = hinhanhService.getAllhinhanh();
       if (hinhanh.isEmpty()) {
           return new ResponseEntity<List<hinhanh>>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<List<hinhanh>>(hinhanh, HttpStatus.OK);
   }
	
	 @RequestMapping(value = "/createHinh", method = RequestMethod.POST)
	    public hinhanh createHinh(@Valid @RequestBody hinhanh hinhanh) {
	        return  hinhanhService.createhinhanh(hinhanh);
	    }
	 @RequestMapping(value = "/updatehinhanh/{idhinh}", method = RequestMethod.PUT)
	    public hinhanh updateBook(@PathVariable(value = "idhinh") Long idhinh, @Valid @RequestBody hinhanh hinhanh) {
	        return hinhanhService.updatehinhanh(idhinh, hinhanh);
	    }
	 
}
