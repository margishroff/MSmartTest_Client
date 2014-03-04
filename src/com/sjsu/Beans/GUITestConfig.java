package com.sjsu.Beans;
//Margi Shroff

public class GUITestConfig {
	
	
	private String testSuite;
	private String testProfile;
	private String appType; //EITHER APK OR WEB
	private String deviceProfile;
	private String networkSpeed;
	private String testApkPath;
	private String testApkPackageName;
	private String apkTestScript;
	private String webTestScript;
	private String testScript;
	
	public void test()
	{
		
	}
	
	public String getApkTestScript() {
		return apkTestScript;
	}
	public String getTestScript() {
		return testScript;
	}
	public void setApkTestScript(String apkTestScript) {
		this.apkTestScript = apkTestScript;
	}
	public void setTestScript(String testScript) {
		this.testScript = testScript;
	}
	//Getters 
	public String getTestSuite() {
		return testSuite;
	}
	public String getTestProfile() {
		return testProfile;
	}
	public String getAppType() {
		return appType;
	}
	public String getDeviceProfile() {
		return deviceProfile;
	}
	public String getNetworkSpeed() {
		return networkSpeed;
	}
	public String getTestApkPath() {
		return testApkPath;
	}
	public String getTestApkPackageName() {
		return testApkPackageName;
	}
	public String getWebTestScript() {
		return webTestScript;
	}
	
	//Setters 
	//Replace null with empty string
	public void setTestSuite(String testSuite) {
		
		if(testSuite == null)
		{ 
			this.testSuite = "";
		}
		else
		this.testSuite = testSuite;
	}
	public void setTestProfile(String testProfile) {
		
		if(testProfile == null)
		{ 
			this.testProfile = "";
		}
		else
		this.testProfile = testProfile;
	}
	public void setAppType(String appType){
		
		if(appType == null)
		{ 
			this.appType = "";
		}
		else
		this.appType = appType;
	}
	public void setDeviceProfile(String deviceProfile) {
		
		if(deviceProfile == null)
		{ 
			this.deviceProfile = "";
		}
		else
		this.deviceProfile = deviceProfile;
	}
	public void setNetworkSpeed(String networkSpeed) {
		
		if(networkSpeed == null)
		{ 
			this.networkSpeed = "";
		}
		else
		this.networkSpeed = networkSpeed;
	}
	public void setTestApkPath(String testApkPath) {	
		
		if(testApkPath == null)
		{ 
			this.testApkPath = "";
		}
		else
		this.testApkPath = testApkPath;
	}
	public void setTestApkPackageName(String testApkPackageName) {

		if(testApkPackageName == null)
		{ 
			this.testApkPackageName = "";
		}
		else
		this.testApkPackageName = testApkPackageName;
	}
	public void setWebTestScript(String webTestScript) {

		if(webTestScript == null)
		{ 
			this.webTestScript = "";
		}
		else
		this.webTestScript = webTestScript;
	}


}