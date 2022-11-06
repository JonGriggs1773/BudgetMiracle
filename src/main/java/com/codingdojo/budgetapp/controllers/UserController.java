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
import com.codingdojo.budgetapp.models.LoginUser;
import com.codingdojo.budgetapp.models.User;
import com.codingdojo.budgetapp.services.IncomeService;
import com.codingdojo.budgetapp.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService uService;
	
	@Autowired
	IncomeService iService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user,
								BindingResult result,
								HttpSession session,
								Model model) {
		
		User newUser = uService.register(user, result);
		
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("loggedIn", newUser.getId());
		return "redirect:/intro";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
				BindingResult result,
				Model model,
				HttpSession session) {
		
		User userLog = uService.authentication(loginUser, result);
		
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		
		session.setAttribute("loggedIn", userLog.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		
		if (session.getAttribute("loggedIn") != null) {
			User loggedInUser = uService.find((Long) session.getAttribute("loggedIn"));
			model.addAttribute("oneUser", uService.find((Long)session.getAttribute("loggedIn")));
			model.addAttribute("userIncome", loggedInUser.getUserIncome());
			model.addAttribute("calculatedIncome", iService.calculateAllDealings(loggedInUser.getId()));
			model.addAttribute("allBills", loggedInUser.getBills());
			model.addAttribute("allExpenses", loggedInUser.getExpenses());
			model.addAttribute("allFunds", loggedInUser.getFunds());
			return "dashboard.jsp";
		}
		return "redirect:/";
	}
	
	@GetMapping("/intro")
	public String displayIntroPage(Model model, HttpSession session) {
		
		if (session.getAttribute("loggedIn") != null) {
				model.addAttribute("oneUser", uService.find((Long)session.getAttribute("loggedIn")));
				return "intro.jsp";	
		}
		return "index.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("loggedIn");
		
		return "redirect:/";
	}
	
	@GetMapping("/pay/frequency")
	public String selectPayFrequency(Model model, HttpSession session, 
									@ModelAttribute("income") Income income) {
		
		if (session.getAttribute("loggedIn") != null) {
			model.addAttribute("oneUser", uService.find((Long)session.getAttribute("loggedIn")));
			return "payFrequency.jsp";			
		}
		return "redirect:/";
		
	}
	
	@GetMapping("/input/income")
	public String inputUserIncome(Model model, HttpSession session, 
								  @ModelAttribute("income") Income income) {
		
		if (session.getAttribute("loggedIn") != null) {
			model.addAttribute("oneUser", uService.find((Long)session.getAttribute("loggedIn")));
			return "inputIncome.jsp";			
		}
		return "index.jsp";
		
	}
	
	@GetMapping("/resources")
	public String resources(HttpSession session, Model model) {
		if (session.getAttribute("loggedIn") != null) {
			model.addAttribute("oneUser", uService.find((Long)session.getAttribute("loggedIn")));
			return "resources.jsp";
		}
		
		return "redirect:/";
	}
	

	
	
	
	
}
