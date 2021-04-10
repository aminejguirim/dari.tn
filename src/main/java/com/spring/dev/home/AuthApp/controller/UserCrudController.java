package com.spring.dev.home.AuthApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dev.home.AuthApp.model.User;
import com.spring.dev.home.AuthApp.repository.UserRepository;
import com.spring.dev.home.AuthApp.service.UserCrudServiceImpl;
import com.spring.dev.home.AuthApp.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserCrudController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserCrudServiceImpl service;
	@Autowired
	UserService userService;
	
	@PostMapping("/add-user")
	@PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Returns the current user profile")
	@ResponseBody
	public User addUser(@RequestBody User u) {
	User user = service.addUser(u);
	return user;
	}

// http://localhost:4023/SpringMVC/servlet/retrieve-all-users
	@GetMapping("/retrieve-all-users")
	@PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Returns the list of configured admins. Requires ADMIN Access")
	@ResponseBody
	public List<User> getUsers() {
	List<User> list = service.retrieveAllUsers();
	return list;
	
	}
	// http://localhost:4023/SpringMVC/servlet/modify-user
	@PutMapping("/modify-user")
	@PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Returns the current user profile")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
	return service.updateUser(user);
	}
	
	// http://localhost:4023/SpringMVC/servlet/remove-user/{user-id}
	@DeleteMapping("/remove-user/{user-id}")
	@PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Returns the current user profile")
	@ResponseBody
	public void removeUser(@PathVariable("user_id") Long userId) {
	service.deleteUserById(userId);
	}
	
	@GetMapping("/count") 
	@ResponseBody 
	 //http://localhost:8081/SpringMVC/servlet/count
	 public List<User> getnombre() { 
		return service.retrieveAllUsers();
		  
	}
	
	@GetMapping("/getUserById/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public Optional<User> getBookById(@PathVariable(value="id") Long id)
	{
	return userRepository.findById(id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public void deleteBook(@PathVariable(value="id") Long id)
	{
	Optional<User> user=userRepository.findById(id);
	 User user_new=user.get();
	userRepository.delete(user_new);
	
	}
	}


