package com.codingdojo.budgetapp.services;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.budgetapp.models.LoginUser;
import com.codingdojo.budgetapp.models.User;
import com.codingdojo.budgetapp.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository uRepo;
	
	public User find(Long id) {
		return uRepo.findById(id).orElse(null);
	}

	public User register(User u, BindingResult result) {
		
		User emailCheck = uRepo.findByEmail(u.getEmail()).orElse(null);
		
		if (emailCheck != null) {
			
			result.rejectValue("email", "unique", "Email is unavailable");
		}
		
		if (!u.getPassword().equals(u.getConfirmPassword())) {
			
			result.rejectValue("confirmPassword", "errorMatches", "Confirm password must match passowrd");
		}
		
		if (result.hasErrors() ) {
			return null;
		}
		
		String hash = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hash);
		
		return uRepo.save(u); 
	}
	
	public User authentication(LoginUser loginUser, BindingResult result) {
		
		User userInDb = uRepo.findByEmail(loginUser.getEmail()).orElse(null);
		
		if (userInDb == null) {
			result.rejectValue("email", "exists", "Invalid Login Information");
			return null;
		}
		
		if (!BCrypt.checkpw(loginUser.getPassword(), userInDb.getPassword())) {
			result.rejectValue("email", "invalid", "Invalid Login Information");
			return null;
		}
		
		if (result.hasErrors()) {
			return null;
		}
		
		return userInDb;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
