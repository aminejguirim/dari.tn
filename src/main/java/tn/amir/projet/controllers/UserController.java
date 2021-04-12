package tn.amir.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.amir.projet.entity.User;
import tn.amir.projet.services.IUserService;

@RestController
public class UserController {
	
	@Autowired
	IUserService us;
	
	// http://localhost:8081/Dari/servlet/SignUP
		@PostMapping("/SignUP")
		@ResponseBody
		public void SignUP(@RequestBody User u) {
			us.SignUP(u);
		}

}
