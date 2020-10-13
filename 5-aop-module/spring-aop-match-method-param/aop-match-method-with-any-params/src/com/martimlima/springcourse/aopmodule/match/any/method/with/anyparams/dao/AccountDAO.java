package com.martimlima.springcourse.aopmodule.match.any.method.with.anyparams.dao;

import org.springframework.stereotype.Component;

import com.martimlima.springcourse.aopmodule.match.any.method.with.anyparams.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
}
