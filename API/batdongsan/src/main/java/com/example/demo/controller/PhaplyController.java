package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Phaply;
import com.example.demo.service.PhaplyService;

@Controller
@CrossOrigin
public class PhaplyController {

	@Autowired
	PhaplyService PhaplyService;
	
	@RequestMapping(value = "/Phaplys", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Phaply>> findAllPhaply() {
        List<Phaply> Phaply = PhaplyService.getAllPhaply();
        if (Phaply.isEmpty()) {
            return new ResponseEntity<List<Phaply>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Phaply>>(Phaply, HttpStatus.OK);
    }
}
