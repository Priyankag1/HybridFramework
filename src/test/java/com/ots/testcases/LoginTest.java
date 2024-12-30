package com.ots.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ots.base.Base;
import com.ots.dataprovider.CustomDataProviders;
import com.ots.pages.HomePage;
import com.ots.pages.LoginPage;

public class LoginTest extends Base  {
	LoginPage login;
	
@Test(dataProvider="loginTestData",dataProviderClass=CustomDataProviders.class)
	public void validLogin(String username,String password)
	{

login=new LoginPage(driver);
HomePage home=login.loginToApplication(username, password);


	}
@Test
public void verifyNewLink() {
	login=new LoginPage(driver);
	Assert.assertTrue(login.isLinkVisible(),"Link Not Present ");
	
}

}
