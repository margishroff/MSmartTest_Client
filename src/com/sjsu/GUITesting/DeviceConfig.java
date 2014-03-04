package com.sjsu.GUITesting;

import java.io.BufferedReader;
import java.io.IOException;

import com.sjsu.common.Constants;
import com.vaadin.data.Buffered;

public class DeviceConfig {
	
	public String deviceProfileId;
	public String deviceType;
	public String networkType;
	public String testApp;
	public String testAppPackageName;
	public String testScript;
	public String testScriptPackageName;
	public Boolean IsApk;

	
	public static DeviceConfig getDeviceConfigFromFile(String name)
	{
		// Read from file;
		BufferedReader br = null;
		try 
		{
			java.io.FileReader fr = new java.io.FileReader(
					Constants.PROFILE_SAVE_PATH + "/" + name + ".txt");
			br = new BufferedReader(fr);

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				//sb.append("\n");
				line = br.readLine();
			}
			String data = sb.toString();

			
			String[] parts = data.split(",");
			DeviceConfig dc = new DeviceConfig();
			dc.deviceType = parts[0];
			dc.networkType = parts[1];
			dc.testScript = parts[2];
			dc.testApp = parts[3];
			dc.testScriptPackageName = parts[4];
			dc.testAppPackageName = parts[5];
				
			return dc;
			
		}
		catch(Exception e)
		{
			return null;
		}
		finally 
		{
			if( br != null)
			{
		        try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}

	    }
		
		// Temp
		/*
		if (name.equals("Profile1")) 
		{
			DeviceConfig dp1 = new DeviceConfig();
			dp1.deviceProfileId = "1";
			dp1.deviceType = "Emulator1";
			dp1.networkType = "2G";
			dp1.testApp = "/Users/shahi/TaaSTest/AndroidCalculator.apk";
			dp1.testAppPackageName = "com.calculator";
			// dp1.testScript = "/Users/shahi/Sikuli/myCal.sikuli";
			// dp1.testScript = "/Users/shahi/TestScripts/NewScript2.mr";
			dp1.testScript = "/Users/shahi/TaaSTest/AndroidCalculatorAPKTest.apk";
			dp1.testAppPackageName = "com.calculator";
			return dp1;
		} 
		else //if (name.equals("Profile2")) 
		{
			DeviceConfig dp2 = new DeviceConfig();
			dp2.deviceProfileId = "1";
			dp2.deviceType = "Emulator2";
			dp2.networkType = "2G";
			dp2.testApp = "/Users/shahi/TaaSTest/AndroidCalculator.apk";
			dp2.testAppPackageName = "com.calculator";
			// dp2.testScript = "/Users/shahi/Sikuli/myCal.sikuli";
			// dp2.testScript = "/Users/shahi/TestScripts/NewScript1.mr";
			dp2.testScript = "/Users/shahi/TaaSTest/AndroidCalculatorAPKTest2.apk";
			dp2.testAppPackageName = "com.calculator";
			return dp2;
		}
		*/
//		DeviceConfig dp3 = new DeviceConfig();
//		dp3.deviceProfileId ="1";
//		dp3.deviceType = "Emulator1";
//		dp3.networkType = "2G";
//		dp3.testApp = "/Users/shahi/TaaSTest/AndroidCalculator.apk";
//		dp3.testAppPackageName = "com.calculator";
//		dp3.testScript = "/Users/shahi/TaaSTest/AndroidCalculatorAPKTest.apk";
//		dp3.testAppPackageName = "com.calculator";
		
//		DeviceConfig dp4 = new DeviceConfig();
//		dp4.deviceProfileId ="1";
//		dp4.deviceType = "Emulator2";
//		dp4.networkType = "2G";
//		dp4.testApp = "/Users/shahi/TaaSTest/AndroidCalculator.apk";
//		dp4.testAppPackageName = "com.calculator";
//		dp4.testScript = "/Users/shahi/TaaSTest/AndroidCalculatorAPKTest.apk";
//		dp4.testAppPackageName = "com.calculator";
		

	}
	
	
	public boolean saveDeviceProfile(String deviceType, String networkType, long deviceCount, String deviceProfileId) 
	{
		boolean pass = true;
		return pass;
	}
}
