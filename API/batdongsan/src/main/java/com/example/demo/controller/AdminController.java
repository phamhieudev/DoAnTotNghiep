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

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;




@CrossOrigin
@Controller
public class AdminController {
	
	@Autowired
	AdminService AdminService;

	@RequestMapping(value = "/Admins", method = RequestMethod.GET)
	
	 public ResponseEntity<List<Admin>> findAllAdmin() {
       List<Admin> Admin = AdminService.getAlladmin();
       if (Admin.isEmpty()) {
           return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<List<Admin>>(Admin, HttpStatus.OK);
   }
	
	 @RequestMapping(value = "/createAdmin", method = RequestMethod.POST)
	    public Admin createHinh(@Valid @RequestBody Admin Admin) {
	        return  AdminService.addAdmin(Admin);
	    }
	 @RequestMapping(value = "/updateAdmin/{idhinh}", method = RequestMethod.PUT)
	    public Admin updateBook(@PathVariable(value = "idhinh") Long idhinh, @Valid @RequestBody Admin Admin) {
	        return AdminService.updateAdmin(idhinh, Admin);
	    }
	 
	 @RequestMapping(value = "/xoaadmin/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Admin> deleteadmin(@PathVariable(value = "id") Long id) {
	        return AdminService.deleteadmin(id);
	    }
	 
}
