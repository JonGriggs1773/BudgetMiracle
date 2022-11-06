package com.codingdojo.budgetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.budgetapp.models.Expense;
import com.codingdojo.budgetapp.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	
	@Autowired
	ExpenseRepository eRepo;
	
	public Expense find(Long id) {
		return eRepo.findById(id).orElse(null);
	}
	
	public List <Expense> getAllExpenses() {
		return eRepo.findAll();
	}
	
	public Integer getTotalOfAllExpenses(List <Expense> allExpenses) {
		Integer total = 0;
		for(Expense expense : allExpenses) {
			total += expense.getAmount();
		}
		return total;
	}
	
	public Optional<Expense> getExpenseById(Long id) {
		return eRepo.findById(id);
	}
	
	public Expense saveExpense(Expense newExpense) {
		return eRepo.save(newExpense);
	}
	
	public Expense editExpense(Long id, Expense upExpense) {
		if (eRepo.existsById(id) ) {
			return eRepo.save(upExpense);
		}
		return null;
	}
	
	public void deleteExpense(Long id) {
		if (eRepo.existsById(id)) {
			eRepo.deleteById(id);
		}
	}
}
