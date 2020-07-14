package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Huong;
import com.example.demo.service.HuongService;


@Controller
@CrossOrigin
public class HuongController {
	
	@Autowired
	HuongService huongService;
	
	@RequestMapping(value = "/huongs", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Huong>> findAllHuong() {
        List<Huong> huong = huongService.getAllhuong();
        if (huong.isEmpty()) {
            return new ResponseEntity<List<Huong>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Huong>>(huong, HttpStatus.OK);
    }

}
