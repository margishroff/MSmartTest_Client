package com.sjsu.GUITesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TestController {

	public TestConfig testConf;

	public ArrayList<TestResult> runTest(String testGUIData) {
		System.out.println("Run Test started. guiData="+testGUIData);
		
		TestConfig tc = new TestConfig();
		tc.TestProfileName = "1";
		
		// data from GUI
		// DeviceProfileName1:Count1,DeviceProfileName2:Count2,DeviceProfileName3:Count3
		
		//String testGUIData = "Profile1:1,Profile2:1";
		String[] profileList = testGUIData.split(",");
		
		
		for(int i=0; i<profileList.length; i++)
		{
			String profile = profileList[i];
			String[] s2 = profile.split(":");
			String deviceProfileName = s2[0].trim();
			int deviceCount = Integer.parseInt(s2[1].trim());
		
			for(int j=0;j<deviceCount; j++)
			{
				DeviceConfig dc = DeviceConfig.getDeviceConfigFromFile(deviceProfileName);
					
				DeviceRunConfig drc = new DeviceRunConfig();
				drc.DeviceConfig = dc;
				
				tc.deviceProfileList.add(drc);
			}
			
		}
	
		
		TestController tCon = new TestController();
		ArrayList<TestResult> trList = tCon.runTest(tc);
	
		System.out.println("Run Test done.");
		
		for(int i =0; i< trList.size(); i++)
		{
			TestResult tr = trList.get(i);
			System.out.println("passed=" + tr.Passed+" error="+tr.ErrorDetails);
		}
		
		return trList;
	}
	
	private ArrayList<TestResult> runTest(TestConfig testConf) {

		ArrayList<TestResult> result = new ArrayList<TestResult>();
		try {
			

			System.out.println("Launching Emulators");
			
			

			VirtualDeviceManager vdm = new VirtualDeviceManager();
			
			
			int launchedCount = 0;
			for (int i = 0; i < testConf.deviceProfileList.size(); i++) {
				DeviceConfig dc = testConf.deviceProfileList.get(i).DeviceConfig;
				
				vdm.launchDevice(dc);
				launchedCount++;
			}
			Thread.sleep(30000);

			// Wait for all device to be ready
			int waitTime = 5 * 60 * 1000;
			boolean isRestarted = false;
			
			long startTime = Calendar.getInstance().getTimeInMillis();

			ArrayList<String> deviceIdList;
			while (true) {

				System.out.println("Waiting for Emulators");
				deviceIdList = vdm.GetDeviceIds();
				if (deviceIdList.size() >= launchedCount) {
					break;
				}
				Thread.sleep(5000);

				long currTime = Calendar.getInstance().getTimeInMillis();
				if ((currTime - startTime) > waitTime) {
					TestResult tr = new TestResult();
					tr.Passed = false;
					tr.ErrorDetails = "Timeout. All Emulator not launched";
					result.add(tr);
					return result;
				}
				
				if (isRestarted == false) {
					if ((currTime - startTime) > 100000) {
						vdm.RestartADBServer();
						isRestarted = true;
					}

				}
			}

			System.out.println("Installing App");
			AppExecutor ae = new AppExecutor();

			for (int i = 0; i < deviceIdList.size(); i++) {
				
				System.out.println("Installing App Emulator-"
						+ Integer.toString(i + 1) + " " + deviceIdList.get(i));
				ae.UninstallApp(
						testConf.deviceProfileList.get(i).DeviceConfig.testAppPackageName,
						deviceIdList.get(i));

				ae.InstallApp(
						testConf.deviceProfileList.get(i).DeviceConfig.testAppPackageName,
						testConf.deviceProfileList.get(i).DeviceConfig.testApp,
						deviceIdList.get(i));
			}

			Thread.sleep(5000);

			System.out.println("Launching App");
			for (int i = 0; i < deviceIdList.size(); i++) {
				System.out.println("Launching App Emulator-"
						+ Integer.toString(i + 1) + " " + deviceIdList.get(i));
				ae.ExecuteApp(
						testConf.deviceProfileList.get(i).DeviceConfig.testAppPackageName,
						deviceIdList.get(i));

			}

			for (int i = 0; i < deviceIdList.size(); i++) {
				System.out.println("Unlocking the Emulator Screen, Emulator-"
						+ Integer.toString(i + 1) + " " + deviceIdList.get(i));
				vdm.UnLockEmulator(deviceIdList.get(i));
			}

			Thread.sleep(5000);

			ArrayList<Thread> threads = new ArrayList<Thread>();
			ArrayList<TestScriptExecutor> scriptExecutors = new ArrayList<TestScriptExecutor>();
			for (int i = 0; i < deviceIdList.size(); i++) {
				System.out.println("Executing Test Script, Emulator-"
						+ Integer.toString(i + 1) + " " + deviceIdList.get(i));

				TestScriptExecutor tse = new TestScriptExecutor(
						testConf.deviceProfileList.get(i).DeviceConfig.testScriptPackageName,
						testConf.deviceProfileList.get(i).DeviceConfig.testScript,
						deviceIdList.get(i));

				Thread t = new Thread(tse);
				t.start();

				threads.add(t);
				scriptExecutors.add(tse);

				// result = tse.ExecuteScript(
				// testConf.deviceProfileList.get(i).testScript,
				// deviceIdList.get(i));

			}

			int running = 0;
			do {
				running = 0;
				for (Thread thread : threads) {
					if (thread.isAlive()) {
						running++;
					}
				}
				System.out.println("We have " + running
						+ " running Script Executor threads. ");
				Thread.sleep(2000);
			} while (running > 0);

			for (int i = 0; i < scriptExecutors.size(); i++) {
				TestScriptExecutor tse = scriptExecutors.get(i);
				result.add(tse.Result);
			}

			for (int i = 0; i < deviceIdList.size(); i++) {
				System.out.println("Stopping Device, Emulator-"
						+ Integer.toString(i + 1) + " " + deviceIdList.get(i));
				vdm.StopDevice(deviceIdList.get(i));
			}

			Thread.sleep(5000);

			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			TestResult tr = new TestResult();
			tr.Passed = false;
			tr.ErrorDetails = "Exception. "+e.getMessage();
			result.add(tr);
			return result;
		
		}
	}

	public void runWebTest()
	{
		webTest wTest = new webTest();
		wTest.runXMLProg();
	}
}
