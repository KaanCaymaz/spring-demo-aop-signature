package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.aopdemo.Account;

@Repository
public class AccountDAO {
	
	private String name;

	public String getName() {
		System.out.println(getClass()+" getName() ");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+" setName() ");
		this.name = name;
	}

	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + " DOING HIS WORK ");
	}
	
	public List<Account> findAccount(){
		
		List<Account> accounts = new ArrayList<Account>();
		Account a1= new Account("Kaan","Premium");
		Account a2= new Account("Hakan","Gold");
		Account a3= new Account("Çaðrý","Bronz");
		
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
				
		return accounts;
	}

}
