package com.mdhyani.spring.controller;

import java.util.Date;
import java.util.List;

import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdhyani.spring.model.Address;
import com.mdhyani.spring.model.User;
import com.mdhyani.spring.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserRepository userRepo;

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
		try {
			Address address = user.getAddress();
			user.setCreatedAt(new Date());
			user.setUpdatedAt(new Date());
			user.setAddress(address);
			address.setUser(user);
			User userData = userRepo.save(user);
			return new ResponseEntity<User>(userData, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			LOG.debug("Error while generating response" , e.getMessage());
			throw new Exception(e);
		}
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return (List<User>) userRepo.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userRepo.findOne(id);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepo.delete(id);
	}
	
	@PutMapping("/user")
	public int updateUser(@RequestBody User user) {
		return userRepo.updateUser(user.getFirstName(), user.getLastName(), new Date(), user.getId());
	}
	
}
