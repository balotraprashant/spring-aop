package com.hustlecrafts.aop.dao;

import org.springframework.stereotype.Component;

import com.hustlecrafts.aop.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account) {
		System.out.println(getClass() + "DOING MY DB WORK : ADDING AN ACCOUNT");
	}

}
