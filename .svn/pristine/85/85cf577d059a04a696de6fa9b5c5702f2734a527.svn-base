package com.sjsu.LoadTesting;


import java.awt.Color;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import sun.io.CharToByteASCII;

import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.addon.timeline.Timeline;
import com.vaadin.data.Container;
import com.vaadin.data.Container.Indexed;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.highcharts.*;
import com.vaadin.highcharts.client.ui.*;
import com.vaadin.highcharts.client.*;

public class Load_chart extends  HighCharts  {

	
	public void create_chart(Panel panel)
	{
		Panel panel_chart=new Panel();
		panel_chart=panel;
	    panel_chart.setWidth("600px");
	    panel_chart.setHeight("600px");
		final Timeline timeline= new Timeline();
		timeline.setWidth("600px");
		timeline.setHeight("600px");
		panel_chart.addComponent(timeline);
		
		
		Container.Indexed graphDataSource = createGraphDataSource();
		//Container.Indexed markerDataSource = createMarkerDataSource();
		//Container.Indexed eventDataSource = createEventDataSource();
		// Add our data sources
		timeline.addGraphDataSource(graphDataSource,
		Timeline.PropertyId.TIMESTAMP, Timeline.PropertyId.VALUE);
		
		
		
		//configure timeline
				/*Container.Indexed GOOG=getData(150,0.2f,12);
		timeline.addGraphDataSource(AAPL);
		timeline.addGraphDataSource(GOOG);
		timeline.setGraphLegend(AAPL,"Apple");
		timeline.setGraphLegend(GOOG,"Google");
		timeline.setGraphOutlineColor(GOOG,new Color(50,200,50));*/
		timeline.setGraphOutlineThickness(3);
		timeline.setSizeFull();
			
	}

	public Container.Indexed createGraphDataSource(){
		// Create the container
		
		int [] data_thread={1,2,3,4,5,6,7,8,9,20};
		int[] data_response={10,20,30,70,60,89,67,60,77,90};
		
		Container.Indexed container = new IndexedContainer();
		// Add the required property ids, we use the default ones here
		container.addContainerProperty(Timeline.PropertyId.TIMESTAMP,
		Date.class, null);
		
		
		container.addContainerProperty(Timeline.PropertyId.VALUE,
		Integer.class, 0f);
		
		// Add some random data to the container
		/*Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date today = new Date();
		Random generator = new Random();*/
		/*while(cal.getTime().before(today)){
		// Create a point in time
		
		Item item = container.addItem(cal.getTime());
		// Set the timestamp property
		item.getItemProperty(Timeline.PropertyId.TIMESTAMP)
		.setValue(cal.getTime());
		// Set the value property
		item.getItemProperty(Timeline.PropertyId.VALUE)
		.setValue(generator.nextFloat());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		}*/
		
		for(int i=0;i<data_thread.length;i++)
			
		{
			// Create a point in time
			
			Item item = container.addItem(data_thread[i]);
			// Set the timestamp property
			item.getItemProperty(Timeline.PropertyId.TIMESTAMP)
			.setValue(data_thread[i]);
			
			// Set the value property
			item.getItemProperty(Timeline.PropertyId.VALUE)
			.setValue(data_response[i]);
			
			}
		return container;
		
			
	}
	
}
