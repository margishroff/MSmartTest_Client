package com.sjsu.GUITesting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sjsu.common.Constants;
import com.sjsu.common.ProcessStreamReader;


public class TestScriptExecutor implements Runnable {
	
	String _testScriptPackageName;
	String _testScript;
	String _emulatorId;
	
	TestResult Result;
	
	public TestScriptExecutor(String testScriptPackageName, String testScript, String emulatorId)
	{
		_testScriptPackageName = testScriptPackageName;
		_testScript = testScript;
		_emulatorId = emulatorId;
	}
	
	private TestResult ExecuteScript(String testScriptPackageName, String testScript, String emulatorId) 
	{
		
		
		TestResult result = new TestResult();
	
	//	String testScriptPackageName = "com.testcalculator";
		AppExecutor ae = new AppExecutor();
		Boolean b = ae.InstallApp(testScriptPackageName, testScript, emulatorId);
		if( b == false)
		{
			result.Passed = false;
			result.ErrorDetails = "Install test Script Failed";
			return result;
		}
				
	//	String str = Constants.SIKULI_COMMAND_PATH + testScript;
		
		//String str = Constants.MONKEYRUNNER_COMMAND_PATH + testScript + " " + emulatorId ;

		// ./adb -s emulator-5556 shell am instrument -w com.testcalculator/android.test.InstrumentationTestRunner
		String str = Constants.ADB_COMMAND_PATH +" -s "+ emulatorId +
					" shell am instrument -w "+ testScriptPackageName+ "/android.test.InstrumentationTestRunner";

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
				

				
				String error = ProcessStreamReader.GetErrorStreamData(p);
				
				System.out.println("Test script ErrorStream : " + error);
				
				String input = ProcessStreamReader.GetInputStreamData(p);
				
				System.out.println("Test script InputStream : " + input);
				
				if(input.contains("OK"))
				{
				
					System.out.println("\n\nTest Run Successfully\n\n");
					result.Passed = true;
				}
				
				else
				{
					System.out.println("\n\nTest Run failed\n\n");
					
					//String findString = "FindFailed: FindFailed:";
					
//					int indexStart = answer.indexOf(findString);
//					int indexEnd = answer.indexOf("\n", indexStart);
//					
//					String error = answer.substring(indexStart+findString.length(), indexEnd);
//					
//					error = error.replaceFirst(".png", "");
//					System.out.println("Error message: " + error);
					
					result.Passed = false;
					result.ErrorDetails = "Test Failed.";
					
				}
				
				
				System.out.println("Play back script done");
			

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return  result;

	}



	public void run() {
		// TODO Auto-generated method stub
		Result = ExecuteScript(_testScriptPackageName, _testScript, _emulatorId);
	}
	 

}