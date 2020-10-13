package com.martimlima.springcourse.aopmodule.pointcutdeclarations.dao;

import org.springframework.stereotype.Component;

import com.martimlima.springcourse.aopmodule.pointcutdeclarations.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}





