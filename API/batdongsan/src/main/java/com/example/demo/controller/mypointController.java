package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Nguoidung;
import com.example.demo.entity.Sanpham_cty;
import com.example.demo.entity.mypoint;
import com.example.demo.repository.mypointRepository;
import com.example.demo.service.mypointService;



@CrossOrigin
@Controller
public class mypointController {
	
	@Autowired
	mypointService mypointSer;
	mypointRepository<mypoint> mypointRepository;
	
	 @CrossOrigin
	    @RequestMapping(value = "/find")
	    public List<mypoint> book() {
	        return mypointSer.getAll();
	    }
	
//	@RequestMapping(value = "/addtest/{c}/{d}", method = RequestMethod.POST)
//    public void updateNguoidung(@PathVariable(value = "c") String c,
//    		@PathVariable(value = "d") String d){ 
//         testrepository.addSPCTY(c, d);
//	}
//	@RequestMapping(value = "/addsanphamcty/{x1}/{y1}", method = RequestMethod.POST)
//	@ResponseBody
//	public void set(@RequestParam("x1") String x1
//			,@RequestParam("y1") String y1)
//{
//		testser.addnguoidung(x1, x1);
//	    }
//	@RequestMapping(value = "/add/{x}/{y}", method = RequestMethod.POST)
//	@ResponseBody
//	public void set(@RequestParam("x") String x,@RequestParam("y") String y){
//
//		testser.add(x, y);
//	    }
	@RequestMapping(value = "/add/{id}/{x}/{y}/{name}/{url}", method = RequestMethod.POST)
    @ResponseBody
    public void addGeometry(
    		@PathVariable(name="id") Integer id,
    		@PathVariable(name="x") float x,
    		@PathVariable(name="y") float y,
    		@PathVariable(name="name") String name,
    		@PathVariable(name="url") String url) {
      System.out.println("Received POST request:" + x);
      System.out.println("Received POST request:" + y);
      System.out.println("Received POST request url:" + url);
        mypointSer.add(id,x,y,name,url);
    }
	
//	 @CrossOrigin
//	    @RequestMapping(value = "/add", method = RequestMethod.POST)
//	    public void  createBook(@Valid @RequestBody Integer id
//	    						,@Valid @RequestBody float x
//	    						,@Valid @RequestBody float y
//	    						,@Valid @RequestBody String name
//	    						,@Valid @RequestBody String url) {
//	         mypointSer.add(id, x, y, name, url);
//	    }
	    
	 
	
	    
	    @RequestMapping(value = "/update/{name3}/{name1}/{name2}/{name}/{name31}", method = RequestMethod.PUT)
	    @ResponseBody
	    public void editGeometry(
	    		@PathVariable(name="name3") Integer name3,
	    		@PathVariable(name="name1") float name1,
	    		@PathVariable(name="name2") float name2,
	    		@PathVariable(name="name") String name,
	    		@PathVariable(name="name31") Integer name31) {
//	        System.out.println("Received POST request:" + name);
	      System.out.println("Received POST request:" + name1);
	      System.out.println("Received POST request:" + name2);
	      System.out.println("id:" + name31);
	      System.out.println("name:" + name);
	      System.out.println("idsa:" + name3);
//	      testrepository.addSPCTY(name, name1);
	        mypointSer.edit(name3,name1,name2,name,name31);
	    }
}
