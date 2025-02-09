package com.infy.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.AccountNoOTPDTO;
import com.infy.dto.AccountNumberDTO;
import com.infy.dto.BankAccountDTO;
import com.infy.dto.TransactionDTO;
import com.infy.exception.InfyMeMobileGlobalExceptionHandler;
import com.infy.service.AccountServiceImpl;
import com.infy.service.BankAccountServiceImpl;
import com.infy.service.DigitalBankAccountServiceImpl;
import com.infy.service.TransactionServiceImpl;

@RestController
@RequestMapping("/infyMobile")
@Validated
@CrossOrigin
public class Controller {

	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@Autowired
	BankAccountServiceImpl bankAccountServiceImpl;
	
	@Autowired
	DigitalBankAccountServiceImpl digitalBankAccountServiceImpl;
	
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	
	@PostMapping("/accounts")
	public ResponseEntity<String> createAccount(@Valid @RequestBody BankAccountDTO accountDTO) throws InfyMeMobileGlobalExceptionHandler{
		String result = accountServiceImpl.createAccount(accountDTO);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);  
	} 
	
	@GetMapping("/accounts/{mobileNo}")
	public ResponseEntity<List<BankAccountDTO>> listAccount(@PathVariable Long mobileNo) throws InfyMeMobileGlobalExceptionHandler{
		
		List<BankAccountDTO> lst = bankAccountServiceImpl.listAccount(mobileNo);
		return new ResponseEntity<List<BankAccountDTO>>(lst, HttpStatus.OK);
	}
	
	@PostMapping("/accounts/{mobileNo}")
	public ResponseEntity<String> linkAccount(@PathVariable Long mobileNo,@Valid @RequestBody AccountNumberDTO accountNo) throws InfyMeMobileGlobalExceptionHandler{
		String message = digitalBankAccountServiceImpl.linkAccount(mobileNo, accountNo.getAccountNo());
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@PostMapping("/accounts/acc/{mobileNo}")
	public ResponseEntity<String> linkAccount(@PathVariable Long mobileNo,@Valid @RequestBody AccountNoOTPDTO accOTP) throws InfyMeMobileGlobalExceptionHandler{

		String message = digitalBankAccountServiceImpl.linkAccount(mobileNo, accOTP.getAccountNo(), accOTP.getOtp());
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("/accounts/balance/{mobileNo}")
	public ResponseEntity<Double> checkBalance(@PathVariable Long mobileNo, @Valid @RequestParam Long accNo) throws InfyMeMobileGlobalExceptionHandler{
		
		Double balance = digitalBankAccountServiceImpl.checkBalance(mobileNo, accNo);
		return new ResponseEntity<Double>(balance, HttpStatus.OK);
	}
	
	@PutMapping("/accounts/fundtransfer")
	public ResponseEntity<String> fundTransfer(@Valid @RequestBody TransactionDTO transactionDTO) throws InfyMeMobileGlobalExceptionHandler{
		String message = transactionServiceImpl.fundTransfer(transactionDTO);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/accounts/statement/{mobileNo}")
	public ResponseEntity<List<TransactionDTO>> accountStatement(@PathVariable("mobileNo") Long mobileNo) throws InfyMeMobileGlobalExceptionHandler{
		
		List<TransactionDTO> lst = transactionServiceImpl.accountStatement(mobileNo);
		return new ResponseEntity<List<TransactionDTO>>(lst, HttpStatus.OK);
	}
}
