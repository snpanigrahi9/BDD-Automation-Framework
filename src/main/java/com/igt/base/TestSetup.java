package com.igt.base;


import java.io.File;
import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.igt.pageObjects.Dashboard;
import com.igt.pageObjects.Login;
import com.igt.pageObjects.ManageMasterData;
import com.igt.pageObjects.ManageSTQ;
import com.igt.pageObjects.ManageUsers;
import com.igt.pageObjects.Reports;
import com.igt.stepDefinition.IQDStepDefinition;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.Scenario;


public class TestSetup  {
	
	
	public static DesiredCapabilities caps;  
	public static WebDriver d;
	public static Properties p;
	public static Properties pro;
	public static WebDriverWait wait;
	public static Feature feature;
	public static Scenario scenario;
	public static Login log;
	public static ManageMasterData mmd;
	public static ManageSTQ ms;
	public static Reports rep;
	public static Dashboard db;
	public static ManageUsers mu;
	public static long l;
	public static XSSFWorkbook workbook=null;
	public static File file =null;
	public static FileInputStream fis=null;
	public static XSSFCell cell=null;
	public static XSSFSheet sheet=null;
	public static XSSFRow row=null;
	public static String Recipientlist ;
	public static IQDStepDefinition definition;
	public  static Faker faker;
    public static String filename=null;
}
