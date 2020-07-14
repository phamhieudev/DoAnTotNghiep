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
import com.example.demo.entity.Quantamsanphamcty;
import com.example.demo.service.QuantamsanphamctyService;



@CrossOrigin
@Controller
public class QuantamSanphamctyController {
	
	@Autowired
	QuantamsanphamctyService quantamsanphamctyService;
	
	@RequestMapping(value = "/quantamsanphamctys", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Quantamsanphamcty>> findAllquantamsanphamcty() {
        List<Quantamsanphamcty> quantamsanphamcty = quantamsanphamctyService.getAllQuantamsanphamcty();
        if (quantamsanphamcty.isEmpty()) {
            return new ResponseEntity<List<Quantamsanphamcty>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Quantamsanphamcty>>(quantamsanphamcty, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/quantamsanphamcty/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Quantamsanphamcty> getAllquantamsanphamcty(@PathVariable Long id) {
			return quantamsanphamctyService.getById(id);
		}
	 	
	

	 @RequestMapping(value = "/xoaquantamsanphamcty/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deletequantamsanphamcty(@PathVariable(value = "id") Long id) {
	        return quantamsanphamctyService.deleteQuantamsanphamcty(id);
	    }

	
	 @RequestMapping(value = "/addquantamsanphamcty", method = RequestMethod.POST)
		public HttpStatus insertquantamsanphamcty(@RequestBody Quantamsanphamcty quantamsanphamcty) {
			return quantamsanphamctyService.addQuantamsanphamcty(quantamsanphamcty) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
		}

	

}
