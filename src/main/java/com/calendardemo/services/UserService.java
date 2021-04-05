package com.calendardemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.calendardemo.entity.AppUsers;
import com.calendardemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<?> saveUser(AppUsers user) {
		try {
		AppUsers checkUser=userRepository.findByUserName(user.getUserName());
		if(checkUser==null) {
			user=userRepository.save(user);
			 return new ResponseEntity<>("success",HttpStatus.OK);
		}
		 else
		return new ResponseEntity<>("User Exists",HttpStatus.CONFLICT);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

}
