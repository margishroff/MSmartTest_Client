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

import java.io.File;
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;

import org.testng.annotations.DataProvider;


public class MultipleGmailLogIn {


	private WebDriver driver;
	private String baseUrl;

	/*

	//Data provider definition
	@DataProvider(name = "DP")
	public Object[][] createData() throws Exception{
		Object[][] retObjArr=getExcelData("/Users/macadmin/Dropbox/SJSU/MSSE\\Project/CMPE295B_workspace/guitest_widget/src/com/sjsu/tests/TestData.xls","data", "Login");
		return(retObjArr);
	}

	//Excel API to read test data from excel workbook
	private String[][] getExcelData(String xlPath, String shtName, String tbName) throws Exception{
		String[][] tabArray=null;
		Workbook workbk = Workbook.getWorkbook(new File(xlPath));
		Sheet sht = workbk.getSheet(shtName);
		int sRow,sCol, eRow, eCol,ci,cj;
		Cell tableStart=sht.findCell(tbName);
		sRow=tableStart.getRow();
		sCol=tableStart.getColumn();
		Cell tableEnd= sht.findCell(tbName, sCol+1,sRow+1, 100, 64000, false);
		eRow=tableEnd.getRow();
		eCol=tableEnd.getColumn();
		System.out.println("startRow="+sRow+", endRow="+eRow+", " + "startCol="+sCol+", endCol="+eCol);
		tabArray=new String[eRow-sRow-1][eCol-sCol-1];
		ci=0;
		for (int i=sRow+1;i<eRow;i++,ci++){
			cj=0;
			for (int j=sCol+1;j<eCol;j++,cj++){
				tabArray[ci][cj]=sht.getCell(j,i).getContents();
			}
		}
		return(tabArray);
	}
	 */

	@DataProvider (name="TestData")

	public Object[][] createData() {

		return new Object[][] {
				{ "abc@gmail.com", "1234"},
				{ "optixlab@gmail.com", "kr1shna1" },
		};
	}

	/*Margi - This is where the user's test script will be plugged in. So we can 
	   continue to use this same testscript */
	@Test (invocationCount = 5, threadPoolSize = 3, dataProvider = "TestData",enabled=true)
	public void gmailLogin(String Usrname, String Pwd) throws Exception {

		System.out.println("Usrname = " + Usrname + " , Password = "+ Pwd);

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

		System.out.println("PORT AVAILABLE FOR PROXY = " + port);

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
		//capability.setCapability(CapabilityType.PROXY,proxy);

		System.out.println("GOOD GOOGLE SEARCH MARGI EXECUTING...");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		//WebDriver driver = new FirefoxDriver(profile);

		baseUrl = "http://www.gmail.com/";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(baseUrl);

		//Thread.sleep(4000);

		// Find the text input element by its name
		WebElement usernametext= driver.findElement(By.name("Email"));
		//Thread.sleep(4000);

		// Enter something to search for
		usernametext.sendKeys(Usrname);

		//Thread.sleep(7000);

		WebElement passwordtext = driver.findElement(By.name("Passwd"));
		passwordtext.sendKeys(Pwd); //put your actual password

		//Thread.sleep(5000);

		//Sign in button identification and click it
		WebElement signinbutton = driver.findElement(By.name("signIn"));
		signinbutton.click();

		//Thread.sleep(3000);

		Assert.assertTrue(driver.getPageSource().contains("Inbox"),"Gmail Login Failed");

		driver.findElement(By.id("bnc")).click();
		driver.findElement(By.id("body")).clear();
		driver.findElement(By.id("body")).sendKeys("hello");
		driver.findElement(By.id("save")).click();

		driver.quit();

	}
}