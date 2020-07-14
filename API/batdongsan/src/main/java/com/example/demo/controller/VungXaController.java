package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.VungXa;
import com.example.demo.service.VungXaService;



@CrossOrigin
@Controller
public class VungXaController {

	@Autowired
	VungXaService vungxaService;
	
	@RequestMapping(value = "/vungxas", method = RequestMethod.GET)
	
	 public ResponseEntity<List<VungXa>> findAllVungXa() {
        List<VungXa> vungxa = vungxaService.getAllvungxa();
        if (vungxa.isEmpty()) {
            return new ResponseEntity<List<VungXa>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<VungXa>>(vungxa, HttpStatus.OK);
    }
	
//	 @RequestMapping(value = "/searchxy/{x}/{y}", method = RequestMethod.GET)
//	 @ResponseBody
//	    public  List<VungXa> searchByxy(@PathVariable float x,@PathVariable float y)
//	    {
//		 
//	    	return vungxaService.findxy(x, y);
//	    }
	 
	 @RequestMapping(value = "/searchxy/{x}/{y}", method = RequestMethod.GET,produces = { "application/json", "application/xml" })
		public @ResponseBody VungXa searchByxy(@PathVariable(value="x") float x,@PathVariable(value="y") float y) {
			return vungxaService.findxy(x,y);
		}
	
}
