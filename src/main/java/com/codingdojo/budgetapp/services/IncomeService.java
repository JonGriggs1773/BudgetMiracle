package com.codingdojo.budgetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.budgetapp.models.Income;
import com.codingdojo.budgetapp.models.User;
import com.codingdojo.budgetapp.repositories.BillRepository;
import com.codingdojo.budgetapp.repositories.ExpenseRepository;
import com.codingdojo.budgetapp.repositories.FundRepository;
import com.codingdojo.budgetapp.repositories.IncomeRepository;
import com.codingdojo.budgetapp.repositories.UserRepository;




@Service
public class IncomeService {

	@Autowired
	IncomeRepository iRepo;
	
	@Autowired
	BillRepository bRepo;
	
	@Autowired
	ExpenseRepository eRepo;
	
	@Autowired
	FundRepository fRepo;
	
	@Autowired
	UserRepository uRepo;
	
	@Autowired
	BillService bService;
	
	@Autowired
	ExpenseService eService;
	
	@Autowired
	FundService fService;
	
	@Autowired
	UserService uService;
	
	
	public Income find(Long id) {
		return iRepo.findById(id).orElse(null);
	}
	
	public Integer getIncome(Long id) {
		
		Income incomeObject = iRepo.findIncomeById(id);
		Integer incomeData = incomeObject.getIncome();
		return incomeData;
	}
	
	public Integer calculateAllDealings(Long id) {
		
		User loggedInUser = uRepo.findUserById(id);
		Integer billTotal = bService.getTotalOfAllBills(loggedInUser.getBills());
		Integer expenseTotal = eService.getTotalOfAllExpenses(loggedInUser.getExpenses());
		Integer fundTotal = fService.getTotalOfAllFunds(loggedInUser.getFunds());
		Integer userIncome = loggedInUser.getUserIncome().getIncome();
		
		Integer allExpenseTotal = billTotal + expenseTotal + fundTotal;
		
		Integer finalTotal = userIncome - allExpenseTotal;
		
		return finalTotal;
		
		
	}
	
	
	
	public Income saveIncome(Income newIncome) {
		return iRepo.save(newIncome);
	}
	
	public Income editIncome(Long id, Income upIncome) {
		if (iRepo.existsById(id) ) {
			return iRepo.save(upIncome);
		}
		return null;
	}
	
	public void deleteIncome(Long id) {
		if (iRepo.existsById(id)) {
			iRepo.deleteById(id);
		}
	}
	
	
	
	
	
}
