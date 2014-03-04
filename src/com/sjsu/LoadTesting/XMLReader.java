package com.sjsu.LoadTesting;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
public class XMLReader {
	/*
	ArrayList <String> arrays_thread = new ArrayList<String>();
	ArrayList <String> arrays_latency = new ArrayList<String>();
	ArrayList <String> arrays_response = new ArrayList<String>();*/
	
  @SuppressWarnings("null")
public String ReadXML() {
 
	   File fXmlFile = new File("/Library/apache-jmeter-2.9/bin/Result/JMeter_TestResult.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = dBuilder.parse(fXmlFile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
	 
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	 
		NodeList nList = doc.getElementsByTagName("httpSample");
	 
		System.out.println("----------------------------");
	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			Node nNode = nList.item(temp);
	 
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
				
				System.out.println("Thread Count : " + eElement.getAttribute("tn"));
				String thr=eElement.getAttribute("tn");
				System.out.println("String" + thr);
				//Thread_count[temp]=thr;
				Load_Constants.arrays_thread.add(thr);
				System.out.println("Array thread" + Load_Constants.arrays_thread);
				
				System.out.println("Latency : " + eElement.getAttribute("lt"));
				
				Load_Constants.arrays_latency.add(eElement.getAttribute("lt"));
				System.out.println("Array latency" + Load_Constants.arrays_latency);
				
				
				System.out.println("Response Time : " + eElement.getAttribute("t"));
				
				Load_Constants.arrays_response.add(eElement.getAttribute("t"));
				
				System.out.println("Array response" + Load_Constants.arrays_response);
				
				
			}
		}
		return null;
	    }
	  
  }
	  


