package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	private By username=By.id("email1");
	private By password=By.name("password1");
	private By loginButton=By.className("submit-btn");
	private By createNewUser=By.className("subLink");
	
	public boolean isLinkVisible() {
		boolean status=driver.findElement(createNewUser).isDisplayed();
		
		return status;
		
	}
	
	public HomePage loginToApplication(String uname,String pwd)
	
	{
	 driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		HomePage home=new HomePage(driver);
		return home;
		
		
	}
	
	

}
