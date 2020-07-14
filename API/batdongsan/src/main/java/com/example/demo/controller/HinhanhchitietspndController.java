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

import com.example.demo.entity.Hinhanhchitietspnd;
import com.example.demo.entity.Sanpham_nguoidung;
import com.example.demo.entity.hinhanh;
import com.example.demo.service.HinhanhchitietspndService;

@CrossOrigin
@Controller
public class HinhanhchitietspndController {


	@Autowired
	HinhanhchitietspndService HinhanhchitietspndService;
	
	@RequestMapping(value = "/Hinhanhchitietspnds", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Hinhanhchitietspnd>> findAllHinhanhchitietspnd() {
        List<Hinhanhchitietspnd> Hinhanhchitietspnd = HinhanhchitietspndService.getAllHinhanhchitietspnd();
        if (Hinhanhchitietspnd.isEmpty()) {
            return new ResponseEntity<List<Hinhanhchitietspnd>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Hinhanhchitietspnd>>(Hinhanhchitietspnd, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/Hinhanhchitietspnd/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Hinhanhchitietspnd> getAllHinhanhchitietspnd(@PathVariable Long id) {
			return HinhanhchitietspndService.getById(id);
	 }
	 	
	 @RequestMapping(value = "/findbyidspnd/{idsp}", method = RequestMethod.GET)
		public @ResponseBody List<Hinhanhchitietspnd> getsachbyIdloai(@PathVariable(value="idsp") Long idsp) {
			return HinhanhchitietspndService.getAllhinhanhtheosp(idsp);
		}

	 
	 @RequestMapping(value = "/xoaHinhanhchitietspnd/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deleteHinhanhchitietspnd(@PathVariable(value = "id") Long id) {
	        return HinhanhchitietspndService.deleteHinhanhchitietspnd(id);
	    }


//	 @RequestMapping(value = "/addHinhanhchitietspnd", method = RequestMethod.POST)
//		public HttpStatus insertHinhanhchitietspnd(@RequestBody Hinhanhchitietspnd Hinhanhchitietspnd) {
//			return HinhanhchitietspndService.addHinhanhchitietspnd(Hinhanhchitietspnd) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
//		}
	 
	 @RequestMapping(value = "/addHinhanhchitietspnd", method = RequestMethod.POST)
	    public Hinhanhchitietspnd createhinhanh(@Valid @RequestBody Hinhanhchitietspnd Hinhanhchitietspnd) {
	        return  HinhanhchitietspndService.createhinhanh(Hinhanhchitietspnd);
	    }
}
