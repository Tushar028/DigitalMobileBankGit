package com.infy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.DigitalBankAccount;

public interface DigitalBankAccountRepository extends CrudRepository<DigitalBankAccount, String>{

	public List<DigitalBankAccount> findAllByMobileNumberAndAccountNumber(Long mobileNo, Long accNo);
}
