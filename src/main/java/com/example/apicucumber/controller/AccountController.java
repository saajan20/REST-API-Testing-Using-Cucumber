package com.example.apicucumber.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apicucumber.model.Account;
import com.example.apicucumber.repository.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository repo;
	
	@GetMapping("/Account/{id}")
	public ResponseEntity<Optional<Account>> getDetails(@PathVariable int id)
	{
		
		Optional<Account> data=repo.findById(id);
		
		if(!data.isPresent())
		{
			
			return new ResponseEntity<Optional<Account>>(data,HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Optional<Account>>(data,HttpStatus.OK);
		
	}
	
	@PostMapping("/Account")
	public  ResponseEntity<Account> postDetails(@RequestBody Account data)
	{
		repo.save(data);
		return new ResponseEntity<Account>(data,HttpStatus.CREATED);
	}
	
	@PutMapping("/Account/{id}")
	public ResponseEntity<Account> updateDetails(@RequestBody Account data, @PathVariable int id)
	{
		repo.deleteById(id);
		repo.save(data);
		return new ResponseEntity<Account>(data,HttpStatus.OK);
	}
	
	@DeleteMapping("/Account/{id}")
	public  void deleteDetails(@PathVariable int id)
	{
		repo.deleteById(id);
		
	}

}
