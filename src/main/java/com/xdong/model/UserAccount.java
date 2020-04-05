package com.xdong.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

// Generated 2020-3-28 16:14:24 by Hibernate Tools 5.4.12.Final

/**
 * UserAccount generated by hbm2java
 */
@Entity
@Table(name="user_account")
public class UserAccount implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="accountType")
	private String accountType;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="userAccount")
	@OrderBy("applicationTime DESC")
	private List<Application> applications;
	
	public UserAccount() {
	}

	public UserAccount(String email, String password, String accountType) {
		this.email = email;
		this.password = password;
		this.accountType = accountType;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}
