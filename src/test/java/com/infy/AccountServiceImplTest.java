package com.infy;


import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assert;
import org.hibernate.engine.jdbc.batch.internal.BasicBatchKey;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.BankAccountDTO;
import com.infy.entity.BankAccount;
import com.infy.exception.InfyMeMobileGlobalExceptionHandler;
import com.infy.repository.AccountRepository;
import com.infy.service.AccountService;
import com.infy.service.AccountServiceImpl;
import com.infy.service.BankAccountServiceImpl;

@SpringBootTest
class AccountServiceImplTest {

	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@InjectMocks
	BankAccountServiceImpl bankServiceImpl;
	
	@Mock
	AccountRepository accRepo;
	//as accountRepository has the dependency on other class. like it has on database. we  have mocked it.
	
	@Test 
	public void createAccountTest(){
		BankAccountDTO bankDTO = getAccount();
		BankAccount bankAcc = new BankAccount();
		bankAcc.setAccountNumber(bankDTO.getAccountNumber());
		bankAcc.setAccountType(bankDTO.getAccountType());
		bankAcc.setBalance(bankDTO.getBalance());
		bankAcc.setBankName(bankDTO.getBankName());
		bankAcc.setIfscCode(bankDTO.getIfscCode());
		bankAcc.setMobileNumber(bankDTO.getMobileNumber());
		bankAcc.setOpeningDate(bankDTO.getOpeningDate());
		
		when(accRepo.save(any(BankAccount.class))).thenReturn(null);
		assertEquals("Account Successfully Created!!", accountServiceImpl.createAccount(bankDTO));
	}

	private BankAccountDTO getAccount() {
//		// TODO Auto-generated method stub
//		
//		// do the same with builder 
		BankAccountDTO bankDTO1 = new BankAccountDTO();
		bankDTO1.setAccountNumber(7848383929L);
		bankDTO1.setAccountType("salary");
		bankDTO1.setBalance(20000D);
		bankDTO1.setBankName("punjab national");
		bankDTO1.setIfscCode("pnb098789");
		bankDTO1.setMobileNumber(8798457623L);
		bankDTO1.setOpeningDate(LocalDate.of(2012, 8, 02));
		return bankDTO1;
	}

	@Test
	public void listAccountTest() throws InfyMeMobileGlobalExceptionHandler {
		
		when(accRepo.findAllByMobileNumber(9130848804L)).thenReturn(getAccList());
		List<BankAccount> ls = getAccList();
		List<BankAccountDTO> l = new ArrayList<>();
		for(BankAccount b : ls) {
			BankAccountDTO bDTO = new BankAccountDTO();
			bDTO.setAccountNumber(b.getAccountNumber());
			bDTO.setAccountType(b.getAccountType());
			bDTO.setBalance(b.getBalance());
			bDTO.setBankName(b.getBankName());
			bDTO.setIfscCode(b.getIfscCode());
			bDTO.setMobileNumber(b.getMobileNumber());
			bDTO.setOpeningDate(b.getOpeningDate());
			l.add(bDTO);
		}
//		
		assertEquals(l.get(0).getBankName(), "icici");
	}

	private List<BankAccount> getAccList() {
		// TODO Auto-generated method stub
		List<BankAccount> lst = new ArrayList<>();
		lst.add(new BankAccount(89765432150L,"icici", 300000D, "salary", "icici098", LocalDate.of(2024, 11, 28), 9130848804L)); 
		return lst;
	}

}
