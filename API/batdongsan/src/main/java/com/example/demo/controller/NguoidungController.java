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
import com.example.demo.entity.Nguoidung;
import com.example.demo.service.NguoidungService;


@CrossOrigin
@Controller
public class NguoidungController {
	
	@Autowired
	NguoidungService nguoidungService;
	
	@RequestMapping(value = "/nguoidungs", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Nguoidung>> findAllnguoidung() {
        List<Nguoidung> nguoidung = nguoidungService.getAllnguoidung();
        if (nguoidung.isEmpty()) {
            return new ResponseEntity<List<Nguoidung>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Nguoidung>>(nguoidung, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/nguoidung/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Nguoidung> getAllnguoidung(@PathVariable Long id) {
			return nguoidungService.getById(id);
		}
	 	
	

	 @RequestMapping(value = "/xoanguoidung/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deletenguoidung(@PathVariable(value = "id") Long id) {
	        return nguoidungService.deletenguoidung(id);
	    }

	
	 @RequestMapping(value = "/addnguoidung", method = RequestMethod.POST)
		public HttpStatus insertNguoidung(@RequestBody Nguoidung nguoidung) {
			return nguoidungService.addNguoidung(nguoidung) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
		}

	@RequestMapping(value = "/updatenguoidung/{id_nguoidung}", method = RequestMethod.PUT)
    public Nguoidung updateNguoidung(@PathVariable(value = "id_nguoidung") Long id_nguoidung, @Valid @RequestBody Nguoidung nguoidung){ 
        return nguoidungService.updateNguoidung(id_nguoidung, nguoidung);
	}

}
