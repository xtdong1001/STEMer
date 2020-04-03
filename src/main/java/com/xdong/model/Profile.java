package com.xdong.model;
// Generated 2020-3-28 16:14:24 by Hibernate Tools 5.4.12.Final

/**
 * Profile generated by hbm2java
 */
public class Profile implements java.io.Serializable {

	private Integer profileId;
	private int userId;
	private String firstName;
	private String lastName;
	private String contactEmail;
	private String phone;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String summary;
	private String portraitPath;

	public Profile() {
	}

	public Profile(int userId) {
		this.userId = userId;
	}

	public Profile(int userId, String firstName, String lastName, String contactEmail, String phone, String address,
			String city, String state, String zipcode, String country, String summary, String portraitPath) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactEmail = contactEmail;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.summary = summary;
		this.portraitPath = portraitPath;
	}

	public Integer getProfileId() {
		return this.profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPortraitPath() {
		return this.portraitPath;
	}

	public void setPortraitPath(String portraitPath) {
		this.portraitPath = portraitPath;
	}

}