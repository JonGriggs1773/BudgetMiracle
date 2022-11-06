package com.codingdojo.budgetapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.budgetapp.models.Bill;
import com.codingdojo.budgetapp.models.Expense;
import com.codingdojo.budgetapp.models.Fund;
import com.codingdojo.budgetapp.models.Income;
import com.codingdojo.budgetapp.services.BillService;
import com.codingdojo.budgetapp.services.ExpenseService;
import com.codingdojo.budgetapp.services.FundService;
import com.codingdojo.budgetapp.services.IncomeService;
import com.codingdojo.budgetapp.services.UserService;




@Controller
public class MoneyController {
	
	
	@Autowired
	BillService bService;
	
	@Autowired
	ExpenseService eService;
	
	@Autowired
	FundService fService;
	
	@Autowired
	UserService uService;
	
	@Autowired
	IncomeService iService;
	
	@GetMapping("/add/bill")
	public String renderBillPage(@ModelAttribute("bill") Bill bill,
								 HttpSession session,
								 Model model) {
		
		
		if (session.getAttribute("loggedIn") != null) {
			model.addAttribute("oneUser", uService.find((Long)session.getAttribute("loggedIn")));
			return "addBill.jsp";
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/confirm/new/bill")
	public String addBill(@Valid @ModelAttribute("bill") Bill bill,
						  BindingResult result,
						  HttpSession session) {
		if (result.hasErrors()) {
			return "addBill.jsp";
		}
		bService.saveBill(bill);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/add/expense")
	public String renderExpensePage(@ModelAttribute("expense") Expense expense,
									HttpSession session,
									Model model) {
		
		if (session.getAttribute("loggedIn") != null) {
			model.addAttribute("oneUser", uService.find((Long) session.getAttribute("loggedIn")));
			return "addExpense.jsp";
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/confirm/new/expense")
	public String addExpense(@Valid @ModelAttribute("expense") Expense expense,
						  BindingResult result,
						  HttpSession session) {
		if (result.hasErrors()) {
			return "addExpense.jsp";
		}
		eService.saveExpense(expense);
		return "redirect:/dashboard";
	}
	
	
	@GetMapping("/add/fund")
	public String renderFundPage(@ModelAttribute("fund") Fund fund,
									HttpSession session,
									Model model) {
		
		if (session.getAttribute("loggedIn") != null) {
			model.addAttribute("oneUser", uService.find((Long) session.getAttribute("loggedIn")));
			return "addFund.jsp";
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/confirm/new/fund")
	public String addFund(@Valid @ModelAttribute("fund") Fund fund,
						  BindingResult result,
						  HttpSession session) {
		if (result.hasErrors()) {
			return "addFund.jsp";
		}
		fService.saveFund(fund);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/edit/bill/page/{id}")
	public String renderEditBillPage(@ModelAttribute("bill") Bill bill,
									 @PathVariable("id") Long id,
									 Model model,
									 HttpSession session) {
		
		if (session.getAttribute("loggedIn") != null) {
			
			model.addAttribute("oneBill", bService.find(id));
			model.addAttribute("oneUser", uService.find((Long) session.getAttribute("loggedIn")));
			return "editBill.jsp";
		}
		
		return "redirect:/";
	}
	
	@PutMapping("/bill/{id}/edit")
	public String editBill(@Valid @ModelAttribute("bill") Bill bill,
						   BindingResult result,
						   @PathVariable("id") Long id,
						   Model model) {
		
		if (result.hasErrors()) {
			return "editBill.jsp";
		}
		
		bService.editBill(id, bill);
		return "redirect:/dashboard";
	}
	
	
	@GetMapping("/edit/expense/page/{id}")
	public String renderEditExpensePage(@ModelAttribute("expense") Expense expense,
									 @PathVariable("id") Long id,
									 Model model,
									 HttpSession session) {
		
		if (session.getAttribute("loggedIn") != null) {
			
			model.addAttribute("oneExpense", eService.find(id));
			model.addAttribute("oneUser", uService.find((Long) session.getAttribute("loggedIn")));
			return "editExpense.jsp";
		}
		
		return "redirect:/";
	}
	
	@PutMapping("/expense/{id}/edit")
	public String editExpense(@Valid @ModelAttribute("expense") Expense expense,
						   BindingResult result,
						   @PathVariable("id") Long id,
						   Model model) {
		
		if (result.hasErrors()) {
			return "editExpense.jsp";
		}
		
		eService.editExpense(id, expense);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/edit/fund/page/{id}")
	public String renderEditFundPage(@ModelAttribute("fund") Fund fund,
									 @PathVariable("id") Long id,
									 Model model,
									 HttpSession session) {
		
		if (session.getAttribute("loggedIn") != null) {
			
			model.addAttribute("oneFund", fService.find(id));
			model.addAttribute("oneUser", uService.find((Long) session.getAttribute("loggedIn")));
			return "editFund.jsp";
		}
		
		return "redirect:/";
	}
	
	@PutMapping("/fund/{id}/edit")
	public String editFund(@Valid @ModelAttribute("fund") Fund fund,
						   BindingResult result,
						   @PathVariable("id") Long id,
						   Model model) {
		
		if (result.hasErrors()) {
			return "editExpense.jsp";
		}
		
		fService.editFund(id, fund);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/edit/income/page/{id}")
	public String renderEditIncomePage(@ModelAttribute("income") Income income,
									   @PathVariable("id") Long id,
									   Model model,
									   HttpSession session) {
		
		if (session.getAttribute("loggedIn") != null) {
			
			model.addAttribute("userIncome", iService.find(id));
			model.addAttribute("oneUser", uService.find((Long) session.getAttribute("loggedIn")));
			return "editIncome.jsp";
		}
		
		return "redirect:/";
	}
	
	@PutMapping("/income/{id}/edit")
	public String editIncome(@Valid @ModelAttribute("income") Income income,
						     BindingResult result,
						     @PathVariable("id") Long id,
						     Model model) {
		
		if (result.hasErrors()) {
			return "editIncome.jsp";
		}
		
		iService.editIncome(id, income);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/delete/bill/{id}")
	public String deleteBill(@PathVariable("id") Long id) {
		
		bService.deleteBill(id);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/delete/expense/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		
		eService.deleteExpense(id);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/delete/fund/{id}")
	public String deleteFund(@PathVariable("id") Long id) {
		
		fService.deleteFund(id);
		return "redirect:/dashboard";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
