package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entity.Tintuc;
import com.example.demo.entity.hinhanh;
import com.example.demo.entity.hinhanhtintuc;
import com.example.demo.service.HinhanhService;
import com.example.demo.service.HinhanhtintuctintucService;


@CrossOrigin
@Controller
public class HinhanhtintucController {
	
	@Autowired
	HinhanhtintuctintucService hinhanhService;

	@RequestMapping(value = "/hinhanhtintucs", method = RequestMethod.GET)
	
	 public ResponseEntity<List<hinhanhtintuc>> findAllhinhanh() {
       List<hinhanhtintuc> hinhanh = hinhanhService.getAllHinhanhtintuc();
       if (hinhanh.isEmpty()) {
           return new ResponseEntity<List<hinhanhtintuc>>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<List<hinhanhtintuc>>(hinhanh, HttpStatus.OK);
   }
	
	 @RequestMapping(value = "/createHinhanhtintuc", method = RequestMethod.POST)
	    public hinhanhtintuc createHinh(@Valid @RequestBody hinhanhtintuc hinhanh) {
	        return  hinhanhService.createHinhanhtintuc(hinhanh);
	    }
	 
	 @RequestMapping(value = "/updatehinhanhtintuc/{id_hinhTintuc}", method = RequestMethod.PUT)
	    public hinhanhtintuc updatetintuc(@PathVariable(value = "id_hinhTintuc") Long id_hinhTintuc, @Valid @RequestBody hinhanhtintuc hinhanhtintuc){ 
	        return hinhanhService.updateHinhanhtintuc(id_hinhTintuc, hinhanhtintuc);
		}
}
