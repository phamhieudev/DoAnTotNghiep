package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Trangthai;
import com.example.demo.service.TrangthaiService;



@Controller
@CrossOrigin
public class TrangthaiController {

	@Autowired
	TrangthaiService trangthaiService;
	
	@RequestMapping(value = "/trangthais", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Trangthai>> findAllTrangthai() {
        List<Trangthai> trangthai = trangthaiService.getAlltrangthai();
        if (trangthai.isEmpty()) {
            return new ResponseEntity<List<Trangthai>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Trangthai>>(trangthai, HttpStatus.OK);
    }
}
