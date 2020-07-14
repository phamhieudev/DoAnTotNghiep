package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.chieuronghem;
import com.example.demo.service.ChieuronghemService;

@Controller
@CrossOrigin
public class ChieuronghemController {

	@Autowired
	ChieuronghemService ChieuronghemService;
	
	@RequestMapping(value = "/chieuronghems", method = RequestMethod.GET)
	
	 public ResponseEntity<List<chieuronghem>> findAllChieuronghem() {
        List<chieuronghem> Chieuronghem = ChieuronghemService.getAllChieuronghem();
        if (Chieuronghem.isEmpty()) {
            return new ResponseEntity<List<chieuronghem>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<chieuronghem>>(Chieuronghem, HttpStatus.OK);
    }
}
