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

import com.example.demo.entity.Tintuc;
import com.example.demo.service.TintucService;


@CrossOrigin
@Controller
public class TintucController {

	
	@Autowired
	TintucService tintucService;
	
	@RequestMapping(value = "/tintucs", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Tintuc>> findAlltintuc() {
        List<Tintuc> tintuc = tintucService.getAlltintuc();
        if (tintuc.isEmpty()) {
            return new ResponseEntity<List<Tintuc>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Tintuc>>(tintuc, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/tintuc/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Tintuc> getAlltintuc(@PathVariable Long id) {
			return tintucService.getById(id);
		}
	 	
	

	 @RequestMapping(value = "/xoatintuc/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deletetintuc(@PathVariable(value = "id") Long id) {
	        return tintucService.deletetintuc(id);
	    }

	
	  @RequestMapping(value = "/addtintuc", method = RequestMethod.POST)
	    public Tintuc inserttintuc(@Valid @RequestBody Tintuc tintuc) {
	        return tintucService.addTintuc(tintuc);
	    }

	@RequestMapping(value = "/updatetintuc/{id_Tintuc}", method = RequestMethod.PUT)
    public Tintuc updatetintuc(@PathVariable(value = "id_Tintuc") Long id_Tintuc, @Valid @RequestBody Tintuc tintuc){ 
        return tintucService.updateTintuc(id_Tintuc, tintuc);
	}
}
