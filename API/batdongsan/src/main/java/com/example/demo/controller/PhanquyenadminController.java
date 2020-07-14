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

import com.example.demo.entity.Phanquyenadmin;
import com.example.demo.service.PhanquyenadminService;




@CrossOrigin
@Controller
public class PhanquyenadminController {
	
	@Autowired
	PhanquyenadminService PhanquyenadminService;

	@RequestMapping(value = "/Phanquyenadmins", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Phanquyenadmin>> findAllPhanquyenadmin() {
       List<Phanquyenadmin> Phanquyenadmin = PhanquyenadminService.getAllPhanquyenadmin();
       if (Phanquyenadmin.isEmpty()) {
           return new ResponseEntity<List<Phanquyenadmin>>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<List<Phanquyenadmin>>(Phanquyenadmin, HttpStatus.OK);
   }
	

	 
}
