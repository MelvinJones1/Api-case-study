package com.springboot.case_study.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.exception.InvalidUsernameException;
import com.springboot.case_study.model.User;
import com.springboot.case_study.repository.AuthRepository;

@Service
public class AuthService {
	
	@Autowired
	private AuthRepository authRepository;
	
	@Autowired
 	private BCryptPasswordEncoder bcrypt;
	

	public User signUp(User user) throws InvalidUsernameException {
 		//check if Username is unique 
 		User user1 =  authRepository.findByUsername(user.getUsername());
 		if(user1 != null) { 
 			//if user exists it will be not null. if its a new username then it will be null 
 			throw new InvalidUsernameException("Username already exists");
 		}
 		/*Give role USER_DEFAULT if not provided */
		
		if(user.getRole() == null)
 			user.setRole("USER_DEFAULT");
		
		//encode the password 
 		String encodedPass = bcrypt.encode(user.getPassword());
 		
 		//attach encoded pass to user 
 		user.setPassword(encodedPass);
 		
 		return authRepository.save(user);
	}


	public User findById(int userId) throws InvalidIdException{
		
		Optional<User> optional = authRepository.findById(userId);
		
		if(optional.isEmpty()) {
			throw new InvalidIdException("Invalid User Id...");
		}
		
		return optional.get();
		
	}
	
	
	

}
