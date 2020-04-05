package com.xdong.model;
// Generated 2020-3-28 16:14:24 by Hibernate Tools 5.4.12.Final

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Position generated by hbm2java
 */
@Entity
@Table(name="position")
public class Position implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer positionId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="jobDescription")
	private String jobDescription;
	
	@Column(name="employmentType")
	private String employmentType;
	
	@Column(name="responsibility")
	private String responsibility;
	
	@Column(name="salaryLow")
	private Integer salaryLow;
	
	@Column(name="salaryHigh")
	private Integer salaryHigh;
	
	@Column(name="publishTime")
	private Date publishTime;

	@ManyToOne(optional = false)
	@JoinColumn(name="companyId")
	private Company company;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="position")
	@OrderBy("applicationTime")
	private List<Application> applications;
	
	public Position() {
	}

	public Position(String title, String jobDescription, String employmentType, String responsibility,
			Date publishTime) {
		this.title = title;
		this.jobDescription = jobDescription;
		this.employmentType = employmentType;
		this.responsibility = responsibility;
		this.publishTime = publishTime;
	}

	public Position(String title, String jobDescription, String employmentType, String responsibility,
			Integer salaryLow, Integer salaryHigh, Date publishTime) {
		this.title = title;
		this.jobDescription = jobDescription;
		this.employmentType = employmentType;
		this.responsibility = responsibility;
		this.salaryLow = salaryLow;
		this.salaryHigh = salaryHigh;
		this.publishTime = publishTime;
	}

	public Integer getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getEmploymentType() {
		return this.employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getResponsibility() {
		return this.responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public Integer getSalaryLow() {
		return this.salaryLow;
	}

	public void setSalaryLow(Integer salaryLow) {
		this.salaryLow = salaryLow;
	}

	public Integer getSalaryHigh() {
		return this.salaryHigh;
	}

	public void setSalaryHigh(Integer salaryHigh) {
		this.salaryHigh = salaryHigh;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
}
