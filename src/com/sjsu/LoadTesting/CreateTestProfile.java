package com.sjsu.LoadTesting;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.omg.CORBA.SystemException;

public class CreateTestProfile {

	 public static void createtest(String Profilename,String Testscript,String schedule,String Schedule_date,String scriptpath ) {
	        //Writer writer = null;
	        	String ProfileName= Profilename;
	            String TestScript= Testscript;
	            String testscriptname=Profilename;
	            String Schedule=schedule;
	            String Schedule_Date=Schedule_date;
	            String testscriptpath=scriptpath;
	            
	            //String comma=",";
	            
	           String path="/Users/macadmin/Desktop/Rashmi/";
	           // String path=  Load_Constants.LoadTestProject_src;
	            String filename=path + testscriptname+ ".txt";
	            
	            String text1=" Profile Name :- " + ProfileName + "\r\n";
	            String text2 =" TestScript :- " + TestScript + "\r\n" ;
	            String text3 =" Schedule :- "+Schedule + "\r\n";
	            String text4 = " Schedule Date :- " + Schedule_Date+ "\r\n";
	            String text5=" TestScript Path :- " + scriptpath+ "\r\n";
	            String text6=text1+text2+text3+text4+text5;
	            String [] pathval={text1,text2,text3,text4+text5};
	            
	            try {
	            	
	            String nodeValue = text3;
	            String[] words = nodeValue.split(" ");

	            File file = new File(filename);
	            
	            FileWriter fw=new FileWriter(filename);
	           
	           fw.write(text6);
	          
	         fw.close();
	        } catch (IOException e) {
				
				e.printStackTrace();
			}
	 }	          

}