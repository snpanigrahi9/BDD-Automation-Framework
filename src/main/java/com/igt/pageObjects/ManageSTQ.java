package com.igt.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.igt.base.TestSetup;
import com.igt.utility.UserActions;
import com.igt.utility.Util;

public class ManageSTQ extends TestSetup {

	public ManageSTQ(WebDriver d) {

		this.d = d;

	}

	public final By ManageSTQ = By.xpath(p.getProperty("ManageSTQ_locator"));
	public final By GDSQueueConfiguration = By.xpath(p.getProperty("GDSQueueConfiguration_locator"));
	public final By AddNew = By.xpath(p.getProperty("AddNewGDS_locator"));
	public final By GDSQueueName = By.xpath(p.getProperty("GDSQueueName_locator"));
	public final By gdstype = By.xpath(p.getProperty("GDSType_locator"));
	public final By pos = By.xpath(p.getProperty("ManageSTQSelectPOS_locator"));
	public final By posiata = By.xpath(p.getProperty("POSIataNumber_locator"));
	public final By pcc = By.xpath(p.getProperty("SelectPCC_locator"));
	public final By ththour = By.xpath(p.getProperty("TargetTHTHour_locator"));
	public final By thtminute = By.xpath(p.getProperty("TargetTHTMinute_locator"));
	public final By gdstask = By.xpath(p.getProperty("SelectGDSTask_locator"));
	public final By gdssubtask = By.xpath(p.getProperty("SelectGDSSubTask_locator"));
	public final By timezone = By.xpath(p.getProperty("TimeZone_locator"));
	public final By durationHour = By.xpath(p.getProperty("DurationHour_locator"));
	public final By durationMinute = By.xpath(p.getProperty("DurationMinute_locator"));
	public final By submit = By.xpath(p.getProperty("Submit_locator"));
	public final By dropdownclickelement = By.xpath(p.getProperty("Skill_locator"));
	public final By already = By.xpath(p.getProperty("AlreadyExistError_locator"));
	public final By cancel = By.xpath(p.getProperty("CancelButton_locator"));
	public final By testconnection = By.xpath(p.getProperty("TestConnection_locator"));
	public final By queueNo = By.xpath(p.getProperty("QueueNo_locator"));
	public final By queueCategory = By.xpath(p.getProperty("QueueCategory_locator"));

	public void clickManageSTQ() {

		UserActions.click(ManageSTQ);

	}

	public void clickGDSQueueConfiguration() {

		UserActions.click(GDSQueueConfiguration);

	}

	public void AddNew_Click() {

		UserActions.click(AddNew);

	}

	public void enterGDSQueueName() throws IOException {
		
		String GDSQueue = UserActions.getCellData("UserData","GdsQueue",2);
		UserActions.SetValue(GDSQueueName, GDSQueue);
	}

	public void selectGDS() throws IOException {
		
		//String GDSType = UserActions.getCellData("UserData","GdsType",2);
		String GDSType = UserActions.getNumericFormulaCellData("UserData","GdsType",2);
		int gIndex = Integer.parseInt(GDSType);
		//UserActions.SelectValue(gdstype, GDSType);
		UserActions.SelectValueByIndex(gdstype, gIndex);
	}

	public void selectPOS() throws IOException {

		String PosName = UserActions.getCellData("UserData","PosName_GDSQueue",2);
		//UserActions.SelectValue(pos, PosName);
		UserActions.SelectByOptionValue(pos, PosName);
	}

	public void selectPOSIata() throws IOException {

		//String PosIata = UserActions.getCellData("UserData","PosIata",2);
		String PosIata = UserActions.getNumericFormulaCellData("UserData","PosIata",2);
		UserActions.SelectValue(posiata, PosIata);
	}

	public void selectPcc() throws IOException {

		String Pcc = UserActions.getCellData("UserData","Pcc_GDSQueue",2);
		UserActions.SelectValue(pcc, Pcc);

	}

	public void selectTargetTHT() throws IOException {

		String Hour = UserActions.getCellData("UserData","Hour",2);
		String Minute = UserActions.getCellData("UserData","Minute",2);
		
		//String Hour = UserActions.getNumericFormulaCellData("UserData","Hour",2);
		//String Minute = UserActions.getNumericFormulaCellData("UserData","Minute",2);
		UserActions.SelectValue(ththour, Hour);
		UserActions.SelectValue(thtminute,Minute);

	}

	public void selectTaskAndSubTask() throws IOException {

		String Task = UserActions.getCellData("UserData","Task",2);
		String Subtask = UserActions.getCellData("UserData","Subtask",2);
		//UserActions.SelectValue(gdstask, Task);
		UserActions.SelectByOptionValue(gdstask, Task);
		//UserActions.SelectValue(gdssubtask, Subtask);
		UserActions.SelectByOptionValue(gdssubtask, Subtask);
	}

	public void selectDuration() throws IOException {

		String Dhour = UserActions.getCellData("UserData","Dhour",2);
		String Dminute = UserActions.getCellData("UserData","Dminute",2);
		//String Dhour = UserActions.getNumericFormulaCellData("UserData","Dhour",2);
		//String Dminute = UserActions.getNumericFormulaCellData("UserData","Dminute",2);
		UserActions.SelectValue(durationHour, Dhour);
		UserActions.SelectValue(durationMinute, Dminute);
	}

	public void selectTimeZone() throws IOException {

		String TimeZone = UserActions.getCellData("UserData","TimeZone",2);
		UserActions.SelectValue(timezone, TimeZone);
	}

	public void selectSkill() throws InterruptedException, IOException {
		
		String Skilltype = UserActions.getCellData("UserData","Skilltype",2);
		UserActions.clickDynamicXpathUsingScroll(Skilltype,dropdownclickelement);
	}

	public void clickTestConnection() throws IOException
	{
		if(UserActions.GetDisplayed(testconnection))
		{
			String qnumber = UserActions.getCellData("UserData","QueueNumber",2);
			String qcategory = UserActions.getCellData("UserData","QueueCategory",2);
			UserActions.SetValue(queueNo,qnumber );
			
			String value = UserActions.GetValue(queueCategory,"storeValue");
			
			
			//String s = UserActions.GetAttribute(queueCategory,"readonly");
			if(value.equals("C0"))
			{
			
				System.out.println("not editable");
				
			}
			else{
				
				UserActions.SetValue(queueCategory,qcategory);
				
			}
			
			UserActions.Click_JavaScript(testconnection);
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on TestConnection.");
			Util.TakeScreenShot(d, System.currentTimeMillis());
			
		}		
	}
	
	public void submit() {

		
		UserActions.click(submit);
		
		boolean isExist = UserActions.GetExistance(already);
		if(isExist)
		{
			UserActions.click(cancel);
		}

	}
	

}
