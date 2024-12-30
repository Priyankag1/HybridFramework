package com.ots.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ots.dataprovider.ConfigReader;

public class BrowserFactory {
	
	public static WebDriver startbrowswer(String browser, String appURL) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions opt=new ChromeOptions();
			if(ConfigReader.getproperty("headless").equalsIgnoreCase("true")) {
				System.out.println("test is running in headless mode");
			opt.addArguments("--headless=new");
			} 
			driver=new ChromeDriver(opt);
		
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		//dynamic value of waits for properties files via config reader and convert the String value to long as "ofSeconds will take long value but we have Stringvalue in properties file
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getproperty("implicitWait"))));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getproperty("pageLoad"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getproperty("scriptWait"))));
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}
	public static void closeBrowser(WebDriver driver){
		driver.quit();
		
	}

}
