package com.dari.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.spring.entity.Property;
import com.dari.spring.service.IPropertyService;




@RestController
public class PropertyRestController {
	
	@Autowired
	IPropertyService propService;

	// http://localhost:6000/SpringMVC/servlet/retrieve-all-prop
	@GetMapping("/retrieve-all-prop")
	@ResponseBody
	public List<Property> getAdss() {
	List<Property> list = propService.retrieveAllProp();
	return list;
	
	}
	
	// http://localhost:6000/SpringMVC/servlet/retrieve-prop/{prop-id}
	@GetMapping("/retrieve-prop/{prop-id}")
	@ResponseBody
	public Property retrieveUser(@PathVariable("prop-id") String propId) {
	return propService.retrieveProp(propId);
	}

	// http://localhost:6000/SpringMVC/servlet/add-prop
	@PostMapping("/add-prop")
	@ResponseBody
	public Property addProp(@RequestBody Property p) {
	Property prop = propService.addProp(p);
	return prop;
	}
	
	// http://localhost:6000/SpringMVC/servlet/remove-prop/{prop-id}
	@DeleteMapping("/remove-prop/{prop-id}")
	@ResponseBody
	public void removeUser(@PathVariable("prop-id") Long propId) {
	propService.deleteProp(propId);;
	}

	// http://localhost:6000/SpringMVC/servlet/modify-user
	@PutMapping("/modify-user")
	@ResponseBody
	public Property modifyUser(@RequestBody Property prop) {
	return propService.updateProp(prop);
	}

}
