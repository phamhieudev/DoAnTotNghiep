package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Donvigia;
import com.example.demo.service.DonvigiaService;


@Controller
@CrossOrigin
public class DonvigiaController {

	@Autowired
	DonvigiaService donvigiaService;
	
	@RequestMapping(value = "/donvigias", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Donvigia>> findAllDonvigia() {
        List<Donvigia> donvigia = donvigiaService.getAlldonvigia();
        if (donvigia.isEmpty()) {
            return new ResponseEntity<List<Donvigia>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Donvigia>>(donvigia, HttpStatus.OK);
    }
}
