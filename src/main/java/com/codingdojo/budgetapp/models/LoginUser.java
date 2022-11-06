package com.codingdojo.budgetapp.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {

	@NotEmpty(message = "Invalid Login Attempt")
	@Email(message = "Please input a valid Email")
	private String email;
	
	@NotEmpty(message = "Must not be empty")
	@Size(min = 8, max = 128, message = "Invalid Login Attempt")
	private String password;

	public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
