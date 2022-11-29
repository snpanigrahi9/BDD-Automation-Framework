package com.igt.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.common.io.Files;
import com.igt.utility.UserActions;
import com.igt.utility.Util;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends TestSetup {
	

	
		
	  // @Before
	
		public static void loadProperty()
		{
			p = new Properties();
			pro = new Properties();
			try {
				
				File ff = new File(System.getProperty("user.dir")+"//src//main//resources//Config//config.properties");
				System.out.println(ff);
				FileInputStream f = new FileInputStream(ff);
				p.load(f);
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		} 
		
		
		public static void loadUserInput()
		{
			
			try {
				
			File file = new File(System.getProperty("user.dir")+"//src//main//resources//Config//UserInput.properties");
				
			System.out.println(file);
			FileInputStream input = new FileInputStream(file);
			pro.load(input);
			//pro.getProperty("url");
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	   
	 //  @Before
		public static void setWebdriver()
		{
			String b = pro.getProperty("browser");
			
			if(b.equalsIgnoreCase("chrome"))
			{
				
				String downloadFilepath = System.getProperty("user.dir")+"\\src\\main\\resources\\Reporting";
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFilepath);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("--test-type");
				options.addArguments("--disable-extensions");
				options.setAcceptInsecureCerts(true);
				options.addArguments("ignore-certificate-errors");
				WebDriverManager.chromedriver().setup();   
				d = new ChromeDriver(options);
				//d.get(pro.getProperty("url"));
				try{
				d.get(System.getProperty("url"));
				}
				catch(NullPointerException e)
				{
					
					d.get(System.getProperty("url"));
				}
				d.manage().window().maximize();
			}
			
			
			
			else if(b.equalsIgnoreCase("Headless"))
			{
			    ChromeOptions options = new ChromeOptions();
			    // options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
			    options.addArguments("window-size=1920,1080");
			    options.setHeadless(true);
			    options.setCapability("acceptInsecureCerts", true);
			    WebDriverManager.chromedriver().setup();
			    d = new ChromeDriver(options);
				//d.get(pro.getProperty("url"));
			    d.get(System.getProperty("url"));
				
				
			}
			else if(b.equalsIgnoreCase("firefox"))
			{
				FirefoxOptions option = new FirefoxOptions();
				option.setAcceptInsecureCerts(true);
				option.setCapability("marionette", true);
        		WebDriverManager.firefoxdriver().setup();
        		 d = new FirefoxDriver(option);
        		d.get(System.getProperty("url"));
        		d.manage().window().maximize(); 
			}
			else if(b.equalsIgnoreCase("internet explorer"))
			{
				
        		caps = new DesiredCapabilities();

               // caps.setCapability("nativeEvents",true);    
                //caps.setCapability("unexpectedAlertBehaviour", "accept");
                caps.setCapability("ignoreProtectedModeSettings", true);
                //caps.setCapability("disable-popup-blocking", true);
                 //caps.setCapability("enablePersistentHover", true);
              	caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS , true);
              	caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
              	caps.setCapability("ignoreZoomSetting", true);
              	caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, org.openqa.selenium.UnexpectedAlertBehaviour.IGNORE);
              	//System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//src//main//resources//Config//IEDriverServer.exe");
              	WebDriverManager.iedriver().setup();
              	d=new InternetExplorerDriver(caps);
				if(pro.getProperty("url").contains("https"))
				{
				//d.get(pro.getProperty("url"));
				  d.get(System.getProperty("url"));
				d.navigate().to("javascript:document.getElementById('overridelink').click()");
				d.manage().window().maximize(); 
				}
				else {
					d.get(System.getProperty("url"));
					d.manage().window().maximize(); 
					
				}
				
			}
			
	
			//d.manage().window().maximize(); 
			l = Long.parseLong(p.getProperty("implicitWait"));
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(l));
			
		}	    
     
		@Before
		public void keepScenario(Scenario scenario) {
			this.scenario = scenario;

		}
		public static WebDriver getWebdriver() {
			return d;

		}
	    
			
		@After
		public void afterScenario(Scenario scenario) {
			if (scenario.isFailed()) {
				
				//String screenshotName = scenario.getName().replaceAll(" ", "_");
				String screenshotName = scenario.getName() + "_Fail";
				
				try {
					//This takes a screenshot from the driver at save it to the specified location
					File sourcePath = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
					
					//Building up the destination path for the screenshot to save
					//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
					File destinationPath = new File(System.getProperty("user.dir")+"//FailedScreenShot//"+screenshotName+".png");
					
					//Copy taken screenshot from source location to destination location
					Files.copy(sourcePath, destinationPath);   
	
					
				} catch (IOException e) {
					
					e.printStackTrace();
				} 
			}
			
			else {
				

				
				
		}
				
				
				//Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
				
			  // d.quit();
			
		}  
		
		@AfterStep
		public void afterStep(Scenario scenario) throws IOException {
			
			scenario.attach(((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES),"image/png","screenshot");		
		}
		
}
	    
	    
	
