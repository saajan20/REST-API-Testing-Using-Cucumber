 package com.example.apicucumber;


import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(
		  classes  =  ApiCucumberApplication.class, 
		  loader   =  SpringBootContextLoader.class)
		@WebAppConfiguration
		public class SpringIntegrationTest {
		 
		}