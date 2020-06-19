package com.example.apicucumber.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	
	
	@Id
	private int account_id;
	private String account_type;
	private float account_balance;
	
	 public Account() {
				}
	 
	 
	public Account(int account_id, String account_type, float account_balance) {
		this.account_id = account_id;
		this.account_type = account_type;
		this.account_balance = account_balance;
	}
	
	
	public int getAccount_id() {
		return account_id;
	}
	
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	
	public String getAccount_type() {
		return account_type;
	}
	
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	public float getAccount_balance() {
		return account_balance;
	}
	
	public void setAccount_balance(float account_balance) {
		this.account_balance = account_balance;
	}
	

}
