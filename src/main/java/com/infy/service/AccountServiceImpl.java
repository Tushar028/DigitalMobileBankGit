package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.BankAccountDTO;
import com.infy.entity.BankAccount;
import com.infy.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public String createAccount(BankAccountDTO bankDTO) {
		// TODO Auto-generated method stub
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNumber(bankDTO.getAccountNumber());
		bankAccount.setAccountType(bankDTO.getAccountType()); 
		bankAccount.setBalance(bankDTO.getBalance());
		bankAccount.setBankName(bankDTO.getBankName());
		bankAccount.setIfscCode(bankDTO.getIfscCode());
		bankAccount.setMobileNumber(bankDTO.getMobileNumber());
		bankAccount.setOpeningDate(bankDTO.getOpeningDate());
		accountRepository.save(bankAccount); 
		return "Account Successfully Created!!"; 
	} 
 
}
