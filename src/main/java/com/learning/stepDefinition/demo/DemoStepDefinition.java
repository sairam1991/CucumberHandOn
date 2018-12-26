package com.learning.stepDefinition.demo;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoStepDefinition {
	
	WebDriver driver;
	
	@Given("^User is on (.*com)$")
	public void NavigateTo(String url) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("^User clicks on MyAccount link$")
	public void user_clicks_on_MyAccount_link() throws Throwable {

		WebElement MyAccountsLink = driver.findElement(By.className("account_icon"));
		MyAccountsLink.click();
	}

	@And("^User logs in using valid username(.*) and password (.*)$")
	public void Login(String username, String password) throws Throwable {

		driver.findElement(By.id("log")).sendKeys(username);
		driver.findElement(By.id("pwd")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}

	@Then("^User is taken to the my account page$")
	public void user_is_taken_to_the_my_account_page() throws Throwable {

		WebElement logoutButton = null;
		try{
			logoutButton = driver.findElement(By.id("account_logout"));
			System.out.println("User is successfully logged in and taken to Myaccounts page");
			driver.quit();
		}
		catch(Exception e){
			
			Assert.assertNotNull("Logout button is not present", logoutButton);
		}
	}
	
}
