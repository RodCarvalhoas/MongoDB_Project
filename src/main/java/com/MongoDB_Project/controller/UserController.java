package com.MongoDB_Project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MongoDB_Project.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping	
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown", "Maria@gmail.com");
		User alex = new User("2", "Alex Green", "Alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

}
