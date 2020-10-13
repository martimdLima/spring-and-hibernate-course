package com.martimlima.springcourse.aopmodule.match.only.addaccount.method.customerdao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.martimlima.springcourse.aopmodule.match.only.addaccount.method.customerdao.dao.AccountDAO;
import com.martimlima.springcourse.aopmodule.match.only.addaccount.method.customerdao.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
				
		// call the business method
		theAccountDAO.addAccount();

		// call the membership business method
		theMembershipDAO.addAccount();
						
		// close the context
		context.close();
	}

}










