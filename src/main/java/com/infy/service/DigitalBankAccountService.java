package com.infy.service;

import com.infy.exception.InfyMeMobileGlobalExceptionHandler;

public interface DigitalBankAccountService {

	public String linkAccount(Long mobileNo, Long accountNo) throws InfyMeMobileGlobalExceptionHandler;
	public String linkAccount(Long mobileNo, Long accountNo, Integer OTP) throws InfyMeMobileGlobalExceptionHandler;
	public Double checkBalance(Long mobileNo, Long accountNo) throws InfyMeMobileGlobalExceptionHandler;
	
}
