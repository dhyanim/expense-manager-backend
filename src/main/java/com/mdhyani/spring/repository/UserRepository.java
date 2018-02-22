package com.mdhyani.spring.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdhyani.spring.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByFirstName(String firstName);
	
	@Modifying
	@Query("update User u set u.firstName = ?1, u.lastName = ?2, u.updatedAt=?3 where u.id = ?4")
	int updateUser(String firstname, String lastname, Date date, Long userId);

}
