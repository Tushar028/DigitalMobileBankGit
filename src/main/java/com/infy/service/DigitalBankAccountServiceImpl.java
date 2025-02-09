package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.entity.BankAccount;
import com.infy.entity.DigitalBankAccount;
import com.infy.exception.InfyMeMobileGlobalExceptionHandler;
import com.infy.generator.CustomGenerator;
import com.infy.repository.AccountRepository;
import com.infy.repository.DigitalBankAccountRepository;
import com.iny.otp.OTPGenerator;

@Service
public class DigitalBankAccountServiceImpl implements DigitalBankAccountService{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	DigitalBankAccountRepository digitalBankAccountRepository;
	

	@Override
	public String linkAccount(Long mobileNo, Long accountNo) throws InfyMeMobileGlobalExceptionHandler{
		// TODO Auto-generated method stub
		List<BankAccount> lst = accountRepository.findAllByMobileNumber(mobileNo);
		if(lst.isEmpty()) { 
			// Throw Error
			throw new InfyMeMobileGlobalExceptionHandler(InfyMeMobileGlobalExceptionHandler.ExceptionConstants.NO_ACCOUNTS_FOUND.toString());
		}
		DigitalBankAccount dba = new DigitalBankAccount();
		for(BankAccount bankAccount : lst) {
			
			if(bankAccount.getAccountNumber().equals(accountNo)) {
				dba.setAccountNumber(bankAccount.getAccountNumber());
				dba.setAccountType(bankAccount.getAccountType());
				dba.setMobileNumber(bankAccount.getMobileNumber());
				dba.setDigitalBankingId(CustomGenerator.digitalBankIdGenerator(mobileNo, accountNo));
				digitalBankAccountRepository.save(dba);
				return "successfully linked";
			}
		}
		 throw new InfyMeMobileGlobalExceptionHandler("NO_ACCOUNT_FOUND");
		
	}

	@Override
	public String linkAccount(Long mobileNo, Long accountNo, Integer OTP) throws InfyMeMobileGlobalExceptionHandler {
		// TODO Auto-generated method stub
		List<BankAccount> lst = accountRepository.findAllByMobileNumber(mobileNo);
		if(lst.isEmpty()) {
			// Throw Error
			throw new InfyMeMobileGlobalExceptionHandler("NO_ACCOUNT_FOUND");
		}
		DigitalBankAccount dba = new DigitalBankAccount();
		for(BankAccount bankAccount : lst) {
			
			if(bankAccount.getAccountNumber().equals(accountNo)) {
				dba.setAccountNumber(bankAccount.getAccountNumber());
				dba.setAccountType(bankAccount.getAccountType());
				dba.setMobileNumber(bankAccount.getMobileNumber());
				dba.setDigitalBankingId(CustomGenerator.digitalBankIdGenerator(mobileNo, accountNo));
				
				System.out.println(OTP);
				System.out.println(OTPGenerator.sendOTP());
				
				if(!OTP.equals(OTPGenerator.sendOTP()) ) {
					System.out.println("Not Eqaul");
					return "Wrong OTP";
					//throw new InfyMeMobileGlobalExceptionHandler("OTP_DOESNOT_MATCH");
				}
				System.out.println("Eqaul");

				digitalBankAccountRepository.save(dba);
				return "successfully linked";
			}
		}
		 throw new InfyMeMobileGlobalExceptionHandler("NO_ACCOUNT_FOUND");
		
		
	}

	@Override
	public Double checkBalance(Long mobileNo, Long accountNo) throws InfyMeMobileGlobalExceptionHandler {
		// TODO Auto-generated method stub
		List<DigitalBankAccount> lst = digitalBankAccountRepository.findAllByMobileNumberAndAccountNumber(mobileNo, accountNo);
		if(lst.isEmpty())
			throw new InfyMeMobileGlobalExceptionHandler(InfyMeMobileGlobalExceptionHandler.ExceptionConstants.NO_ACCOUNT_IS_LINKED.toString());
		BankAccount bankAccount = accountRepository.findByAccountNumber(accountNo);
		return bankAccount.getBalance();
	}

}
