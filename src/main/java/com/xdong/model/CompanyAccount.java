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
	
	public CompanyAccount(UserAccount userAccount) {
		this.setPassword(userAccount.getPassword());
		this.setAccountType(userAccount.getAccountType());
		this.setEmail(userAccount.getEmail());
		this.company = new Company();
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
