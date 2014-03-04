package com.sjsu.LoadTesting;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gwt.dom.client.Style.TextDecoration;

public class ReadTestProfile {
	
		private String path;
		String readcontent="";
		 String arr[];
		 String[] fileread=null;
		 String[] Returnval=new String[5];		
		public ReadTestProfile(String file_path)
		{
			path=file_path;
			
		}
	
		public String[] openfile() 
		{	
			try{
				
		  // Open the file that is the first 
		  // command line parameter
		List<String[]> arrays = new ArrayList<String[]>(); //You need an array list of arrays since you dont know how many lines does the text file has
		  FileInputStream fstream = new FileInputStream(path);
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  String[] strarr;
		  
		  
		  //Read File Line By Line
		  while ((strLine = br.readLine()) != null)  
		  {
		  // Print the content on the console
			  strarr=strLine.split(":-");
		//  System.out.println (strarr[0]+" "+strarr[1]);
		  if(strarr[0].trim().equalsIgnoreCase("Profile Name"))
		  {
			  Returnval[0]=strarr[1].toString();
			 System.out.println("Profilename "+strarr[1]);
		  }
		  if(strarr[0].trim().equalsIgnoreCase("TestScript"))
		  {
			  Returnval[1]=strarr[1].toString();
			  System.out.println("TestScript "+strarr[1]);
		  }
		  if(strarr[0].trim().equalsIgnoreCase("Schedule"))
		  {
			  Returnval[2]=strarr[1].toString();
			  System.out.println("Schedule "+strarr[1]);
		  }
		  if(strarr[0].trim().equalsIgnoreCase("Schedule Date"))
		  {
			  Returnval[3]=strarr[1].toString();
			  System.out.println("Schedule Date "+strarr[1]);
		  }
		  if(strarr[0].trim().equalsIgnoreCase("TestScript Path"))
		  {
			  Returnval[4]=strarr[1].toString();
			  System.out.println("TestScript Path "+strarr[1]);
		  }
		 // readcontent=readcontent + strLine;
		  
		  }
		  
		    //Close the input stream
		  in.close();
		  
		    }
			catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
			return Returnval;
			
			//return Returnval;
		  }
	
		
		}

