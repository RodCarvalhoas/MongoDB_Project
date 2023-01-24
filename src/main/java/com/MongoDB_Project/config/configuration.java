package com.MongoDB_Project.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.MongoDB_Project.dto.AuthorDTO;
import com.MongoDB_Project.model.Post;
import com.MongoDB_Project.model.User;
import com.MongoDB_Project.repositories.PostRepository;
import com.MongoDB_Project.repositories.UserRepository;

@Configuration
public class configuration implements CommandLineRunner{
		
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "Maria@gmail.com");
		User alex = new User(null, "Alex Green", "Alex@gmail.com");
		User bob = new User(null, "Bob Grey", "Bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("23/10/2002"), "Partiu viagem", "Vou viajar para Pernambuco", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/09/2002"), "Bom dia", "Acordei Feliz Hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
	}

}
