package com.sjsu.GUITesting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import com.sjsu.common.Constants;
import com.sjsu.common.ProcessStreamReader;


public class AppExecutor {
	
	
	String testApp;
	
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
		String str = Constants.ADB_COMMAND_PATH + " -s "+ emulatorId + " shell pm uninstall " + testAppPackageName;


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
	
}
