package com.xdong.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

// Generated 2020-3-28 16:14:24 by Hibernate Tools 5.4.12.Final

/**
 * IndividualAccount generated by hbm2java
 */
@Entity
@Table(name="account_profile")
@PrimaryKeyJoinColumn(name="userID")
public class IndividualAccount extends UserAccount {
	@OneToOne(optional = false,cascade = CascadeType.ALL)
	@JoinColumn(name="profileId")
	private Profile profile;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="individualAccount")
	@OrderBy("applyTime DESC")
	private List<Application> applications;
	
	public IndividualAccount() {
	}
	
	public IndividualAccount(UserAccount userAccount) {
		this.setPassword(userAccount.getPassword());
		this.setAccountType(userAccount.getAccountType());
		this.setEmail(userAccount.getEmail());
		this.profile = new Profile("/resources/images/portrait_user.png");
	}
	
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
