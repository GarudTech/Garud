package com.garud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garud.entity.User;
import com.garud.service.UserService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Garud Technologies!!";
	}
	
	@GetMapping
	public User getUser(@RequestParam("name") String name) {
		User user = userService.getUser(name);
		return user;
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		User persistedUser = userService.addUser(user);
		return persistedUser;
	}
}
