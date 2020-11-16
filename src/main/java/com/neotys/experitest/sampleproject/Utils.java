package com.neotys.experitest.sampleproject;


public class Utils {
	/**
	 * fetches cloud name
	 * @param cloudName
	 * @return
	 * @throws Exception
	 */
	public static String fetchCloudName(String cloudName) throws Exception {
		//Verifies if cloudName is hardcoded, else loads from Maven properties 
		String finalCloudName = cloudName.equalsIgnoreCase("<<cloud name>>") ? System.getProperty("cloudName") : cloudName;
		//throw exceptions if cloudName isnt passed:
		if(finalCloudName == null || finalCloudName.equalsIgnoreCase("<<cloud name>>"))
			throw new Exception("Please replace <<cloud name>> with your headspin cloud name or pass it as maven properties: -DcloudName=<<cloud name>>");
		else
			return finalCloudName;
	}

	public static String fetchtoken(String token) throws Exception {
		//Verifies if cloudName is hardcoded, else loads from Maven properties
		String finalCloudName = token.equalsIgnoreCase("<<token>>") ? System.getProperty("token") : token;
		//throw exceptions if cloudName isnt passed:
		if(finalCloudName == null || finalCloudName.equalsIgnoreCase("<<token>>"))
			throw new Exception("Please replace <<token>> with your Experitest token or pass it as maven properties: -Dtoken=<<token>>");
		else
			return finalCloudName;
	}

	public static String fetchNetworkProfile(String token) throws Exception {
		//Verifies if cloudName is hardcoded, else loads from Maven properties
		String networkprofile = token.equalsIgnoreCase("<<networkprofile>>") ? System.getProperty("networkprofile") : token;
		//then "" cloudName isnt passed:
		if(networkprofile == null || networkprofile.equalsIgnoreCase("<<networkprofile>>"))
			return "";
		else
			return networkprofile;
	}

	public static String fetchuser(String user) throws Exception {
		//Verifies if cloudName is hardcoded, else loads from Maven properties
		String finalCloudName = user.equalsIgnoreCase("<<username>>") ? System.getProperty("username") : user;
		//throw exceptions if cloudName isnt passed:
		if(finalCloudName == null || finalCloudName.equalsIgnoreCase("<<username>>"))
			throw new Exception("Please replace <<username>> with your Experitest username or pass it as maven properties: -Dusername=<<username>>");
		else
			return finalCloudName;
	}

	public static String fetchProject(String project) throws Exception {
		//Verifies if cloudName is hardcoded, else loads from Maven properties
		String finalCloudName = project.equalsIgnoreCase("<<project>>") ? System.getProperty("project") : project;
		//throw exceptions if cloudName isnt passed:
		if(finalCloudName == null || finalCloudName.equalsIgnoreCase("<<project>>"))
			throw new Exception("Please replace <<project>> with your Experitest project or pass it as maven properties: -Dproject=<<project>>");
		else
			return finalCloudName;
	}

	public static String fetchpassword(String password) throws Exception {
		//Verifies if cloudName is hardcoded, else loads from Maven properties
		String finalCloudName = password.equalsIgnoreCase("<<password>>") ? System.getProperty("password") : password;
		//throw exceptions if cloudName isnt passed:
		if(finalCloudName == null || finalCloudName.equalsIgnoreCase("<<password>>"))
			throw new Exception("Please replace <<password>> with your Experitest password or pass it as maven properties: -Dpassword=<<password>>");
		else
			return finalCloudName;
	}

	public static String fetchApplicationURL(String applicationURL) throws Exception {
		//Verifies if cloudName is hardcoded, else loads from Maven properties
		String finalApplicationURL = applicationURL.equalsIgnoreCase("<<applicationURL>>") ? System.getProperty("applicationURL") : applicationURL;
		//throw exceptions if cloudName isnt passed:
		if(finalApplicationURL == null || finalApplicationURL.equalsIgnoreCase("<<applicationURL>>"))
			throw new Exception("Please replace <<applicationURL>> with the url of your konakart applcication or pass it as maven properties: -DapplicationURL=<<applicationURL>>");
		else
			return finalApplicationURL;
	}
}

