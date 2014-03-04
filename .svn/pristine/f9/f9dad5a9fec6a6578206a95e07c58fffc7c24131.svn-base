package com.sjsu.GUITesting;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.sjsu.common.Constants;
import com.sjsu.Beans.GUITestConfig;
import com.sjsu.GUITesting.TestResult;
import com.sjsu.common.ProcessStreamReader;

public class TestExecutor {

	public enum Commands
	{
		EMULATOR_BASIC, EMULATOR, CHECK_EMULATOR, LIST_OF_EMULATORS,
		CHECK_ADB,RESTART_ADB,CHANGE_NETWORK_TYPE, 
		INSTALL_APK,
		INSTALL_WEBDRIVER, RUN_WEBDRIVER,FORWARD_PORT,
		COMPILE_JAVATESTFILE,RUN_JAVATESTFILE; 
	}

	public void runXMLProg()
	{
	   TestNG testng;
		try {
			
			testng = new TestNG();
			testng.setPreserveOrder(false);
			testng.setParallel("classes");
			testng.setThreadCount(3);
			testng.setVerbose(2);
			 
			// create a suite  
			XmlSuite suite = new XmlSuite();
			suite.setName("MSmartTest MobileWeb TestSuite");
 
			// create a test case for the suite
			XmlTest xmltest1 = new XmlTest(suite);
			xmltest1.setName("TestScriptA");
			xmltest1.setXmlClasses(Arrays.asList(new XmlClass("com.sjsu.tests.TestScriptA10Users")));
 
			XmlTest xmltest2 = new XmlTest(suite);
			xmltest2.setName("TestScriptB");
			xmltest2.setXmlClasses(Arrays.asList(new XmlClass("com.sjsu.tests.TestScriptB10Users")));
 
			
			// add a suite-file to the suite
			//suite.setSuiteFiles(Arrays.asList("/Users/macadmin/Dropbox/SJSU/MSSE\\ Project/CMPE295B_workspace/GUIWebTestProject/src/com/sjsu/tests/testng.xml"));
 
			// 1. To run with testng.xml file, uncomment this one, comment 2
			testng.setTestSuites(Arrays.asList("testng.xml"));
 
			// 2. to run with XmlSuite, uncomment this one, comment 1
			//testng.setXmlSuites(Arrays.asList(suite));
 
			testng.run();
 
			/***
			 * FAILED: googleSearch
org.openqa.selenium.WebDriverException: Session [b0ce1dad-2f6b-4ad7-9073-120c3fbe39d7] was terminated due to TIMEOUT
 
FAILED: googleSearch
java.lang.AssertionError: SJSU Search Test Failed expected [true] but found [false]
 
===============================================
    AndroidTest
    Tests run: 20, Failures: 10, Skips: 0
===============================================
 
===============================================
MSmartTest MobileWeb TestSuite
Total tests run: 20, Failures: 10, Skips: 0
===============================================
			 */

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void waitTimeInSeconds(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//App
	public void AppExecutor()
	{
		//Create new GUITestConfig object
		GUITestConfig testApkConfig = new GUITestConfig();

	}



	public String runWebTest(String strFileName, String networktype)
	{
		String strResponse = "";
		String answer = "";

		//Step 1: Launch Emulator
		// strResponse = executeCommands("EMULATOR_BASIC","Samsung-Galaxy-S-III","");


		//Setp 2: Get current emulator id
		//Step 3: Install web-driver apk file
		//Step 4: Run web-driver 
		//Step 5: Forward ports
		//Step 6: Compile Java Test File
		//For now assume its emulator-5554 ( default)

		strResponse = executeCommands("EMULATOR_BASIC","Samsung-Galaxy-S-III","");
		waitTimeInSeconds(3);
		strResponse = executeCommands("CHANGE_NETWORK_TYPE","5554","umts");
		waitTimeInSeconds(5);
		strResponse = executeCommands("INSTALL_WEBDRIVER","emulator-5554","");
		waitTimeInSeconds(3);
		strResponse = executeCommands("RUN_WEBDRIVER","emulator-5554","");
		waitTimeInSeconds(3);
		strResponse = executeCommands("FORWARD_PORT","emulator-5554","");
		waitTimeInSeconds(3);
		strResponse = executeCommands("COMPILE_JAVATESTFILE","","");
		waitTimeInSeconds(3);
		strResponse = executeCommands("RUN_JAVATESTFILE","","");

		return strResponse;
	}

	public String executeCommands(String strcommandType, String arg1, String arg2)
	{

		String strResponse = "";

		ProcessBuilder pb = null; 
		Process process = null;
		String strCommand = "";

		//Validations before hand 
		switch (Commands.valueOf(strcommandType))
		{
		case EMULATOR_BASIC: case EMULATOR: case CHECK_EMULATOR:

			if(arg1.isEmpty() || arg1 == null)
			{
				strResponse = "ERROR: Invalid Device Profile !";
				return strResponse;
			}

			break;

		case LIST_OF_EMULATORS:
			break;

		case CHECK_ADB:
			break;

		case RESTART_ADB:
			System.out.println("Restart ADB Server");
			break;

		case CHANGE_NETWORK_TYPE:
			if(arg1.isEmpty() || arg1 == null)
			{
				strResponse = "ERROR: Invalid emulator id!";
				return strResponse;
			}

			if( arg2.isEmpty() || arg2 == null)
			{
				strResponse = "ERROR: Invalid NETWORK TYPE !";
				return strResponse;
			}
			break;

		case INSTALL_WEBDRIVER: case RUN_WEBDRIVER: case FORWARD_PORT:

			if(!arg1.startsWith("emulator-"))
			{
				strResponse = "ERROR: Invalid emulator id!";
				return strResponse;
			}

			break;

		case COMPILE_JAVATESTFILE: case RUN_JAVATESTFILE:
			System.out.println("Compile Java TestScript File");

			//Check if arg1 is not empty and file exists
			if(arg1.isEmpty() || arg1 == null)
			{
				strResponse = "ERROR: Invalid Test File";
			}
			break;
		} 

		//Create command lines to execute
		switch (Commands.valueOf(strcommandType))
		{
		case EMULATOR_BASIC:  

			//get avd name from deviceProfile provided

			System.out.println("Launch Basic Emulator");
			strCommand = Constants.emulatorDirectory;
			strCommand = strCommand + "emulator -avd " + arg1;
			strCommand = strCommand + " -no-boot-anim -no-audio";

			break;

		case EMULATOR:
			System.out.println("Launch Emulator");
			strCommand = Constants.emulatorDirectory;
			strCommand = strCommand + "emulator -avd " + arg1;

			break;

		case CHECK_EMULATOR:
			System.out.println("Check Emulator");
			break;

		case LIST_OF_EMULATORS:
			System.out.println("Get List of Emulators");
			break;

		case CHECK_ADB:
			System.out.println("Ping ADB Server");
			break;

		case RESTART_ADB:
			System.out.println("Restart ADB Server");
			break;

		case CHANGE_NETWORK_TYPE:
			System.out.println("Change Network Type");
			//call bash script using program expect to telnet into emulator
			//example : "/usr/bin/expect /Users/macadmin/Dropbox/SJSU/expect_changeport.sh localhost 5554 umts >/dev/null";

			strCommand = "/usr/bin/expect /Users/macadmin/Dropbox/SJSU/expect_changeport.sh";
			strCommand = strCommand + " localhost " + arg1 + " " + arg2 + " >/dev/null";
			break;

		case INSTALL_WEBDRIVER:
			System.out.println("Install WebDriver");

			strCommand = Constants.adbDirectory; 
			strCommand = strCommand + "adb -s \"" + arg1 ;
			strCommand = strCommand + "\" install -r " + Constants.adbDirectory +"android-server-2.21.0.apk";
			break;

		case RUN_WEBDRIVER:
			System.out.println("Run WebDriver");

			strCommand = Constants.adbDirectory; 
			strCommand = strCommand + "adb -s \"" + arg1 ;
			strCommand = strCommand + "\" shell am start -a";
			strCommand = strCommand + " android.intent.action.MAIN -n org.openqa.selenium.android.app/.MainActivity";
			break;

		case FORWARD_PORT:
			System.out.println("Forward Port to 8080");

			strCommand = Constants.adbDirectory; 
			strCommand = strCommand + "adb -s \"" + arg1 ;
			strCommand = strCommand + "\" forward tcp:8080 tcp:8080";
			break;

		case COMPILE_JAVATESTFILE:
			System.out.println("Compile Java TestScript File");


			/* Unfortunately the only work around to get javac to work was to 
			 * explicitly specify the location of all the jar files individually
			 * otherwise it didn't recognize them even though they were in the libs folder
			 */

			strCommand = Constants.javacFolder + "javac ";

			strCommand = strCommand + " -cp \".:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand +"*.jar:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand + "selenium-java-2.31.0.jar:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand + "junit-4.11.jar:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand + "hamcrest-core-1.3.jar:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand + "selenium-server-standalone-2.32.0.jar\" ";
			strCommand = strCommand + Constants.GUIWebTestProject_src;
			strCommand = strCommand + " OneTest.java";

			break;

		case RUN_JAVATESTFILE:
			System.out.println("Run Java TestScript File");

			strCommand =  "java ";

			strCommand = strCommand + " -cp \".:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand +"*.jar:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand + "selenium-java-2.31.0.jar:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand + "junit-4.10.jar:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand + "hamcrest-core-1.3.jar:";
			strCommand = strCommand + Constants.GUIWebTestProject_lib;
			strCommand = strCommand + "selenium-server-standalone-2.32.0.jar:";
			strCommand = strCommand + Constants.junitFolder;
			strCommand = strCommand + "/junit-4.10.jar:" + Constants.junitFolder + ":";
			strCommand = strCommand + Constants.GUIWebTestProject_src;
			strCommand = strCommand + "\" org.junit.runner.JUnitCore ";
			strCommand = strCommand + " OneTest.java";

			break;

		default:
			System.out.println("INVALID ENTRY !!");
			return "INVALID ENTRY";
		} 

		//Execute the selected commands
		try{

			System.out.println("strCommand ="+strCommand);

			process = Runtime.getRuntime().exec(strCommand);


			switch (Commands.valueOf(strcommandType))
			{
			case EMULATOR_BASIC:  
				Thread.sleep(3000);
				break;
			case INSTALL_WEBDRIVER:
				Thread.sleep(3000);
			default:	

				Thread.sleep(5000); 
				BufferedReader stdInput = new BufferedReader(new 
						InputStreamReader(process.getInputStream()));

				BufferedReader stdError = new BufferedReader(new 
						InputStreamReader(process.getErrorStream()));
				/*
				// read the output from the command
				System.out.println("Here is the standard output of the command:\n");

				strResponse= stdInput.readLine();
			    while ((strResponse = stdInput.readLine()) != null) 
				{
					System.out.println(strResponse);
				}

				try {
					//process.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));  
				StringBuffer sb = new StringBuffer();  
				String line;  
				while ((line = br.readLine()) != null) {  
					sb.append(line).append("\n");  
				}  
				strResponse = sb.toString();

				System.out.println("Output of the process is " + strResponse);

				/*
			    switch (Commands.valueOf(strcommandType))
				{
			    case CHANGE_NETWORK_TYPE: 

			    	strResponse= stdInput.readLine();
				    while ((strResponse = stdInput.readLine()) != null) 
					{
						System.out.println(strResponse);
					}


			    	//telnet connection wasn't established then try again
			    	if(!strResponse.contains("Connected"))
			    	{
			    		strResponse = executeCommands("CHANGE_NETWORK_TYPE","");
			    	}
			    	break;
			    default:
			    	strResponse= stdInput.readLine();
				    while ((strResponse = stdInput.readLine()) != null) 
					{
						System.out.println(strResponse);
					}
				}*/

				// read any errors from the attempted command
				System.out.println("Here is the standard error of the command (if any):\n");
				while ((strResponse = stdError.readLine()) != null) {
					System.out.println(strResponse);
				}
				break;
			}

			waitTimeInSeconds(2);
			System.out.println("After command execution");

		} catch(Exception e) {
			e.printStackTrace();
		}

		//strResponse = answer;
		System.out.println("***************************");
		System.out.println("commandType:" + strcommandType);
		System.out.println("strResponse:"+ strResponse);


		return strResponse;
	}

	//Shahana
	/*
	public TestResult runTest(GUITestConfig testConf) {

		try {
			TestResult result = new TestResult();

			System.out.println("Launching Emulators");

			VirtualDeviceManager vdm = new VirtualDeviceManager();
			for (int i = 0; i < testConf.deviceProfileList.size(); i++) {
				vdm.launchDevice(testConf.deviceProfileList.get(i));

				Thread.sleep(30000);

				// Wait for all device to be ready
				int waitTime = 5*60*1000;
				long startTime = Calendar.getInstance().getTimeInMillis();

				ArrayList<String> deviceIdList;
				while (true) {

					System.out.println("Waiting for Emulators");
					deviceIdList = vdm.GetDeviceIds();
					if (deviceIdList.size() == 1) {
						break;
					}
					Thread.sleep(5000);

					long currTime = Calendar.getInstance().getTimeInMillis();
					if( (currTime - startTime) > waitTime)
					{
						result.Passed = false;
						result.ErrorDetails = "Timeout. Emulator not launched";
						return result;
					}
				}


				System.out.println("Installing App");
				AppExecutor ae = new AppExecutor();
				ae.UninstallApp(testConf.deviceProfileList.get(i).testAppPackageName,
						deviceIdList.get(0));

				ae.InstallApp(testConf.deviceProfileList.get(i).testAppPackageName, 
						testConf.deviceProfileList.get(i).testApp,
						deviceIdList.get(0));

				Thread.sleep(5000);

				System.out.println("Launching App");
				ae.ExecuteApp(testConf.deviceProfileList.get(i).testAppPackageName,
						deviceIdList.get(0));


				System.out.println("Unlocking the Emulator Screen" + deviceIdList.get(0));
				vdm.UnLockEmulator(deviceIdList.get(0));

				Thread.sleep(5000);

				System.out.println("Play back script");
				TestScriptExecutor tse = new TestScriptExecutor();
				result = tse.ExecuteScript(
						testConf.deviceProfileList.get(i).testScript,
						deviceIdList.get(0));


				vdm.StopDevice(deviceIdList.get(0));

				Thread.sleep(5000);
			}

			return result;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	 */
	public boolean InstallApp(String packageName, String testApp, String emulatorId) 
	{
		boolean result = false;

		String str = Constants.ADB_COMMAND_PATH + " -s " + emulatorId + " install "+testApp;


		System.out.println(str);

		int waitTime = 5*60*1000;
		long startTime = Calendar.getInstance().getTimeInMillis();

		try {
			while(true)
			{
				System.out.println("Installation of App is started for "+emulatorId);



				Process process = Runtime
						.getRuntime()
						.exec(str);

				try {
					process.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				String answer = ProcessStreamReader.GetInputStreamData(process);

				System.out.println("Output of the process is " + answer);


				if(answer.contains("Success") == false)
				{
					System.out.println("Installation of App is failed for "+emulatorId);

					if(answer.contains("INSTALL_FAILED_ALREADY_EXISTS"))
					{
						UninstallApp(packageName, emulatorId);
					}

					long currTime = Calendar.getInstance().getTimeInMillis();
					if( (currTime - startTime) > waitTime)
					{

						System.out.println("Timeout: Application is not able to install");
						return false;
					}

					continue;
				}
				else
				{
					System.out.println("Installation of App is Successful for "+emulatorId);
					break;
				}			

			}
			return true;

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean ExecuteApp(String testAppPackageName, String emulatorId) throws IOException 
	{
		boolean result = false;

		String str =  Constants.ADB_COMMAND_PATH + " -s " + emulatorId + " shell am start -a android.intent.action.Main -n  "+testAppPackageName+"/.MainActivity";
		Process process = Runtime.getRuntime().exec(str);

		try {
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String answer = ProcessStreamReader.GetErrorStreamData(process);

		if(answer.length() == 0)
		{
			System.out.println("Succeeded for "+emulatorId);
			return true;
		}
		else
		{
			System.out.println("Execute App Failed : " + answer);
			return false;
		}

	}

	public boolean UninstallApp(String testAppPackageName, String emulatorId) throws IOException 
	{
		System.out.println("Uninstall Started");
		boolean result = false;
		String str = Constants.ADB_COMMAND_PATH + " shell pm uninstall " + testAppPackageName;


		Process process = Runtime.getRuntime().exec(str);
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String answer = ProcessStreamReader.GetErrorStreamData(process);		
		System.out.println("Uninstall ErrorStream : " + answer);


		answer = ProcessStreamReader.GetInputStreamData(process);
		System.out.println("Uninstall InputStrean : " + answer);

		return true;
	}

	public TestResult ExecuteScript(String testScript, String emulatorId) 
	{
		//_testScript = testScript;

		TestResult result = new TestResult();

		String str = Constants.SIKULI_COMMAND_PATH + testScript;

		System.out.println(str);

		try {
			Process p = Runtime
					.getRuntime()
					.exec(str);
			try {
				p.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String answer = ProcessStreamReader.GetErrorStreamData(p);

			System.out.println("Output of the process is " + answer);

			if((answer == null) || (answer.length() == 0))
			{

				System.out.println("\n\nTest Run Successfully\n\n");
				result.Passed = true;
			}

			else
			{
				System.out.println("\n\nTest Run failed\n\n");

				String findString = "FindFailed: FindFailed:";

				int indexStart = answer.indexOf(findString);
				int indexEnd = answer.indexOf("\n", indexStart);

				String error = answer.substring(indexStart+findString.length(), indexEnd);

				error = error.replaceFirst(".png", "");
				System.out.println("Error message: " + error);

				result.Passed = false;
				result.ErrorDetails = error;

			}

			System.out.println("Play back script done");


		} catch (IOException e) {

			e.printStackTrace();
		}

		return  result;
	}

	//********** SELENIUM GRID ******************//

	public void runSeleniumGridTestsOnNodes(int numberofUsers) throws Exception
	{

		//luanchSeleniumHub();

		int freeport = getFreeSocketPort();
		installNodeAtPort(freeport, numberofUsers);
		//launch test script
		launchWebTestScript("", "");
		//get result

	}

	/*
	strResultsSummary = texec.runSeleniumGridTestsOnNodes(guitestProfileFilePathList[0],guitestProfileFilePathList[1],
			guitestProfileFileList[0],guitestProfileFileList[1], 
			guitestProfileFileUsersList[0],guitestProfileFileUsersList[1]);
	 */

	public String runSeleniumGridTestsOnNodes(String testProfileFilePath1, 
			String testProfileFilePath2, 
			String testProfileFile1, String testProfileFile2,
			int totalusersforProfile1, int totalusersforProfile2 ) throws Exception
			{
		String result = "";

		//FIRST LAUNCH SELENIUM GRID HUB
		System.out.println("LAUNCH SELENIUM GRID");
		
		launchSeleniumHub();

		int freeport1 = 0;
		int freeport2 = 0; 

		try {
			freeport1 = getFreeSocketPort();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("INSTALL NODES ON PORT" + freeport1);
		
		//LAUNCH A LINUX NODE WHICH IS CURRENTLY A HACK TO GET MULTIPLE PROCESSES TO RUN SIMULTANEOUSLY
		installNodeLinuxAtPort(freeport1, totalusersforProfile1);
		freeport2 = getFreeSocketPort();
		
		System.out.println("INSTALL NODES ON PORT" + freeport2);
		
		//LAUNCH WINDOWS HUB
		installNodeWindowsAtPort(freeport2, totalusersforProfile2);

		//Based on the number of users launch a specific XML file which already has the testscripts predefined
		//Currently a HACK
		//launchTestXML(String networkType, String testXMLFileName)
		/* PARAMETERS
		 * String testProfileFilePath1, 
			String testProfileFilePath2, 
			String testProfileFile1, String testProfileFile2,
			int totalusersforProfile1, int totalusersforProfile2
		 */

		String testXMLFileName = "";
		if(totalusersforProfile1 == 10 && totalusersforProfile2 == 10)
		{
			testXMLFileName = "testng1010.xml";
		}
		if(totalusersforProfile1 == 10 && totalusersforProfile2 == 50)
		{
			testXMLFileName = "testng1050.xml";
		}
		if(totalusersforProfile1 == 10 && totalusersforProfile2 == 100)
		{
			testXMLFileName = "testng10100.xml";
		}

		if(totalusersforProfile1 == 50 && totalusersforProfile2 == 10)
		{
			testXMLFileName = "testng5010.xml";
		}
		if(totalusersforProfile1 == 50 && totalusersforProfile2 == 50)
		{
			testXMLFileName = "testng5050.xml";
		}
		if(totalusersforProfile1 == 50 && totalusersforProfile2 == 100)
		{
			testXMLFileName = "testng50100.xml";
		}
		if(totalusersforProfile1 == 100 && totalusersforProfile2 == 10)
		{
			testXMLFileName = "testng5010.xml";
		}
		if(totalusersforProfile1 == 100 && totalusersforProfile2 == 50)
		{
			testXMLFileName = "testng5050.xml";
		}
		if(totalusersforProfile1 == 100 && totalusersforProfile2 == 100)
		{
			testXMLFileName = "testng100100.xml";
		}

		result = launchTestXML("3G", testXMLFileName);

		System.out.println("RESULT = " + result);
		
		Thread.sleep(5000);
		killSeleniumNodesAtPort(freeport2);
		
		Thread.sleep(2000);
		killSeleniumNodesAtPort(freeport2);

		
		return result;
			}

	//unfortunately this doesn't work
	public void killCurrentSeleniumGridHub()
	{
		String strCommand = "curl -d action=shutdown http://localhost:4444/lifecycle-manager";

		System.out.println("strCommand =  "+ strCommand);

		try {
			Process process = Runtime.getRuntime().exec(strCommand);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void killSeleniumNodesAtPort(int portnumber)
	{
		String strCommand = "kill -15 $( lsof -i:"+portnumber+ " -t )";

		System.out.println("strCommand =  "+ strCommand);

		try {
			Process process = Runtime.getRuntime().exec(strCommand);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean launchSeleniumHub()
	{

		//UNFORTUNATELY THE BELOW COMMAND DOESN'T WORK . HAVE DONE IT MANUALLY.
		//http://localhost:4444/lifecycle-manager?action=shutdown

		killCurrentSeleniumGridHub();

		String strCommand = Constants.javacFolder ;
		strCommand = strCommand + "java";
		strCommand = strCommand + " -jar ";
		strCommand = strCommand + Constants.GUIWebTestProject_src;
		strCommand = strCommand + "selenium-server-standalone-2.32.0.jar -role hub";

		System.out.println("strCommand =  "+ strCommand);

		try {
			Process process = Runtime.getRuntime().exec(strCommand);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public int getFreeSocketPort()
			throws IOException {
		ServerSocket server =
				new ServerSocket(0);
		int port = server.getLocalPort();

		System.out.println("PORT AVAILABLE = "+ port);

		server.close();
		return port;
	} 


	public void installNodeAtPort(int port, int numberOfUsers) throws IOException
	{

		String strCommand = Constants.javacFolder ;
		strCommand = strCommand + "java";
		strCommand = strCommand + " -jar ";
		strCommand = strCommand + Constants.GUIWebTestProject_src;
		strCommand = strCommand + "selenium-server-standalone-2.32.0.jar -role node -hub ";
		strCommand = strCommand + "http://localhost:4444/grid/register ";
		strCommand = strCommand + " -maxSession 1";
		strCommand = strCommand + " -port " + port ;
		strCommand = strCommand + " -browser \"browserName=android,version=4,platform=ANDROID,";
		strCommand = strCommand + "maxInstances=" + numberOfUsers +"\"";


		//java -jar selenium-server-standalone-2.32.0.jar  -role node -hub  -maxSession 1 -port 6000 -browser "browserName=android,version=4,platform=ANDROID,maxInstances=100"
		System.out.println("strCommand =  "+ strCommand);
		Process process ; 
		ProcessStreamReader p;
		try {
			process = Runtime.getRuntime().exec(strCommand);

			System.out.println(process.getOutputStream().toString());


			String answer = ProcessStreamReader.GetErrorStreamData(process);

			System.out.println("Output of the process is " + answer);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void installNodeWindowsAtPort(int port, int numberOfUsers) throws IOException
	{

		String strCommand = Constants.javacFolder ;
		strCommand = strCommand + "java";
		strCommand = strCommand + " -jar ";
		strCommand = strCommand + Constants.GUIWebTestProject_src;
		strCommand = strCommand + "selenium-server-standalone-2.32.0.jar -role node -hub ";
		strCommand = strCommand + "http://localhost:4444/grid/register ";
		strCommand = strCommand + " -maxSession 2";
		strCommand = strCommand + " -port " + port ;
		strCommand = strCommand + " -timeout 20 -browser \"browserName=firefox,version=4,platform=WINDOWS,";
		strCommand = strCommand + "maxInstances=" + numberOfUsers +"\"";


		//java -jar selenium-server-standalone-2.32.0.jar  -role node -hub  -maxSession 1 -port 6000 -browser "browserName=android,version=4,platform=ANDROID,maxInstances=100"
		System.out.println("strCommand =  "+ strCommand);
		Process process ; 
		ProcessStreamReader p;
		try {
			process = Runtime.getRuntime().exec(strCommand);

			System.out.println(process.getOutputStream().toString());


			String answer = ProcessStreamReader.GetErrorStreamData(process);

			System.out.println("Output of the process is " + answer);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void installNodeLinuxAtPort(int port, int numberOfUsers) throws IOException
	{

		String strCommand = Constants.javacFolder ;
		strCommand = strCommand + "java";
		strCommand = strCommand + " -jar ";
		strCommand = strCommand + Constants.GUIWebTestProject_src;
		strCommand = strCommand + "selenium-server-standalone-2.32.0.jar -role node -hub ";
		strCommand = strCommand + "http://localhost:4444/grid/register ";
		strCommand = strCommand + " -maxSession 2";
		strCommand = strCommand + " -port " + port ;
		strCommand = strCommand + " -timeout 20 -browser \"browserName=firefox,platform=LINUX,";
		strCommand = strCommand + "maxInstances=" + numberOfUsers +"\"";


		//java -jar selenium-server-standalone-2.32.0.jar  -role node -hub  -maxSession 1 -port 6000 -browser "browserName=android,version=4,platform=ANDROID,maxInstances=100"
		System.out.println("strCommand =  "+ strCommand);
		Process process ; 
		ProcessStreamReader p;
		try {
			process = Runtime.getRuntime().exec(strCommand);

			System.out.println(process.getOutputStream().toString());


			String answer = ProcessStreamReader.GetErrorStreamData(process);

			System.out.println("Output of the process is " + answer);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void launchWebTestScript(String networkType, String testscriptwithpath)
	{
		String strCommand = "";

		strCommand = Constants.javacFolder + "javac ";

		strCommand = strCommand + " -cp \".:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand +"*.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "selenium-java-2.31.0.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "junit-4.11.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "hamcrest-core-1.3.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "selenium-server-standalone-2.32.0.jar\" ";
		strCommand = strCommand + Constants.GUIWebTestProject_src;
		strCommand = strCommand + " GridTest.java";

		System.out.println("strCommand =  "+ strCommand);

		try {
			Process process = Runtime.getRuntime().exec(strCommand);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		strCommand = Constants.javacFolder +  "java ";

		strCommand = strCommand + " -cp \".:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand +"*.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "selenium-java-2.31.0.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "junit-4.10.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "hamcrest-core-1.3.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "selenium-server-standalone-2.32.0.jar:";
		strCommand = strCommand + Constants.junitFolder;
		strCommand = strCommand + "/junit-4.10.jar:" + Constants.junitFolder + ":";
		strCommand = strCommand + Constants.GUIWebTestProject_src;
		strCommand = strCommand + "\" org.junit.runner.JUnitCore ";
		strCommand = strCommand + " GridTest.java";

		System.out.println("strCommand =  "+ strCommand);

		try {
			Process process = Runtime.getRuntime().exec(strCommand);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String launchTestXML(String networkType, String testXMLFileName) throws IOException
	{
		String strResults = "";
		String strCommand = "";


		//java -cp ".:libs/*.jar:selenium-java-2.31.0.jar:junit-4.11.jar:hamcrest-core-1.3.jar:/Library/selenium-2.32.0/libs/testng-6.8.jar:/Library/selenium-2.32.0/libs/jcommander-1.29.jar:selenium-server-standalone-2.32.0.jar" org.testng.TestNG ../src/com/sjsu/tests/testng.xml

		// ".:/Library/selenium-2.32.0/libs/testng-6.8.jar:selenium-server-standalone-2.32.0.jar" org.testng.TestNG ../src/com/sjsu/tests/testng.xml


		strCommand = Constants.javacFolder +  "java ";

		strCommand = strCommand + " -cp \".:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand +"*.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "selenium-java-2.31.0.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "junit-4.10.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "hamcrest-core-1.3.jar:";
		strCommand = strCommand + Constants.GUIWebTestProject_lib;
		strCommand = strCommand + "selenium-server-standalone-2.32.0.jar:";
		strCommand = strCommand + Constants.junitFolder;
		strCommand = strCommand + "/junit-4.10.jar:" + Constants.junitFolder + ":";
		strCommand = strCommand + Constants.GUIWebTestProject_src;
		strCommand = strCommand + "\" org.junit.runner.JUnitCore ";
		strCommand = strCommand + " GridTest.java";

		System.out.println("strCommand =  "+ strCommand);
		Process process = null ; 
		try {
			process = Runtime.getRuntime().exec(strCommand);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));  
		StringBuffer sb = new StringBuffer();  
		String line, strResponse = null; 
		boolean firstOutputLine = false;
		
		int totallinestodisplay = 0 ;
		while ((line = br.readLine()) != null) {  
			
			if(line.toString().contains("********") && totallinestodisplay < 12 )
					{
						firstOutputLine = true;
						strResponse = line.toString() + "\n"; 
						totallinestodisplay++;
					}
			
			
			sb.append(line).append("\n");  
		}  
		// String strResponse = sb.toString();
	 
		System.out.println("Output of the process is " + strResponse);
		

		String answer = "";
		try {
			answer = ProcessStreamReader.GetErrorStreamData(process);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println(" ErrorStream : " + answer);


		try {
			answer = ProcessStreamReader.GetInputStreamData(process);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" InputStrean : " + answer);
 
		return strResults;
	}

	public void extrapolateHarFile()
	{

	}

	public void createWebResultSummary()
	{

	}



}
