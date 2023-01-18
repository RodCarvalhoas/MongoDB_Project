package com.MongoDB_Project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MongoDB_Project.model.User;

@Repository
public interface UserRepository extends MongoRepository <User,String>{

}
