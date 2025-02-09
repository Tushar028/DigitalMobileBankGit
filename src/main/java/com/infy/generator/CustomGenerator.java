package com.infy.generator;

public class CustomGenerator {
	public static String digitalBankIdGenerator(Long mobileNo, Long accountNo) {
		String mobNo = mobileNo.toString();
		String accNo = accountNo.toString();
		
		String id = mobNo.substring(0,4)+accNo.substring(accNo.length()-4)+"@infy.com";
		return id;
	}
}
