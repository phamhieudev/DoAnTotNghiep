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


import com.example.demo.entity.Trangthaigd;
import com.example.demo.service.TrangthaigdService;

@CrossOrigin
@Controller
public class TrangthaigdController {
	

	@Autowired
	TrangthaigdService TrangthaigdService;
	
	@RequestMapping(value = "/Trangthaigds", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Trangthaigd>> findAllTrangthaigd() {
        List<Trangthaigd> Trangthaigd = TrangthaigdService.getAllTrangthaigd();
        if (Trangthaigd.isEmpty()) {
            return new ResponseEntity<List<Trangthaigd>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Trangthaigd>>(Trangthaigd, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/Trangthaigd/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Trangthaigd> getAllTrangthaigd(@PathVariable Long id) {
			return TrangthaigdService.getById(id);
		}
	 	
	

	 @RequestMapping(value = "/xoaTrangthaigd/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deleteTrangthaigd(@PathVariable(value = "id") Long id) {
	        return TrangthaigdService.deleteTrangthaigd(id);
	    }

	
	 @RequestMapping(value = "/addTrangthaigd", method = RequestMethod.POST)
		public HttpStatus insertTrangthaigd(@RequestBody Trangthaigd Trangthaigd) {
			return TrangthaigdService.addTrangthaigd(Trangthaigd) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
		}

}
