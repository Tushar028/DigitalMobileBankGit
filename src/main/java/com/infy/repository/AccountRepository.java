package com.infy.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.infy.entity.BankAccount;

public interface AccountRepository extends CrudRepository<BankAccount, Long>{

	public List<BankAccount> findAllByMobileNumber(Long mobileNo);
	public BankAccount findByAccountNumber(Long accNo);
}
