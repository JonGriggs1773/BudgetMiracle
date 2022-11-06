package com.codingdojo.budgetapp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "First name is a required field")
	@Size(min = 2, max = 45, message = "First name must have at least 3 characters")
	private String firstName;
	
	@NotNull(message = "Last name is a required field")
	@Size(min = 2, max = 45, message = "Last name must have at least 3 characters")
	private String lastName;
	
	@NotNull(message = "Email is a required field")
	@Size(min = 5, max = 70, message = "email must be at least 5 characters")
	private String email;
	
	@NotNull(message = "Password is a required field")
	@Size(min = 8, max = 128, message = "Password must be at least 8 characters long")
	private String password;
	
	@Transient
	@NotEmpty(message = "Confirm password is required")
	@Size(min = 8, max = 128, message = "Confirm password must be at least 8 characters")
	private String confirmPassword;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyy-MM-dd")
	public Date updatedAt;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List <Bill> bills;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List <Expense> expenses;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List <Fund> funds;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Income income;

	public User() {}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}


	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<Fund> getFunds() {
		return funds;
	}

	public void setFunds(List<Fund> savings) {
		this.funds = savings;
	}

	public Income getUserIncome() {
		return income;
	}

	public void setUserIncome(Income income) {
		this.income = income;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
