package com.infy.service;

import java.util.List;

import com.infy.dto.BankAccountDTO;
import com.infy.exception.InfyMeMobileGlobalExceptionHandler;

public interface BankAccountService {

	public List<BankAccountDTO> listAccount(Long mobileNo) throws InfyMeMobileGlobalExceptionHandler;
}
