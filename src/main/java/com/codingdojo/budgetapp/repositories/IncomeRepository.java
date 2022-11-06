package com.codingdojo.budgetapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.budgetapp.models.Income;


@Repository
public interface IncomeRepository extends CrudRepository <Income, Long>{

	
	Optional<Income> findById(Long id);
	
	List <Income> findAll();
	
	Income findIncomeById(Long id);
}
