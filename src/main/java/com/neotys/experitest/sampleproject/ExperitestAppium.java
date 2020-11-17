package com.neotys.experitest.sampleproject;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.neotys.selenium.proxies.NLRemoteWebDriver;
import com.neotys.selenium.proxies.NLWebDriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class ExperitestAppium {
	AndroidDriver wb;
	NLRemoteWebDriver driver;
	String openSearch = "//*[@id=\'open-search\']";
	String searchField = "//*[@id=\'search-input-mobile\']";
	String searchSubmit = "//*[@id=\'search-button-mobile\']";

	String applicationURL="";
	String token="";
	String user="";
	String password="";
	String project="";
	@BeforeMethod @Before
	public void beforeMethod() throws Exception {
		//Replace <<cloud name>> with your perfecto cloud name (e.g. demo) or pass it as maven properties: -DcloudName=<<cloud name>>
		String cloudName = "<<cloud name>>";
		//Replace <<security token>> with your perfecto security token or pass it as maven properties: -DsecurityToken=<<SECURITY TOKEN>>  More info: https://developers.perfectomobile.com/display/PD/Generate+security+tokens
		String projectPath="";
		applicationURL="<<applicationURL>>";
		token="<<token>>";
		user="<<username>>";
		user=Utils.fetchuser(user);
		password="<<password>>";
		password=Utils.fetchpassword(password);

		token=Utils.fetchtoken(token);
		applicationURL=Utils.fetchApplicationURL(applicationURL);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("accessKey", token);
		capabilities.setCapability("testName", "NeoLoad KonaKart");
		capabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
		//capabilities.setBrowserName(MobileBrowserType.CHROMIUM);
		//capabilities.setCapability("username", user);
		//capabilities.setCapability("password", password);
		//capabilities.setCapability("projectName", project); //only required if your user has several projects assigned to it. Otherwise, exclude this capability.
		capabilities.setCapability("reportType", "video");
        capabilities.setCapability("generateReport", true);
		capabilities.setBrowserName(MobileBrowserType.CHROMIUM);



		boolean session=false;
		for(int i=0;i<5;i++)
		{
			try {
				session=createSession(capabilities,cloudName,projectPath);
				if(session)
					break;
			}
			catch (SessionNotCreatedException e)
			{
				e.printStackTrace();
			}
		}
		if(!session)
			throw new RuntimeException("Driver not created with capabilities: " + capabilities.toString());



	}

	public boolean createSession(Capabilities capabilities, String cloudname,String projectname) throws Exception {
		boolean result=false;
		wb = new AndroidDriver(new URL("https://" + Utils.fetchCloudName(cloudname)  + "wd/hub"), capabilities);
		driver = NLWebDriverFactory.newNLWebDriver(wb, "KonaKart Android", projectname);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("Session created, session id :"+driver.getSessionId());
		result=true;
		return result;
	}

	@Test @org.junit.Test
	public void appiumTest() throws Exception {

		//----enable vitals metrics---
		String networkProfile="<<networkprofile>>";
		networkProfile=Utils.fetchNetworkProfile(networkProfile);

		driver.executeScript("seetest:client.startPerformanceTransaction(\""+networkProfile+"\")");
		driver.startTransaction("Navigate to Konakart.com");
		driver.get("http://"+applicationURL);
		driver.stopTransaction();
		driver.executeScript("seetest:client.endPerformanceTransaction(\"Navigate to Konakart.com\")");


		driver.executeScript("seetest:client.startPerformanceTransaction(\""+networkProfile+"\")");
		driver.startTransaction("Search for Comptuer");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(openSearch)));
		WebElement element=driver.findElement(By.xpath((openSearch)));
		element.click();


		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchField)));
		element=driver.findElement(By.xpath((searchField)));
		element.clear();
		element.sendKeys("book");

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchSubmit)));
		element=driver.findElement(By.xpath((searchSubmit)));
		element.click();
		driver.stopTransaction();
		driver.executeScript("seetest:client.endPerformanceTransaction(\"Search for Comptuer\")");

		driver.executeScript("seetest:client.startPerformanceTransaction(\""+networkProfile+"\")");

		driver.startTransaction("Search for phone");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(openSearch)));
		element=driver.findElement(By.xpath((openSearch)));
		element.click();

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchField)));
		element=driver.findElement(By.xpath((searchField)));
		element.clear();
		element.sendKeys("phone");

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchSubmit)));
		element=driver.findElement(By.xpath((searchSubmit)));
		element.click();
		driver.stopTransaction();
		driver.executeScript("seetest:client.endPerformanceTransaction(\"Search for Phone\")");

		driver.executeScript("seetest:client.startPerformanceTransaction(\""+networkProfile+"\")");

		driver.startTransaction("Search for game");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(openSearch)));
		element=driver.findElement(By.xpath((openSearch)));
		element.click();

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchField)));
		element=driver.findElement(By.xpath((searchField)));
		element.clear();
		element.sendKeys("game");

      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchSubmit)));
		element=driver.findElement(By.xpath((searchSubmit)));
		element.click();
		driver.stopTransaction();

		driver.executeScript("seetest:client.endPerformanceTransaction(\"Search for Game\")");

		driver.close();
		driver.quit();
	}




}

