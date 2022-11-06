package com.codingdojo.budgetapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.budgetapp.models.Fund;

@Repository
public interface FundRepository extends CrudRepository <Fund, Long>{

	
	List <Fund> findAll();
	
	Optional <Fund> findById(Long id);
	
	Fund findFundById(Long id);
}
