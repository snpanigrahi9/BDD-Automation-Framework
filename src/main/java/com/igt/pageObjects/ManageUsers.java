package com.igt.pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.igt.base.TestSetup;
import com.igt.utility.UserActions;

public class ManageUsers extends TestSetup {
	
	
	public WebDriver d;

	public ManageUsers(WebDriver d) {
		this.d = d;

	}
	
	
	public final By manageuser = By.xpath(p.getProperty("ManageUsers_locator"));
	public final By manageagent = By.xpath(p.getProperty("ManageAgent_locator"));
	public final By Addnew = By.xpath(p.getProperty("AddNew_locator"));
	public final By FirstName = By.xpath(p.getProperty("FirstName_locator"));
	public final By LastName = By.xpath(p.getProperty("LastName_locator"));
	public final By email = By.xpath(p.getProperty("Email_locator"));
	public final By site = By.xpath(p.getProperty("SiteName_locator"));
	public final By sitepartition = By.xpath(p.getProperty("Site-Partition_locator"));
	public final By center = By.xpath(p.getProperty("CenterName_locator"));
	public final By startDate = By.xpath(p.getProperty("startdate_locator"));
	public final By contact = By.xpath(p.getProperty("Contact_locator"));
	public final By clickLanguage = By.xpath(p.getProperty("Languages_locator"));
	public final By clickSkills = By.xpath(p.getProperty("Skills_locator"));
	public final By closeDropdownLanguage = By.xpath(p.getProperty("CloseDropDown_locator"));
	public final By closeDropdownSkills = By.xpath(p.getProperty("CloseDropDownSkills_locator"));
	
	public final By submitall = By.xpath(p.getProperty("SubmitButton_locator"));
	public final By close = By.xpath(p.getProperty("CloseMsg_locator"));
	
	public final By managesupervisor = By.xpath(p.getProperty("ManageSupervisor_locator"));
	
	
	
	public void manageAgent() throws IOException, InterruptedException
	{
		int lastrowindex = UserActions.readExcelLastRowIndex("/IQD/TestData.xlsx");
		int rownum = 1;
		
		for (int i =1 ;i<=lastrowindex;i++)
		{
			UserActions.Click_JavaScript(manageuser);
			UserActions.Click_JavaScript(manageagent);
			UserActions.Click_JavaScript(Addnew);
			 UserActions.Wait_Sec();
			 String USER_FIRST_NM = UserActions.readExcel("/IQD/TestData.xlsx","AgentData", rownum,0);
			 String USER_LAST_NM =  UserActions.readExcel("/IQD/TestData.xlsx", "AgentData", rownum, 1);
			 String USER_EMAIL_ADDR =  UserActions.readExcel("/IQD/TestData.xlsx", "AgentData", rownum, 2);
			 String VNDR_NM =  UserActions.readExcel("/IQD/TestData.xlsx", "AgentData", rownum, 5);
			 String VNDR_PARTITN_NM =  UserActions.readExcel("/IQD/TestData.xlsx", "AgentData", rownum, 6);
			 String CENTER =  UserActions.readExcel("/IQD/TestData.xlsx", "AgentData", rownum, 8);
			 String Contact_No =  UserActions.readExcel("/IQD/TestData.xlsx", "AgentData", rownum, 3);
			 String languages =  UserActions.readExcel("/IQD/TestData.xlsx", "AgentData", rownum, 10);
			 String skills =  UserActions.readExcel("/IQD/TestData.xlsx", "AgentData", rownum, 9);
			 
			 UserActions.SetValue(FirstName, USER_FIRST_NM);
			 UserActions.SetValue(LastName, USER_LAST_NM);
			 UserActions.SetValue(email, USER_EMAIL_ADDR);
			 UserActions.SetValue(contact, Contact_No);
			 UserActions.SelectValue(site, VNDR_NM);
			 UserActions.SelectValue(sitepartition, VNDR_PARTITN_NM);
			 UserActions.SelectValue(center, CENTER);
			 UserActions.Click_JavaScript(startDate);
			 UserActions.click(clickLanguage);
			 UserActions.click_by_dynamicxpathLanguages(languages);
			 UserActions.Click_JavaScript(closeDropdownLanguage);
			 UserActions.click(clickSkills);
			 UserActions.click_by_dynamicxpathSkills(skills);
			 UserActions.Click_JavaScript(closeDropdownSkills);
			 UserActions.Click_JavaScript(submitall);
			 UserActions.Wait_Sec();
			 UserActions.Click_JavaScript(close);
			 UserActions.Wait_Sec();
			 rownum++;
			
			
		}
	}
		
		
		public void manageSupervisor() throws IOException, InterruptedException
		{
			int lastrowindex = UserActions.readExcelLastRowIndex("/IQD/TestData.xlsx");
			int rownum = 1;
			
			for (int i =1 ;i<=lastrowindex;i++)
			{
				boolean isExist = UserActions.GetDisplayed(managesupervisor);
				if(isExist)
				{
				UserActions.Click_JavaScript(managesupervisor);
				}
				else{	
					UserActions.Click_JavaScript(manageuser);
					UserActions.Click_JavaScript(managesupervisor);
				}
				UserActions.Click_JavaScript(Addnew);
				 UserActions.Wait_Sec();
				 String USER_FIRST_NM = UserActions.readExcel("/IQD/TestData.xlsx","SupervisorData", rownum,0);
				 String USER_LAST_NM =  UserActions.readExcel("/IQD/TestData.xlsx", "SupervisorData", rownum, 1);
				 String USER_EMAIL_ADDR =  UserActions.readExcel("/IQD/TestData.xlsx", "SupervisorData", rownum, 2);
				 String VNDR_NM =  UserActions.readExcel("/IQD/TestData.xlsx", "SupervisorData", rownum, 5);
				 String VNDR_PARTITN_NM =  UserActions.readExcel("/IQD/TestData.xlsx", "SupervisorData", rownum, 6);
				 String CENTER =  UserActions.readExcel("/IQD/TestData.xlsx", "SupervisorData", rownum, 8);
				 String Contact_No =  UserActions.readExcel("/IQD/TestData.xlsx", "SupervisorData", rownum, 3);
				 String languages =  UserActions.readExcel("/IQD/TestData.xlsx", "SupervisorData", rownum, 10);
				 String skills =  UserActions.readExcel("/IQD/TestData.xlsx", "SupervisorData", rownum, 9);
				 
				 UserActions.SetValue(FirstName, USER_FIRST_NM);
				 UserActions.SetValue(LastName, USER_LAST_NM);
				 UserActions.SetValue(email, USER_EMAIL_ADDR);
				 UserActions.SetValue(contact, Contact_No);
				 UserActions.SelectValue(site, VNDR_NM);
				 
				 UserActions.clickXpathUsingTextByJavaScript(VNDR_PARTITN_NM);
				 UserActions.Click_JavaScript(closeDropdownLanguage);
				// UserActions.SelectValue(sitepartition, VNDR_PARTITN_NM);
				 //UserActions.SelectValue(center, CENTER);
				 UserActions.clickXpathUsingTextByJavaScript(CENTER);
				 UserActions.Click_JavaScript(closeDropdownSkills);
				 
				 UserActions.Click_JavaScript(submitall);
				 UserActions.Wait_Sec();
				 rownum++;
				
				
			}
		}
		
	}


