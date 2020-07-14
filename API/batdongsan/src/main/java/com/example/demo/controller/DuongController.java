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

import com.example.demo.entity.Duong;
import com.example.demo.service.DuongService;

@CrossOrigin
@Controller
public class DuongController {

	@Autowired
	DuongService duongService;
	
	@RequestMapping(value = "/duongs", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Duong>> findAllDuong() {
        List<Duong> duong = duongService.getAllduong();
        if (duong.isEmpty()) {
            return new ResponseEntity<List<Duong>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Duong>>(duong, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findbyidvung/{idvung}", method = RequestMethod.GET)
	public @ResponseBody List<Duong> getsachbyIdvung(@PathVariable(value="idvung") Long idvung) {
		return duongService.findBy_idVung(idvung);
	}
}
