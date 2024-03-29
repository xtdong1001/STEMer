package com.xdong.model;

public class RegisterAccount  implements java.io.Serializable{
	
	private String email;
	private String password;
	private String password2;
	private String accountType;
	private String checkAgree;

	public RegisterAccount() {
	}
	
	
	public RegisterAccount(String email, String password, String accountType) {
		this.email = email;
		this.password = password;
		this.accountType = accountType;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}


	public String getCheckAgree() {
		return checkAgree;
	}


	public void setCheckAgree(String checkAgree) {
		this.checkAgree = checkAgree;
	}
}
