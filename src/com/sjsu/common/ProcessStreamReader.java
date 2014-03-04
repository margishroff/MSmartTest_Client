package com.sjsu.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProcessStreamReader {
	
	public static String GetInputStreamData(Process p) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));  
		StringBuffer sb = new StringBuffer();  
		String line;  
		
		while ((line = br.readLine()) != null) {  
		  sb.append(line).append("\n");  
		}  
		
		return sb.toString();
	}

	public static String GetErrorStreamData(Process p) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));  
		StringBuffer sb = new StringBuffer();  
		String line;  
		
		while ((line = br.readLine()) != null) {  
		  sb.append(line).append("\n");  
		}  
		
		return sb.toString();
	}
}
