package com.example.apicucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources",glue = {"com.example.apicucumber.definition"})
public class CucumberTest {
	
}
