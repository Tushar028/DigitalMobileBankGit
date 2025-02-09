package com.infy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DigitalBankAccount {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String digitalBankingId;
	private Long mobileNumber;
	private Long accountNumber;
	private String accountType;
	
	public DigitalBankAccount() {
		super();
	}
	public DigitalBankAccount(String digitalBankingId, Long mobileNumber, Long accountNumber, String accountType) {
		super();
		this.digitalBankingId = digitalBankingId;
		this.mobileNumber = mobileNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	public String getDigitalBankingId() {
		return digitalBankingId;
	}
	public void setDigitalBankingId(String digitalBankingId) {
		this.digitalBankingId = digitalBankingId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
