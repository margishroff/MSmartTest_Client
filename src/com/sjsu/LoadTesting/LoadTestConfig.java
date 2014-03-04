package com.sjsu.LoadTesting;
//Margi Shroff

public class LoadTestConfig {
	
	
	private String testSuite;
	private String testProfile;
	private String loadtestScript;
	private String scheduler;
	private String schedulerDate;
	
	
	//Getters 
	public String getTestSuite() {
		return testSuite;
	}
	public String getTestProfile() {
		return testProfile;
	}
	
	public String getloadTestScript() {
		return loadtestScript;
	}
	
	public String getscheduler()
	{
		return scheduler;
	}
	public String getschedulerDate()
	{
		return schedulerDate;
	}
	
	//Setters 
	//Replace null with empty string
	public void setLoadTestSuite(String testSuite) {
		
		if(testSuite == null)
		{ 
			this.testSuite = "";
		}
		else
		this.testSuite = testSuite;
	}
	public void setLoadTestProfile(String testProfile) {
		
		if(testProfile == null)
		{ 
			this.testProfile = "";
		}
		else
		this.testProfile = testProfile;
	}
		
	public void setLoadTestScript(String loadTestScript) {

		if(loadTestScript == null)
		{ 
			this.loadtestScript = "";
		}
		else
		this.loadtestScript = loadTestScript;
	}

	public void setLoadscheduer(String scheduler) {

		if(scheduler == null)
		{ 
			this.scheduler = "";
		}
		else
		this.scheduler = scheduler;
	}
	
	public void setLoadscheduerDate(String schedulerDate) {

		if(schedulerDate == null)
		{ 
			this.schedulerDate = "";
		}
		else
		this.schedulerDate = schedulerDate;
	}
}
