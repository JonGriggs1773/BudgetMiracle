package com.codingdojo.budgetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.budgetapp.models.Fund;
import com.codingdojo.budgetapp.repositories.FundRepository;

@Service
public class FundService {
	
	@Autowired
	FundRepository fRepo;
	
	public Fund find(Long id) {
		return fRepo.findById(id).orElse(null);
	}
	
	public List <Fund> getAllFunds() {
		return fRepo.findAll();
	}
	
	public Integer getTotalOfAllFunds(List <Fund> allFunds) {
		Integer total = 0;
		for(Fund fund : allFunds) {
			total += fund.getAmount();
		}
		return total;
	}
	
	public Optional <Fund> getFundById(Long id) {
		return fRepo.findById(id);
	}
	
	public Fund saveFund(Fund newFund) {
		return fRepo.save(newFund);
	}
	
	public Fund editFund(Long id, Fund upFund) {
		if (fRepo.existsById(id) ) {
			return fRepo.save(upFund);
		}
		return null;
	}
	
	public void deleteFund(Long id) {
		if (fRepo.existsById(id)) {
			fRepo.deleteById(id);
		}
	}
}
