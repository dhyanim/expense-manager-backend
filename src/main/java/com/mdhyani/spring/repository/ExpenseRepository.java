package com.mdhyani.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.mdhyani.spring.model.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	

}
