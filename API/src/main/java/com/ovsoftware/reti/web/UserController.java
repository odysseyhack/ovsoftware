package com.ovsoftware.reti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ovsoftware.reti.domain.User;
import com.ovsoftware.reti.service.UserService;

/**
 * Responsible for processing http requests for Users.
 */

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(String username) {
		User user = userService.getUser(username);
		
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}	
    }
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(User user) {
		userService.createUser(user);
        return ResponseEntity.ok().build();
    }
}
