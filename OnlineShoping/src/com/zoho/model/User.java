package com.zoho.model;

public class User {
	private Integer personId;
	private String personName;
	private String personPassword;
	private String personRole;
	private Integer userBalance;
	private String userMailId;
	private Integer rewardPoint;
	
	
	
	public Integer getRewardPoint() {
		return rewardPoint;
	}
	public void setRewardPoint(Integer rewardPoint) {
		this.rewardPoint = rewardPoint;
	}
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	public Integer getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(Integer userBalance) {
		this.userBalance = userBalance;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonPassword() {
		return personPassword;
	}
	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}
	public String getPersonRole() {
		return personRole;
	}
	public void setPersonRole(String personRole) {
		this.personRole = personRole;
	}
	
}
