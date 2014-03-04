package com.sjsu.client;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.*;
/*
import org.testng.TestNG;
import org.testng.TestListenerAdapter;

*/
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;


public class webTest  {
 
	private int m_count = 0;
	
	public static TestNG testng;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long startTime ;

		double estimatedTime; 
		int inttotalpass = 0 ;
		int inttotalfail = 0;

		String strResultsSummary;
 
		startTime = System.nanoTime();  
	 
		runXMLProg();
		
		estimatedTime = System.nanoTime() - startTime;
		estimatedTime = estimatedTime/1000000000.0;

		System.out.println("Total Time: " +estimatedTime +" secs");
	}

	public static void runXMLProg()
	{
		try {
			testng = new TestNG();
			testng.setPreserveOrder(false);
			testng.setParallel("classes");
			testng.setThreadCount(3);
			testng.setVerbose(4);
			 
			// create a suite  
			XmlSuite suite = new XmlSuite();
			suite.setName("MSmartTest MobileWeb TestSuite");
 
			// create a test case for the suite
			XmlTest xmltest1 = new XmlTest(suite);
			xmltest1.setName("MultipleGmailLogIn");
			xmltest1.setXmlClasses(Arrays.asList(new XmlClass("com.sjsu.tests.MultipleGmailLogIn")));
 
			XmlTest xmltest2 = new XmlTest(suite);
			xmltest2.setName("AmazonShoppingCartTest");
			xmltest2.setXmlClasses(Arrays.asList(new XmlClass("com.sjsu.tests.AmazonShoppingCartTest")));
 
			testng.setTestSuites(Arrays.asList("testngB.xml"));
			testng.run();
 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
}
