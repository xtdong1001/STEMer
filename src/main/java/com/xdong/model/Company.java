package com.xdong.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

// Generated 2020-3-28 16:14:24 by Hibernate Tools 5.4.12.Final

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name="company")
public class Company implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="foundYear")
	private String foundYear;
	
	@Column(name="industry")
	private String industry;
	
	@Column(name="description")
	private String description;
	
	@Column(name="websiteAddr")
	private String websiteAddr;
	
	@Column(name="logoPath")
	private String logoPath;
	
	@OneToMany(mappedBy="company")
	@OrderBy("publishTime DESC")
	private List<Position> positions;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="company")
	private CompanyAccount companyAccount;
	
	@Transient
	private CommonsMultipartFile logo;

	public Company() {
	}

	public Company(String logoPath) {
		this.logoPath = logoPath;
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFoundYear() {
		return this.foundYear;
	}

	public void setFoundYear(String foundYear) {
		this.foundYear = foundYear;
	}

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsiteAddr() {
		return this.websiteAddr;
	}

	public void setWebsiteAddr(String websiteAddr) {
		this.websiteAddr = websiteAddr;
	}

	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public CompanyAccount getCompanyAccount() {
		return companyAccount;
	}

	public void setCompanyAccount(CompanyAccount companyAccount) {
		this.companyAccount = companyAccount;
	}

	public CommonsMultipartFile getLogo() {
		return logo;
	}

	public void setLogo(CommonsMultipartFile logo) {
		this.logo = logo;
	}
	
}
