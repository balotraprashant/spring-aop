package com.hustlecrafts.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hustlecrafts.aop.pojo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account) {
		System.out.println(getClass() + "DOING MY DB WORK : ADDING AN ACCOUNT");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + "GOING TO SLEEP");
	}
	
	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account("Prashant", "Diamond"));
		accounts.add(new Account("John", "Silver"));
		accounts.add(new Account("Luka", "Gold"));
		return accounts;
	}
}
