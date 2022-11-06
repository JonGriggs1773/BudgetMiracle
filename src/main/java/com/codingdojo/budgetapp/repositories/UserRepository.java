package com.codingdojo.budgetapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.budgetapp.models.User;



@Repository
public interface UserRepository extends CrudRepository <User, Long> {

	Optional <User> findById(Long id);
	
	Optional <User> findByEmail(String email);
	
	List <User> findAll();
	
	User findUserById(Long id);
	
}
