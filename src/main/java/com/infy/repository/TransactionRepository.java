package com.infy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

	public List<Transaction> findAllByPaidToOrPaidFrom(Long mobNo, Long mobileNo);
}
