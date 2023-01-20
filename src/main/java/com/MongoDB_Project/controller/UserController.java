package com.MongoDB_Project.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.MongoDB_Project.dto.UserDTO;
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
	public ResponseEntity<List<UserDTO>> findAll(){ //Padrão DTO sendo usado para coletar apenas os dados necessários
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());//Transformando uma List de User para UserDTO
		return ResponseEntity.status(HttpStatus.OK).body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable String id){
		User user = userService.findById(id);
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			return ResponseEntity.status(HttpStatus.OK).body(userDTO);	
	}
	
	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody UserDTO userDTO){
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userService.insertUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO){
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		user.setId(id);
		userService.updateUser(user);
		return ResponseEntity.noContent().build();
	}
	
}
