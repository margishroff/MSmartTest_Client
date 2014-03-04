package com.sjsu.GUITesting;

public class TestResult {
	
	public String ErrorDetails;
	public boolean Passed;
	//private image screenShot;
	
	
	
	public void TestResult(boolean _passed, String _errorDetails)
	{
		Passed = _passed;
		ErrorDetails = _errorDetails;
	}
}
