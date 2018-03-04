package com.sapient.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sapient.models.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	
	
}
