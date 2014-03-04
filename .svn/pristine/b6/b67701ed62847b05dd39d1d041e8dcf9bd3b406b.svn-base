package com.sjsu.tests;

import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.browsermob.proxy.ProxyServer;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonShoppingCartTest {

	private WebDriver driver;
	private String baseUrl;

	/*Margi - This is where the user's test script will be plugged in. So we can 
	   continue to use this same testscript */
	@Test (invocationCount = 10, threadPoolSize = 3)
	public void googleSearch() throws Exception {


		//String networktype, int numberOfUsers
		String strnetworktype = "gsm";
		int numberOfUsers = 10;

		if(numberOfUsers == 10)
		{
			//googleSearch10Users(networktype);
			//numberOfUsers = 20;
		}

		/*
		else if(numberOfUsers == 50)
		{
			googleSearch50Users(networktype);
		}
		else if(numberOfUsers == 10)
		{
			googleSearch100Users(networktype);
		}
		else
		{
			System.out.println("Invalid number of users");
		}
		 */
		/* 
		 * ANDROID NETWORK SPEED CAN BE SET USING BROWSERMOB-PROXY WITHIN
		 * FIREFOX
		 * 
		 * 	gsm	GSM/CSD	(Up: 14.4, down: 14.4)
		hscsd	HSCSD	(Up: 14.4, down: 43.2)
		gprs	GPRS	(Up: 40.0, down: 80.0)
		edge	EDGE/EGPRS	(Up: 118.4, down: 236.8)
		umts	UMTS/3G	(Up: 128.0, down: 1920.0)
		hsdpa	HSDPA	(Up: 348.0, down: 14400.0)
		full	no limit	(Up: 0.0, down: 0.0)

		 */

		int networktype = 6;

		double upstreamkps = 0;
		double downstreamkps = 0.0;

		switch (networktype) {
		case 1:  strnetworktype = "gsm";
		upstreamkps = 14.4 ;
		downstreamkps = 14.4;
		break;

		case 2:  strnetworktype = "hscsd";
		upstreamkps = 14.4 ;
		downstreamkps = 43.2;
		break;

		case 3:  strnetworktype = "gprs";
		upstreamkps = 40.0 ;
		downstreamkps = 80.0;
		break;

		case 4:  strnetworktype = "edge";
		upstreamkps = 118.4;
		downstreamkps = 236.8;
		break;

		case 5:  strnetworktype = "umts";
		upstreamkps = 128.0;
		downstreamkps = 1920.0;
		break;
		case 6:  strnetworktype = "hsdpa";
		upstreamkps = 348.0;
		downstreamkps = 14400.0;
		break;
		case 7:  strnetworktype = "full";
		break; // etc etc
		default: strnetworktype = "Invalid networktype";
		break;
		}

		ServerSocket checkportserver =
				new ServerSocket(0);

		int port = checkportserver.getLocalPort();

		System.out.println("PORT AVAILABLE FOR PROXY = "+ port);

		checkportserver.close();

		/* Browser Mob -proxy to handle network latency and speed emulation */
		// start the proxy
		//FIND FREE PORT FOR PROXY
		ProxyServer server = new ProxyServer(port);
		server.start();

		// get the Selenium proxy object
		Proxy proxy = server.seleniumProxy();

		server.setUpstreamKbps((long)upstreamkps);
		server.setDownstreamKbps((long)downstreamkps); 

		FirefoxProfile profile = new FirefoxProfile(); 
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (Android; Mobile; rv:13.0) Gecko/13.0 Firefox/13.0"); 

		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setPlatform(Platform.WINDOWS);
		capability.setCapability(FirefoxDriver.PROFILE, profile);

		System.out.println("BAD GOOGLE SEARCH MARGI EXECUTING...");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		baseUrl = "http://www.amazon.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);

		 

		driver.findElement(By.id("searchKeyword")).clear();
	    driver.findElement(By.id("searchKeyword")).sendKeys("strollers lightweight");
	    

 

		//Thread.sleep(2000);
		//Assert.assertTrue(driver.getPageSource().contains("The First Years Jet Stroller, Black/Green"),"Stroller not found");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    driver.findElement(By.cssSelector("button.a-button.a-button-dark")).click();
	    driver.findElement(By.cssSelector("span.productTitle")).click();
	    //Thread.sleep(2000);
	    
	    driver.findElement(By.id("add-to-cart-button")).click();
	   // driver.findElement(By.name("cartSubmit")).click();
		 
		driver.quit();
		 
		

	}
}