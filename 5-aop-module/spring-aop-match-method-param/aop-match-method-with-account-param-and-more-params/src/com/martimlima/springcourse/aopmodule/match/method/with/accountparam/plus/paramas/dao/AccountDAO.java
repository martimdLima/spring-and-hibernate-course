package com.martimlima.springcourse.aopmodule.match.method.with.accountparam.plus.paramas.dao;

import org.springframework.stereotype.Component;

import com.martimlima.springcourse.aopmodule.match.method.with.accountparam.plus.paramas.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
}
