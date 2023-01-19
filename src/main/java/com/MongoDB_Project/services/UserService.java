package com.MongoDB_Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MongoDB_Project.exception.ObjectNotFoundException;
import com.MongoDB_Project.model.User;
import com.MongoDB_Project.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> userOptional = userRepository.findById(id);
		return userOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
