package com.mdhyani.spring.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdhyani.spring.model.Expense;
import com.mdhyani.spring.model.User;
import com.mdhyani.spring.repository.ExpenseRepository;

@RequestMapping("/user")
@RestController
public class ExpenseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExpenseController.class);
	
	@Autowired
	private ExpenseRepository expenseRepo;
	
	
	@PostMapping("/expense")
	public ResponseEntity<Expense> addExpense(@RequestBody Expense expense)  {
		LOG.debug("addExpense( ) : "+ expense);
		User user = new User();
		user.setId(expense.getUser().getId());
		expense.setUser(user);
		expense.setCreatedDate(new Date());
		expense.setUpdatedDate(new Date());
		expenseRepo.save(expense);
		return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}
	
	@GetMapping("/expense")
	public List<Expense> getUsers() {
		return (List<Expense>) expenseRepo.findAll();
	}

}
