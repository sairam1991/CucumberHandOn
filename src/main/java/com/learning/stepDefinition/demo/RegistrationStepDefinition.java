package com.learning.stepDefinition.demo;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class RegistrationStepDefinition {

	WebDriver driver;
	@Given("^User navigates to (.*com)$")
	public void NavigateTo(String url) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("^User fills details for facebook registration$")
	public void fillDetails(DataTable testData) throws Throwable {
		
		Map<String, String> testDatAsMap = testData.asMap(String.class, String.class);
		driver.findElement(By.name("firstname")).sendKeys(testDatAsMap.get("Firstname"));
		driver.findElement(By.name("lastname")).sendKeys(testDatAsMap.get("Surname"));
		driver.findElement(By.name("reg_email__")).sendKeys(testDatAsMap.get("Mobile"));

	}
	    
}
