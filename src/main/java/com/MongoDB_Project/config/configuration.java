package com.MongoDB_Project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.MongoDB_Project.model.User;
import com.MongoDB_Project.repositories.UserRepository;

@Configuration
public class configuration implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "Maria@gmail.com");
		User alex = new User(null, "Alex Green", "Alex@gmail.com");
		User bob = new User(null, "Bob Grey", "Bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
	}

}
