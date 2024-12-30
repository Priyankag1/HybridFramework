package com.ots.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ots.dataprovider.ConfigReader;
import com.ots.factory.BrowserFactory;

public class Base  {
	public WebDriver driver;
	 @BeforeMethod
	 public void setup() {
	driver= BrowserFactory.startbrowswer(ConfigReader.getproperty("browserName"), ConfigReader.getproperty("appURLQA")+"/login");
		 //driver.get("https://freelance-learn-automation.vercel.app/login");
		 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 
	 }
	 @AfterMethod
	 public void tearDown() { 
		BrowserFactory.closeBrowser(driver);
	 }

}
