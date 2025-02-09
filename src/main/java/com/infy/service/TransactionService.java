package com.infy.service;

import java.util.List;

import com.infy.dto.TransactionDTO;
import com.infy.exception.InfyMeMobileGlobalExceptionHandler;

public interface TransactionService {

	public String fundTransfer(TransactionDTO transactionDTO) throws InfyMeMobileGlobalExceptionHandler;
	public List<TransactionDTO> accountStatement(Long mobileNo) throws InfyMeMobileGlobalExceptionHandler;
}
