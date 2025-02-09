package com.infy.dto;

import java.time.LocalDateTime;

public class TransactionDTO {

	private Integer transactionId;
	private String modeOfTransaction;
	private Long paidTo;
	private Long receiverAccountNumber;
	private Double amount;
	private LocalDateTime transactionDateTime;
	private String remarks;
	private Long paidFrom;
	private Long senderAccountNumber;
	
	public TransactionDTO() {
		super();
	}

	public TransactionDTO(Integer transactionId, String modeOfTransaction, Long paidTo, Long receiverAccountNumber,
			Double amount, LocalDateTime transactionDateTime, String remarks, Long paidFrom, Long senderAccountNumber) {
		super();
		this.transactionId = transactionId;
		this.modeOfTransaction = modeOfTransaction;
		this.paidTo = paidTo;
		this.receiverAccountNumber = receiverAccountNumber;
		this.amount = amount;
		this.transactionDateTime = transactionDateTime;
		this.remarks = remarks;
		this.paidFrom = paidFrom;
		this.senderAccountNumber = senderAccountNumber;
	}

	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", modeOfTransaction=" + modeOfTransaction
				+ ", paidTo=" + paidTo + ", receiverAccountNumber=" + receiverAccountNumber + ", amount=" + amount
				+ ", transactionDateTime=" + transactionDateTime + ", remarks=" + remarks + ", paidFrom=" + paidFrom
				+ ", senderAccountNumber=" + senderAccountNumber + "]";
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getModeOfTransaction() {
		return modeOfTransaction;
	}

	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}

	public Long getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(Long paidTo) {
		this.paidTo = paidTo;
	}

	public Long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(Long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getPaidFrom() {
		return paidFrom;
	}

	public void setPaidFrom(Long paidFrom) {
		this.paidFrom = paidFrom;
	}

	public Long getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(Long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}
	
	
}
