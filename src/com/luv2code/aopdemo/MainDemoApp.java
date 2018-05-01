package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO=(AccountDAO) context.getBean("accountDAO",AccountDAO.class);
		
		Account account = new Account();
		account.setName("Kaan");
		account.setLevel("Premium");
		
		accountDAO.addAccount(account, true);
		accountDAO.setName("fsdfs");
		accountDAO.getName();
		
		context.close();
		
	}
}
