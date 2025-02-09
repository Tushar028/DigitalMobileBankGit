package com.infy.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.BankAccountDTO;
import com.infy.entity.BankAccount;
import com.infy.exception.InfyMeMobileGlobalExceptionHandler;
import com.infy.repository.AccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<BankAccountDTO> listAccount(Long mobileNo) throws InfyMeMobileGlobalExceptionHandler{
		// TODO Auto-generated method stub
		List<BankAccount> lst = accountRepository.findAllByMobileNumber(mobileNo);
		if(lst.isEmpty())
			throw new InfyMeMobileGlobalExceptionHandler(InfyMeMobileGlobalExceptionHandler.ExceptionConstants.NO_ACCOUNTS_FOUND.toString());
		List<BankAccountDTO> bankDTOList = new ArrayList<>();
		for(BankAccount bank : lst) {
			BankAccountDTO bankDto = new BankAccountDTO();
			bankDto.setAccountNumber(bank.getAccountNumber());
			bankDto.setAccountType(bank.getAccountType());
			bankDto.setBalance(bank.getBalance());
			bankDto.setBankName(bank.getBankName());
			bankDto.setIfscCode(bank.getIfscCode());
			bankDto.setMobileNumber(bank.getMobileNumber());
			bankDto.setOpeningDate(bank.getOpeningDate());
			
			bankDTOList.add(bankDto);
		}
		
		return bankDTOList;
		//return null;
	}

}
