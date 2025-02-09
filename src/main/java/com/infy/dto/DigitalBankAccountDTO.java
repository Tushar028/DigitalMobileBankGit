package com.infy.dto;

public class DigitalBankAccountDTO {

	private String digitalBankingId;
	private Long mobileNumber;
	private Long accountNumber;
	private String accountType;
	
	public DigitalBankAccountDTO() {
		super();
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

	@Override
	public String toString() {
		return "DigitalBankAccountDTO [digitalBankingId=" + digitalBankingId + ", mobileNumber=" + mobileNumber
				+ ", accountNumber=" + accountNumber + ", accountType=" + accountType + "]";
	}

}
