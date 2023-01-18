package com.MongoDB_Project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MongoDB_Project.model.User;
import com.MongoDB_Project.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping	
	public ResponseEntity<List<User>> findAll(){
		//List<User> list = userService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
	}

}
