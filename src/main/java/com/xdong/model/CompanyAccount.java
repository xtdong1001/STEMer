package com.xdong.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="account_company")
@PrimaryKeyJoinColumn(name="userID")
public class CompanyAccount extends UserAccount {
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name="companyId")
	private Company company;
	
	public CompanyAccount() {
		
	}
	
	public CompanyAccount(RegisterAccount registerAccount) {
		this.setPassword(registerAccount.getPassword());
		this.setAccountType(registerAccount.getAccountType());
		this.setEmail(registerAccount.getEmail());
		this.company = new Company("company_logo2.png");
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
