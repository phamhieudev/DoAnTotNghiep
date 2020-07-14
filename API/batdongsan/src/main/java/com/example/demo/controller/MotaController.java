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

import com.example.demo.entity.Motatindang;
import com.example.demo.entity.Motatindang;
import com.example.demo.service.MotatindangService;




@CrossOrigin
@Controller
public class MotaController {
	
	@Autowired
	MotatindangService MotatindangService;

	@RequestMapping(value = "/Motatindangs", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Motatindang>> findAllMotatindang() {
       List<Motatindang> Motatindang = MotatindangService.getAllMotatindang();
       if (Motatindang.isEmpty()) {
           return new ResponseEntity<List<Motatindang>>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<List<Motatindang>>(Motatindang, HttpStatus.OK);
   }
	
	 @RequestMapping(value = "/createMota", method = RequestMethod.POST)
	    public Motatindang createMota(@Valid @RequestBody Motatindang Motatindang) {
	        return  MotatindangService.createMotatindang(Motatindang);
	    }
	 @RequestMapping(value = "/updateMotatindang/{idhinh}", method = RequestMethod.PUT)
	    public Motatindang updateBook(@PathVariable(value = "idhinh") Long idhinh, @Valid @RequestBody Motatindang Motatindang) {
	        return MotatindangService.updateMotatindang(idhinh, Motatindang);
	    }
	 
	 @RequestMapping(value = "/motatindang/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Motatindang> getAllMotatindang(@PathVariable Long id) {
			return MotatindangService.getById(id);
		}
	 
}
