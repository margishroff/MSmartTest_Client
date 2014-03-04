package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import com.sjsu.Beans.GUITestConfig;
import com.sjsu.Exceptions.DirectoryDoesNotExist;
import com.sjsu.GUITesting.TestExecutor;
import com.sjsu.GUITesting.VirtualDeviceManager;
import org.junit.Test;

public class FileIO {


	//Create test suite
	@Test
	public void testcreateTestSuiteFolder() throws DirectoryDoesNotExist{
		
		System.out.println("*******************");
		
		String strtestSuite = "TestSuite 4-25-2013";

		VirtualDeviceManager dManager = new VirtualDeviceManager();

		boolean isFolderCreated = dManager.createTestSuiteFolder(strtestSuite);

		if(isFolderCreated)
		{
			System.out.print("Folder:" + strtestSuite + " created.");
		}
		else
		{
			System.out.print("Folder:" + strtestSuite + " NOT created.");
		}
	}


	//Create test profile txt file
	@Test
	public void testcreateTestProfileFile() throws DirectoryDoesNotExist, IOException{
		
		System.out.println("*******************");
		
		String strtestSuite = "TestSuite 4-25-2013";
		String strTestProfileFile = "Samsung 3g.txt";

		VirtualDeviceManager dManager = new VirtualDeviceManager();

		boolean isFolderCreated = dManager.createTestProfileFile(strtestSuite,strTestProfileFile);

		if(isFolderCreated)
		{
			System.out.print("Folder:" + strtestSuite + " created.");
		}
		else
		{
			System.out.print("Folder:" + strtestSuite + " NOT created.");
		}
	}

	@Test
	public void testWriteToTestProfileFile(){

		System.out.println("*******************");
		
		VirtualDeviceManager dManager = new VirtualDeviceManager();
		boolean isSuccess = false;

		//Native App 
		GUITestConfig testConfig =
				dManager.saveGUITestConfig("TestSuite 4-25-2013","Samsung 3g.txt","Native", 
						"Samsung-s-III", "3G","/Users/macadmin/Downloads/MSmartTest/User_PC/APK/testAPKFile.java",
						"com.company.BestApp","") ;

		try {
			isSuccess = dManager.writeToTestProfileFile(testConfig);

			if(isSuccess)
			{
				System.out.println("Test Profile successfully write to File");
			}
			else
			{
				System.out.println("Test Profile writeback FAILED !");
			}

		} catch (DirectoryDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Web App / Website

		GUITestConfig testConfig2 =
				dManager.saveGUITestConfig("TestSuite 4-25-2013","Samsung 1g.txt","Web", 
						"Samsung-s-III", "3G","",
						"","Margtest.java") ;

		try {
			isSuccess = dManager.writeToTestProfileFile( testConfig2);

			if(isSuccess)
			{
				System.out.println("Test Profile successfully write to File");

			}
			else
			{
				System.out.println("Test Profile writeback FAILED !");
			}

		} catch (DirectoryDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void readFromTestProfileFile() throws DirectoryDoesNotExist, IOException{

		System.out.println("*******************");
 
		VirtualDeviceManager dManager = new VirtualDeviceManager();
		GUITestConfig testconfig = dManager.readTestProfileFile("TestSuite 4-25-2013", "Samsung 1g.txt") ;
		
		System.out.println("--------");
		testconfig = dManager.readTestProfileFile("TestSuite 4-25-2013", "Samsung 3g.txt") ;
	}
	
	
	@Test
	public void testLoadingTestSuitesFromDisk() {

		//String strtestSuite = "TestSuite 4-23-2013";
		
		System.out.println("*******************");
		

		VirtualDeviceManager dManager = new VirtualDeviceManager();

		try {
			String[] strResult = dManager.LoadTestSuitesNamesFromDisk();

			if(strResult == null || strResult.length < 1 )
			{
				System.out.println("No profiles found");
			}
			else
			{
				for(int i=0; i< strResult.length; i++)
				{
					System.out.println( (i+1) + " => " + strResult[i]);
				}
				System.out.println("Total Profiles Found: " + strResult.length);
			}
		} catch (DirectoryDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testLoadingTestProfilesFromDisk() {
		
		System.out.println("*******************");
		

		String strtestSuite = "TestSuite 4-25-2013";

		VirtualDeviceManager dManager = new VirtualDeviceManager();

		try {
			String[] strResult = dManager.LoadTestProfilesNamesFromDisk(strtestSuite);

			if(strResult == null || strResult.length < 1 )
			{
				System.out.println("No profiles found");
			}
			else
			{
				for(int i=0; i< strResult.length; i++)
				{
					System.out.println( (i+1) + " => " + strResult[i]);
				}
				System.out.println("Total Profiles Found: " + strResult.length);
			}
		} catch (DirectoryDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
