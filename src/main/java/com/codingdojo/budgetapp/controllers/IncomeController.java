package com.codingdojo.budgetapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.budgetapp.models.Income;
import com.codingdojo.budgetapp.models.User;
import com.codingdojo.budgetapp.services.IncomeService;
import com.codingdojo.budgetapp.services.UserService;

@Controller
public class IncomeController {

	
	@Autowired
	IncomeService iService;
	
	@Autowired
	UserService uService;
	
	@PostMapping("/weekly")
	public String calculateWeeklyIncomeIntoMonthly(@Valid 
												   @ModelAttribute("income") Income income, 
												   BindingResult result) {
		if (result.hasErrors()) {
			return "payFrequency.jsp";
		}
		
		Integer weeks = Integer.valueOf(4);
		income.setIncome(income.getIncome() * weeks);
		iService.saveIncome(income);
		
		return "redirect:/dashboard";
		 
		
	}
	
	@PostMapping("/bi/weekly")
	public String calculateBiWeeklyIncomeIntoMonthly(@Valid 
												   @ModelAttribute("income") Income income, 
												   BindingResult result) {
		if (result.hasErrors()) {
			return "payFrequency.jsp";
		}
		
		Integer weeks = Integer.valueOf(2);
		income.setIncome(income.getIncome() * weeks);
		iService.saveIncome(income);
		
		return "redirect:/dashboard";
		 
		
	}
	
	@PostMapping("/misc")
	public String calculateMiscIncomeIntoMonthly(@Valid 
												 @ModelAttribute("income") Income income, 
												 BindingResult result) {
		if (result.hasErrors()) {
			return "payFrequency.jsp";
		}
		
		Integer months = Integer.valueOf(12);
		income.setIncome(income.getIncome() / months);
		iService.saveIncome(income);
		
		return "redirect:/dashboard";
		 
		
	}
	
	@GetMapping("/late/income/input")
	public String checkIfIncomeAlreadyExists(HttpSession session) {
		
		User loggedInUser = uService.find((Long) session.getAttribute("loggedIn"));
		
		if (loggedInUser.getUserIncome() == null) {
			return "intro.jsp";
		}
		
		return "redirect:/already/exists";
	}
	
	@GetMapping("/already/exists")
	public String incomeExistsPage(HttpSession session, Model model) {
		
		if (session.getAttribute("loggedIn") != null) {
			model.addAttribute("oneUser", uService.find((Long)session.getAttribute("loggedIn")));
			return "oops.jsp";	
		}
		
		return "redirect:/";
		
		
	}
	
	
	
	
	
	
	
	
	
}
