package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningMainDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDao = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> accounts = accountDao.findAccount();
		
		
		System.out.println("Main Program: AfterReturning MainApp ==>");
		System.out.println("------------------");
		System.out.println(accounts);
		
		context.close();
	}

}
