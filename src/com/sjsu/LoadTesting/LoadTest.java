package com.sjsu.LoadTesting;

import java.io.File;
import java.io.IOException;

import org.omg.CORBA.SystemException;

import com.sjsu.LoadTesting.Load_Constants;
public class LoadTest {

	public String runtest(String testpath) throws IOException{
	
		
		String testscriptpath=testpath;
		String path2=  testpath;
		String sucess="true";
		try{
			//Delete testresult file
			File file = new File("/Library/apache-jmeter-2.9/bin/Result/JMeter_TestResult.xml");
			 
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
		//Progress.setVisible(true);
		//String execute_command= Load_Constants.Load_testPath + " " + path2 + Load_Constants.Load_command;
			String execute_command= Load_Constants.Load_testPath + " " + path2 + Load_Constants.Load_command;
		System.out.println("Executing command " + execute_command);
		Runtime.getRuntime().exec(execute_command);
		
		//Thread.sleep(10000);
		
		}
		catch(SystemException e)
		{
			sucess="";
			e.printStackTrace();
		}
		return sucess;
		
		//String path1= "C:\\Users\\Rashmi\\Desktop\\apache-jmeter-2.8\\bin\\jmeter.bat -n -t";
		
		//String path2= Load_Constants.path + testpath;
		
		//String path3= " -l C:\\Users\\Rashmi\\Desktop\\apache-jmeter-2.8\\bin\\result_jairashmi.xml";
		
		//String execute_command= path1 + " " + path2 + path3;
		
		
	}
}
