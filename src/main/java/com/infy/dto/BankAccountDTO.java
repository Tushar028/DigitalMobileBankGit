package com.infy.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

public class BankAccountDTO {
	
	@NotNull(message = "{account.no.notpresent}")
	@Pattern(regexp = "[0-9]{7,}",message="{account.no.invalid}" )
	private Long accountNumber;
	@NotNull(message = "{bank.name.notpresent}")
	@Pattern(regexp = "[A-Za-z]{5,15}", message = "{bank.name.invalid}")
	private String bankName;
	@Pattern(regexp = "(0|[1-9]*)", message = "{balance.invalid}")
	private Double balance;
	@NotNull(message = "{account.type.notnull}")
	@Pattern(regexp = "[A-Za-z]{1,10}", message = "{account.type.invalid}")
	private String accountType;
	@NotNull(message = "{ifsc.code.notnull}")
	@Pattern(regexp = "[A-Za-z]{1,15}", message = "{ifsc.code.invalid}")
	private String ifscCode;
	@Past(message = "{opening.date.invalid}")
	private LocalDate openingDate;
	@NotNull(message = "{mobile.no.notnull}")
	@Pattern(regexp = "[0-9]{10}", message = "{mobile.no.invalid}")
	private Long mobileNumber;
	
	public BankAccountDTO() {
		super();
	}

	public BankAccountDTO(Long accountNumber, String bankName, Double balance, String accountType, String ifscCode,
			LocalDate openingDate, Long mobileNumber) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.balance = balance;
		this.accountType = accountType;
		this.ifscCode = ifscCode;
		this.openingDate = openingDate;
		this.mobileNumber = mobileNumber;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "BankAccountDTO [accountNumber=" + accountNumber + ", bankName=" + bankName + ", balance=" + balance
				+ ", accountType=" + accountType + ", ifscCode=" + ifscCode + ", openingDate=" + openingDate
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
}
