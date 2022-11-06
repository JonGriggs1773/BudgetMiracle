package com.codingdojo.budgetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.budgetapp.models.Bill;
import com.codingdojo.budgetapp.repositories.BillRepository;




@Service
public class BillService {
	@Autowired
	BillRepository bRepo;
	
	public Bill find(Long id) {
		return bRepo.findById(id).orElse(null);
	}
	
	public List <Bill> getAllBills() {
		return bRepo.findAll();
	}
	
	public Integer getTotalOfAllBills(List <Bill> allBills) {
		Integer total = 0;
		for(Bill bill : allBills) {
			total += bill.getAmount();
		}
		return total;
	}
	
	public Optional <Bill> getBillById(Long id) {
		return bRepo.findById(id);
	}
	
	public Bill saveBill(Bill newBill) {
		return bRepo.save(newBill);
	}
	
	public Bill editBill(Long id, Bill upBill) {
		if (bRepo.existsById(id) ) {
			return bRepo.save(upBill);
		}
		return null;
	}
	
	public void deleteBill(Long id) {
		if (bRepo.existsById(id)) {
			bRepo.deleteById(id);
		}
	}
}
