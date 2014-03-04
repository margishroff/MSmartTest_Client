package com.sjsu.client;
 
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class Worker extends Thread{
	
	ProgressIndicator  progressIndicator_com;
	TextField status;
	public Worker()
	{
		
		
	}
	public void start(ProgressIndicator ps,  TextField status)
	{
		progressIndicator_com = ps;	
		status=status;
		 
	    }

	    public void run () {
	    	double current = 0.0;
	        status.setValue("start");
	        while (true) {
	            
	            //Thread.sleep(50); // Sleep for 50 milliseconds
	               // Show that you have made some progress:
		            // grow the progress value until it reaches 1.0.
	               status.setValue("21");
	               current += 0.01;
		            if (current>1.0)
		            {	status.setValue("1");
		            progressIndicator_com.setValue(new Float(1.0));}
		            else
		            {
		            	status.setValue("else 2");
		            	progressIndicator_com.setValue(new Float(current));
		            
		            	status.setValue("" + ((int)(current*100)) + "% done");
		            }
		            
		            // After all the "work" has been done for a while,
		            // take a break.
		          if (current > 1.5) {
		                // Restore the state to initial.
		            	status.setValue("1.5");
		            	progressIndicator_com.setValue(new Float(0.0));
		            	progressIndicator_com.setVisible(true);
		            	
		                break;
		            }
	        }  
	}

}