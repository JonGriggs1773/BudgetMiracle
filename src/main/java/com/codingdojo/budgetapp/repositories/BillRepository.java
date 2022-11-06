package com.codingdojo.budgetapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.budgetapp.models.Bill;




@Repository
public interface BillRepository extends CrudRepository <Bill, Long> {
	
	
	List <Bill> findAll();
	
	Optional <Bill> findById(Long id);
	
	Bill findBillById(Long id);
}
