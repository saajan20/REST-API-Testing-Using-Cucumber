package com.example.apicucumber.definition;


import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.apicucumber.SpringIntegrationTest;
import com.example.apicucumber.model.Account;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class step_definition extends SpringIntegrationTest{
	
	RestTemplate rest=new RestTemplate();
	ResponseEntity<Account> check;
	
	
	@When("^the client calls GET /Account/(\\d+)$")
	public void get_details(int account_id) throws Throwable{
		System.out.println(account_id);
		check=rest.getForEntity("http://localhost:8081/Account/1837440", Account.class);
	}
	
	
	@Then("^the client receives GET status code of (\\d+)$")
	public void get_status(int code) {
	    System.out.println(code);
		Assertions.assertEquals(code, check.getStatusCodeValue());	
	}
	
	@When("^the client calls POST /Account$")
	public void post_details() throws Throwable{
		Account new_account= new Account(100,"savings",123.254f);
		check=rest.postForEntity("http://localhost:8081/Account",new_account,Account.class);
	}
	
	@Then("^the client receives POST status code of (\\d+)$")
	public void post_status(int code) {
	    System.out.println(code);
		Assertions.assertEquals(code, check.getStatusCodeValue());	
	}
	
	@When("^the client calls PUT /Account/1837440$")
	public void put_details() throws Throwable{
		
		Account new_account= new Account(1837440,"savings",5000);
		HttpEntity<Account> request = new HttpEntity<>(new_account); 
		check=rest.exchange("http://localhost:8081/Account/1837440", HttpMethod.PUT,request, Account.class);
	}
	
	@Then("^the client receives PUT status code of (\\d+)$")
	public void put_status(int code) {
	    System.out.println(code);
		Assertions.assertEquals(code, check.getStatusCodeValue());	
	}
	
	
	@When("^the client calls DELETE /Account/(\\d+)$")
	public void delete_details(int id) throws Throwable{
		
		rest.delete("http://localhost:8081/Account/1839540");
		check = rest.getForEntity("http://localhost:8081/Account/1839540", Account.class);
		
	}
	
	
	@Then("^the client receives DELETE status code of (\\d+)$")
	public void delete_status(int code) {
	    System.out.println(code);
		Assertions.assertEquals(code, check.getStatusCodeValue());	
	}
	
	
}
