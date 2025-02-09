package com.infy;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.infy.dto.BankAccountDTO;
import com.infy.entity.BankAccount;
import com.infy.service.AccountServiceImpl;

@SpringBootTest
class DigitalBankCapstone1249346ApplicationTests {
	
	@Test
	public void testCreateAccount(){ 
		
		BankAccountDTO bankAccountDTO = new BankAccountDTO();
		bankAccountDTO.setAccountNumber(5689084325L);
		bankAccountDTO.setAccountType("Salary");
		bankAccountDTO.setBalance(12000D);
		bankAccountDTO.setBankName("Icici");
		bankAccountDTO.setIfscCode("infyic54");
		bankAccountDTO.setMobileNumber(5432988763L);
		bankAccountDTO.setOpeningDate(LocalDate.of(2024, 02, 28));
		
		AccountServiceImpl service = new AccountServiceImpl();
//		String s = service.createAccount(bankAccountDTO);
		Assert.assertEquals("Account Successfully Created!!", service.createAccount(bankAccountDTO));
		
		
	}
	
}
