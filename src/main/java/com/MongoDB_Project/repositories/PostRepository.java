package com.MongoDB_Project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MongoDB_Project.model.Post;

@Repository
public interface PostRepository extends MongoRepository <Post,String>{

}
