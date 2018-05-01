package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@AfterReturning(pointcut="execution( * com.luv2code.aopdemo.dao.*.*(..))",
					returning="result" )
	public void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> result) {
			
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n ==> Executing @AfterReturning on method: "+ method);
					
		System.out.println(result);
		
		upperCase(result);
		
		System.out.println(result);
		
	}

	private void upperCase(List<Account> result) {
		for(Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
		
	}

	@Before("execution(public void *.*(..))")
	public void logBeforeAdd(JoinPoint theJoinPoint) {
		System.out.println("\n==> Executing @Before advice");
		
		Signature signature =theJoinPoint.getSignature();
		System.out.println("signature:  "+ signature);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object part : args) {
			System.out.println(part);
			if(part instanceof Account) {
				Account acnt = (Account)part;
				System.out.println("Account name: "+acnt.getName());
				System.out.println("Account level: "+acnt.getLevel());
			}
			if(part instanceof  Boolean) {
				System.out.println("Vip: "+ part);
			}
			
		}
		
		}
}
