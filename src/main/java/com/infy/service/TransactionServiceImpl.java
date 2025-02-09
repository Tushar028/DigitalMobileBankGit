package com.infy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.TransactionDTO;
import com.infy.entity.BankAccount;
import com.infy.entity.Transaction;
import com.infy.exception.InfyMeMobileGlobalExceptionHandler;
import com.infy.repository.AccountRepository;
import com.infy.repository.DigitalBankAccountRepository;
import com.infy.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public String fundTransfer(TransactionDTO transactionDTO) throws InfyMeMobileGlobalExceptionHandler {
		
		BankAccount senderAccount = accountRepository.findByAccountNumber(transactionDTO.getSenderAccountNumber());
		BankAccount receiverAccount = accountRepository.findByAccountNumber(transactionDTO.getReceiverAccountNumber());
		
		if(senderAccount==null) {
			//Throw Exceptions
			throw new InfyMeMobileGlobalExceptionHandler(InfyMeMobileGlobalExceptionHandler.ExceptionConstants.INSUFFICIENT_FUNDS.toString());
		}
		
		if(receiverAccount==null) {
			//Throw Exceptions
			throw new InfyMeMobileGlobalExceptionHandler(InfyMeMobileGlobalExceptionHandler.ExceptionConstants.NO_USERS_FOUND.toString());
		}
		
		if(senderAccount.getBalance()<transactionDTO.getAmount()) {
			// Throw insufficient Balance
			throw new InfyMeMobileGlobalExceptionHandler(InfyMeMobileGlobalExceptionHandler.ExceptionConstants.INSUFFICIENT_FUNDS.toString());
		}
		
		
		senderAccount.setBalance(senderAccount.getBalance()-transactionDTO.getAmount());
		receiverAccount.setBalance(receiverAccount.getBalance()+transactionDTO.getAmount());
		
		
		
		// TODO Auto-generated method stub
		Transaction transaction = new Transaction();
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setModeOfTransaction(transactionDTO.getModeOfTransaction());
		transaction.setPaidFrom(transactionDTO.getPaidFrom());
		transaction.setPaidTo(transactionDTO.getPaidTo());
		transaction.setReceiverAccountNumber(transactionDTO.getReceiverAccountNumber());
		transaction.setRemarks(transactionDTO.getRemarks());
		transaction.setSenderAccountNumber(transactionDTO.getSenderAccountNumber());
		transaction.setTransactionDateTime(transactionDTO.getTransactionDateTime());
		transaction.setTransactionId(transactionDTO.getTransactionId());
		transactionRepository.save(transaction);
		return "Fund has Successfully Transferred to the AccountNO: "+transaction.getReceiverAccountNumber();
	}

	@Override
	public List<TransactionDTO> accountStatement(Long mobileNo) throws InfyMeMobileGlobalExceptionHandler{
		// TODO Auto-generated method stub
		List<Transaction> lst = transactionRepository.findAllByPaidToOrPaidFrom(mobileNo, mobileNo);
		
		if(lst.isEmpty()) {
			throw new InfyMeMobileGlobalExceptionHandler(InfyMeMobileGlobalExceptionHandler.ExceptionConstants.NO_ACTIVE_TRANSACTIONS.toString());
		}
		
		List<TransactionDTO> lstDTO = new ArrayList<>();
		for(Transaction transaction : lst) {
			TransactionDTO transactionDTO = new TransactionDTO();
			transactionDTO.setAmount(transaction.getAmount());
			transactionDTO.setModeOfTransaction(transaction.getModeOfTransaction());
			transactionDTO.setPaidFrom(transaction.getPaidFrom());
			transactionDTO.setPaidTo(transaction.getPaidTo());
			transactionDTO.setReceiverAccountNumber(transaction.getReceiverAccountNumber());
			transactionDTO.setRemarks(transaction.getRemarks());
			transactionDTO.setSenderAccountNumber(transaction.getSenderAccountNumber());
			transactionDTO.setTransactionDateTime(transaction.getTransactionDateTime());
			transactionDTO.setTransactionId(transaction.getTransactionId());
			lstDTO.add(transactionDTO);
		}
		
		
		return lstDTO;
	}

}
