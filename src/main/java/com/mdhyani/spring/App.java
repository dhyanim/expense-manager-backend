package com.mdhyani.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mdhyani.spring.model.User;
import com.mdhyani.spring.repository.UserRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App  implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepo;
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
	User user = userRepo.findByFirstName("mayank");
	System.out.println(user);
	}

}
