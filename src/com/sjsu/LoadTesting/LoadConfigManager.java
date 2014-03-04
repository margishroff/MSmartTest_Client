package com.sjsu.LoadTesting;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import com.sjsu.LoadTesting.LoadTestConfig;

public class LoadConfigManager {


	@SuppressWarnings("null")
	public boolean createTestSuiteFolder(String source) 
	{

		if (source.isEmpty()|| source == null)
		{
			return false;
		}
		else
		{
			source = Load_Constants.loadtestsuiteDirectorypath + "/"+ source;
			System.out.println("source = "+source);
		}

		File folder = new File(source);

		if(folder.exists() && !folder.canRead()) 
		{
			System.out.println("Access Right issue for source "+ source);
			return false;
		}

		if(folder.exists())
		{
			System.out.println("Folder already exists");
			return true;
		}
		else
		{
			System.out.println("Test Suite '" +folder.getAbsolutePath()+ "' does not exist. Creating...");

			boolean success = (new File(source)).mkdirs();
			if (success) {
				System.out.println("Directories: " + source + " created");
			}
			return true;
		}
	}


	public boolean createTestProfileFile(String testsuite, String fileName) 
	{

		String source  = null;

		if (testsuite.isEmpty()|| testsuite == null)
		{
			return false;
		}
		else
		{
			source = Load_Constants.loadtestsuiteDirectorypath + "/"+ testsuite + "/" + fileName;
			System.out.println("source = "+source);
		}

		File folder = new File(source);

		if(folder.exists() && !folder.canRead()) 
		{
			System.out.println("Access Right issue for source "+ source);
			return false;
		}

		if(folder.exists())
		{
			System.out.println("File already exists");
			return true;
		}
		else
		{
			System.out.println("Test Profile '" +folder.getAbsolutePath()+ "' does not exist. Creating...");

			boolean success = false;
			try {
				success = (new File(source)).createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (success) {
				System.out.println("File: " + source + " created");
			}
			return true;
		}
	}


	public boolean writeToTestProfileFile( LoadTestConfig loadtestConfig) throws  IOException
	{

		String source  = null;
		String Loadtestsuite=loadtestConfig.getTestSuite();
		
		String loadfileName = loadtestConfig.getTestProfile();

		if (Loadtestsuite.isEmpty()|| Loadtestsuite == null)
		{
			return false;
		}
		else
		{
			source = Load_Constants.loadtestsuiteDirectorypath + "/"+ Loadtestsuite + "/" + loadfileName;
					
			System.out.println("source = "+source);
		}

		File LoadtestProfileFile = new File(source);

		if(LoadtestProfileFile.exists() && !LoadtestProfileFile.canWrite()) 
		{
			System.out.println("Access Right issue for source "+ source);
			return false;
		}

		if(!LoadtestProfileFile.exists())
		{
			System.out.println("Test Profile '" +LoadtestProfileFile.getAbsolutePath()+ "' does not exist. Creating...");

			boolean success = (new File(source)).createNewFile();
			if (success) {
				System.out.println("File: " + source + " created");
			}
		}

		//Write to file
		try
		{
			System.out.println("Test Profile '" +LoadtestProfileFile.getAbsolutePath()+ "' exits. Writing to file ...");


			FileWriter fw = new FileWriter(LoadtestProfileFile);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Test Suite: " + loadtestConfig.getTestSuite()+ "\n");
			bw.write("Test Profile: " + loadtestConfig.getTestProfile()+ "\n");
			bw.write("Load TestScript: " + loadtestConfig.getloadTestScript());
			bw.write("Scheduler: " + loadtestConfig.getscheduler());
			bw.close();

			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	//Display testConfig in S.O.P
	public void printTestConfigDetails(LoadTestConfig loadtestConfig)
	{
		System.out.println("Test Suite: " + loadtestConfig.getTestSuite());
		System.out.println("Test Profile: " + loadtestConfig.getTestProfile());
		System.out.println("Load TestScript: " + loadtestConfig.getloadTestScript());
		System.out.println("Scheduler: " + loadtestConfig.getscheduler());

	}
	public LoadTestConfig readTestProfileFile(String testsuite, String fileName) throws  IOException
	{

		System.out.println("READING FROM FILE:");

		String source  = "";
		LoadTestConfig testConfig = null; 

		if (testsuite.isEmpty()|| testsuite == null)
		{
			return null;
		}
		else
		{
			source = Load_Constants.loadtestsuiteDirectorypath + "/"+ testsuite + "/" + fileName;
			System.out.println("source = "+source);
		}

		File testProfileFile = new File(source);

		if(testProfileFile.exists() && !testProfileFile.canRead()) 
		{
			System.out.println("Access Right issue for source "+ source);
			return null;
		}

		//If file doesn't exist return as action failed
		if(!testProfileFile.exists())
		{
			System.out.println("Test Profile '" +testProfileFile.getAbsolutePath()+ "' does not exist. FAILED.");
			return null;

		}

		System.out.println("Test Profile '" +testProfileFile.getAbsolutePath()+ "' exits. Reading file ...");

		try {

			BufferedReader br = new BufferedReader(new FileReader(source));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				testConfig = new LoadTestConfig();
				
				while (line != null) {
					if (line.trim().startsWith("Test Suite: ")) {
						testConfig.setLoadTestSuite(line.replace("Test Suite: ", "").trim().replaceAll("\0", " "));
						
					}
					if (line.trim().startsWith("Test Profile: ")) {
						
						testConfig.setLoadTestProfile(line.replace("Test Profile: ", "").trim().replaceAll("\0", " "));
					}
					if (line.trim().startsWith("Test Script: ")) {
						testConfig.setLoadTestScript(line.replace("Test Script: ", "").trim().replaceAll("\0", " "));
					}
					if (line.trim().startsWith("Scheduler: ")) {
						testConfig.setLoadscheduer(line.replace("Scheduler: ", "").trim().replaceAll("\0", " "));
					}
					if (line.trim().startsWith("Scheduler Date: ")) {
						testConfig.setLoadscheduerDate(line.replace("Schedule Date: ", "").trim().replaceAll("\0", " "));
					}
					
					//next line
					 line = br.readLine();
				}
				 
			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		//Display testConfig in S.O.P
		printTestConfigDetails(testConfig);
		return testConfig;
	}

	@SuppressWarnings("null")
	public String[] LoadTestSuitesNamesFromDisk() 
	{
		String[] listofTestSuites = null;
		String source = Constants.testSutieDirectory ;

		if (source.isEmpty()|| source == null)
		{
			return null;
		}
		else
		{
			//source = Constants.testSutieDirectory ;
			System.out.println("source ="+source);
		}
		File folder = new File(source);
		if (!folder.exists() || !folder.canRead()) 
		{
			System.out.println("Test Suite '" +folder.getAbsolutePath()+ "' does not exist or is not readable!");
			
		}

		if (folder.canRead()) 
		{
			if (folder.isDirectory()) 
			{
				//get all the test profiles from test suite directory and load the names 
				String[] listOfFiles = folder.list();

				if (listOfFiles != null) 
				{
					listofTestSuites = listOfFiles;
					for (int i = 0; i < listOfFiles.length; i++) 
					{
						System.out.println(listOfFiles[i]);
						if(listOfFiles[i] != null)
						{
							listofTestSuites[i] = listOfFiles[i].replace(".txt", "");
						}
					}
				}
			}
			else 
			{
				System.out.println("NO DIRECTORY NAMED '" + source + "' found");
			}
		}
		else
		{
			System.out.println("CANNOT READ DIRECTORY NAMED '" + source + "' ");
		}

		return listofTestSuites;
	}

	@SuppressWarnings("null")
	public String[] LoadTestProfilesNamesFromDisk(String source) 
	{
		String[] listofTestProfiles = null;

		if (source.isEmpty()|| source == null)
		{
			return null;
		}
		else
		{
			source = Constants.testSutieDirectory + "/"+ source;
			System.out.println("source ="+source);
		}
		File folder = new File(source);
		if (!folder.exists() || !folder.canRead()) 
		{
			System.out.println("Test Suite '" +folder.getAbsolutePath()+ "' does not exist or is not readable!");
			
		}

		if (folder.canRead()) 
		{
			if (folder.isDirectory()) 
			{
				//get all the test profiles from test suite directory and load the names 
				String[] listOfFiles = folder.list();

				if (listOfFiles != null) 
				{
					listofTestProfiles = listOfFiles;
					for (int i = 0; i < listOfFiles.length; i++) 
					{
						System.out.println(listOfFiles[i]);
						if(listOfFiles[i] != null)
						{
							listofTestProfiles[i] = listOfFiles[i].replace(".txt", "");
						}
					}
				}
			}
			else 
			{
				System.out.println("NO DIRECTORY NAMED '" + source + "' found");
			}
		}
		else
		{
			System.out.println("CANNOT READ DIRECTORY NAMED '" + source + "' ");
		}

		return listofTestProfiles;
	}
 


	//Create object to ease data transfer between classes
	public LoadTestConfig saveLoadTestConfig(String testSuite,String testProfile,String scheduler,String schedulerDate,String LoadScript) 
	{
		LoadTestConfig testConfig = new LoadTestConfig();

		testConfig.setLoadTestSuite(testSuite);
		testConfig.setLoadTestProfile(testProfile);
		testConfig.setLoadTestScript(LoadScript);
		testConfig.setLoadscheduerDate(schedulerDate);
		testConfig.setLoadscheduer(scheduler);
		
		
		System.out.println("Test Configurations created as LoadTestConfig object");

		return testConfig;
	}

	
		

	
}
