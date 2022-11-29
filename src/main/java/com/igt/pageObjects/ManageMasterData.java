package com.igt.pageObjects;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.github.javafaker.Faker;
import com.igt.base.TestSetup;
import com.igt.utility.UserActions;

import io.cucumber.java.en.When;

public class ManageMasterData extends TestSetup {

	String tcode;
	
	public ManageMasterData(WebDriver d) {
		this.d = d;

	}

	public final By MasterData = By.xpath(p.getProperty("ManageMasterData_locator"));
	public final By task = By.xpath(p.getProperty("Task_locator"));
	public final By Addnew = By.xpath(p.getProperty("AddNew_locator"));
	public final By taskcode = By.xpath(p.getProperty("TaskCode_locator"));
	public final By taskname = By.xpath(p.getProperty("TaskName_locator"));
	public final By submit = By.xpath(p.getProperty("Submit_locator"));
	public final By popupok = By.xpath(p.getProperty("TaskcreatedOK_locator"));
	public final By subtask = By.xpath(p.getProperty("Subtasks_locator"));
	public final By subtaskcode = By.xpath(p.getProperty("SubtaskCode_locator"));
	public final By subtaskname = By.xpath(p.getProperty("SubtaskName_locator"));
	public final By TaskSuccessText = By.xpath(p.getProperty("TaskSuccess_locator"));
	public final By action = By.xpath(p.getProperty("Action_locator"));
	public final By actioncode = By.xpath(p.getProperty("ActionCode_locator"));
	public final By actionname = By.xpath(p.getProperty("ActionName_locator"));
	public final By maptasksubtaskaction = By.xpath(p.getProperty("MapTaskSubtaskAction_locator"));
	public final By selecttask = By.xpath(p.getProperty("SelectTask_locator"));
	public final By mapsubtask = By.xpath(p.getProperty("MapSubtask_locator"));
	public final By selectsubtask = By.xpath(p.getProperty("SelectSubtask_locator"));
	public final By clickaction = By.xpath(p.getProperty("ClickAction_locator"));
	public final By pos = By.xpath(p.getProperty("Pos_locator"));
	public final By poscode = By.xpath(p.getProperty("PosCode_locator"));
	public final By posname = By.xpath(p.getProperty("PosName_locator"));
	public final By country = By.xpath(p.getProperty("SelectCountry_locator"));
	public final By brand = By.xpath(p.getProperty("Brand_locator"));
	public final By currency = By.xpath(p.getProperty("Currency_locator"));
	public final By langid = By.xpath(p.getProperty("ClickLangId_locator"));
	public final By addnewiata = By.xpath(p.getProperty("AddNewIata_locator"));
	public final By iatanumber = By.xpath(p.getProperty("IataNumber_locator"));
	public final By confirmiata = By.xpath(p.getProperty("ConfirmIata_locator"));
	public final By pccconfiguration = By.xpath(p.getProperty("PccConfiguration_locator"));
	public final By selectpos = By.xpath(p.getProperty("SelectPOS_locator"));
	public final By selectgds = By.xpath(p.getProperty("SelectGDS_locator"));
	public final By pcc = By.xpath(p.getProperty("Pcc_locator"));
	public final By subaction = By.xpath(p.getProperty("SubAction_locator"));
	public final By subactionCode = By.xpath(p.getProperty("SubActionCode_locator"));
	public final By subactionName = By.xpath(p.getProperty("SubActionName_locator"));
	public final By agentskills = By.xpath(p.getProperty("AgentSkills_locator"));
	public final By agentskillcode = By.xpath(p.getProperty("AgentSkillCode_locator"));
	public final By agentskillname = By.xpath(p.getProperty("AgentSkillName_locator"));
	public final By languageskills = By.xpath(p.getProperty("LanguageSkills_locator"));
	public final By languagecode = By.xpath(p.getProperty("LanguageCode_locator"));
	public final By languagename = By.xpath(p.getProperty("LanguageName_locator"));
	public final By already = By.xpath(p.getProperty("AlreadyError_locator"));
	public final By cancel = By.xpath(p.getProperty("CancelButton_locator"));
	public final By brands = By.xpath(p.getProperty("BrandsMenu_locator"));
	public final By brandcode = By.xpath(p.getProperty("BrandCode_locator"));
	public final By brandname = By.xpath(p.getProperty("BrandName_locator"));
	public final By countries = By.xpath(p.getProperty("Countries_locator"));
	public final By regionname = By.xpath(p.getProperty("RegionName_locator"));
	public final By countrycode = By.xpath(p.getProperty("CountryCode_locator"));
	public final By countryname = By.xpath(p.getProperty("CountryName_locator"));
	
	
	
	public void ClickManageMasterData() {

		UserActions.Click_JavaScript(MasterData);

	}

	public void ClickTask() throws InterruptedException {

		boolean isVisible = UserActions.GetDisplayed(task);
		if(isVisible)
		{
			UserActions.Click_JavaScript(task);
		}
		else{
			UserActions.click(MasterData);
        	UserActions.Click_JavaScript(task);
			
		}

	}

	public void ClickAddNew() {

		UserActions.Wait_Sec();
		UserActions.Click_JavaScript(Addnew);

	}

	public void enterNewTaskCode() throws IOException {
		
		tcode = UserActions.getCellData("UserData","TaskCode",2);
		UserActions.SetValue(taskcode, tcode);
	}

	public void enterNewTaskName() throws IOException {
		
		String tname = UserActions.getCellData("UserData","TaskName",2);
		UserActions.SetValue(taskname,tname);
	}

	public void clickSubmit() {
		
		UserActions.Click_JavaScript(submit);

		
		
		boolean isExist = UserActions.GetExistance(already);
		if(isExist)
		{
			UserActions.Click_JavaScript(cancel);
		}
		

	}

	public void clickOkPopup() {

		boolean isExist = UserActions.GetDisplayed(popupok);
		if(isExist)
		{
		UserActions.click(popupok);
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked on OK button from the PopUp.");
		}
		else{
			
			ExtentCucumberAdapter.addTestStepLog("PopUp is not present. So not clicking on it.");
		}

	}

	public void ClickSubTasks() {
	
		boolean isVisible = UserActions.GetDisplayed(subtask);
		if(isVisible)
		{
			UserActions.Click_JavaScript(subtask);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.Click_JavaScript(subtask);
			
		}

	}

	public void enterNewSubTaskCode() throws IOException {
		String scode = UserActions.getCellData("UserData","SubTaskCode",2);
		UserActions.SetValue(subtaskcode,scode);
	}

	public void enterNewSubTaskName() throws IOException {
		
		String sname = UserActions.getCellData("UserData","SubTaskName",2);
		UserActions.SetValue(subtaskname,sname);
	}

	public String getSuccessMsg() {
		
		boolean isExist = UserActions.GetDisplayed(TaskSuccessText);
		if(isExist)
		{
		String msg = UserActions.getText(TaskSuccessText);
		return msg;
		}
		else{
			
			ExtentCucumberAdapter.addTestStepLog("Already exist.So it is not created again.");
			
		}
		return null;

	}

	public void ClickAction() {

		boolean isVisible = UserActions.GetDisplayed(action);
		if(isVisible)
		{
			UserActions.click(action);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.click(action);
			
		}

	}

	public void enterNewActionCode() throws IOException {
		boolean isExist = UserActions.GetExistance(actioncode);
		if (isExist) {
			String acode = UserActions.getCellData("UserData","ActionCode",2);
			UserActions.SetValue(actioncode, acode);
		}
	}

	public void enterNewActionName() throws IOException {
		
		String aname = UserActions.getCellData("UserData","ActionName",2);
		UserActions.SetValue(actionname,aname);
	}

	public void clickMapSubtaskAction() {

		boolean isVisible = UserActions.GetDisplayed(maptasksubtaskaction);
		if(isVisible)
		{
			UserActions.click(maptasksubtaskaction);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.click(maptasksubtaskaction);	
		}
	}

	public void selectTask() throws IOException {

		//tcode
		String mtask = UserActions.getCellData("UserData","MappingTaskName",2);
		//UserActions.SelectValue(selecttask, tcode);
		UserActions.SelectByOptionValue(selecttask,mtask);
	}

	public void clickMapTaskSubtaskAction_Button() {

		UserActions.click(mapsubtask);

	}

	public void selectSubTask() throws IOException {

		String msubtask = UserActions.getCellData("UserData","MappingSubTaskName",2);
		//UserActions.SelectValue(selectsubtask, msubtask);
		UserActions.SelectByOptionValue(selectsubtask,msubtask);

	}

	public void selectAction() throws IOException, InterruptedException {
			
		String maction = UserActions.getCellData("UserData","MappingActionName",2);
		UserActions.click_by_dynamicxpath(maction);

	}
	
	
	public void selectSubAction() throws InterruptedException, IOException{
			
		   String msubaction = UserActions.getCellData("UserData","MappingSubActionName",2);
			UserActions.click_by_dynamicxpath(msubaction);

	}

	public void clickPOS() {

		boolean isVisible = UserActions.GetDisplayed(pos);
		if(isVisible)
		{
			UserActions.click(pos);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.click(pos);
			
		}
	}

	public void enterPosCode() throws IOException {
		
		 String pcode = UserActions.getCellData("UserData","PosCode",2);
		UserActions.SetValue(poscode,pcode);

	}

	public void enterPosName() throws IOException {
		
		String pname = UserActions.getCellData("UserData","PosName",2);
		UserActions.SetValue(posname, pname);

	}

	public void selectCountry() throws IOException {

		String Country = UserActions.getCellData("UserData","Country",2);
		UserActions.SelectValue(country, Country);

	}

	public void selectBrand() throws IOException {
		Boolean isExist = UserActions.GetExistance(brand);
		if (isExist) {
			String Brand = UserActions.getCellData("UserData","Brand",2);
			//UserActions.SelectValue(brand, Brand);
			UserActions.SelectByOptionValue(brand,Brand);
		}
	}

	public void selectCurrency() throws IOException {

		String Currency = UserActions.getCellData("UserData","Currency",2);
		UserActions.SelectValue(currency, Currency);

	}

	public void selectLangId() throws InterruptedException, IOException {
 
			UserActions.click(langid);
			String LangId = UserActions.getCellData("UserData","LangId",2);
			UserActions.click_by_dynamicxpath(LangId);
			UserActions.click(langid);
	}

	public void addIataCode() throws IOException {
		UserActions.click(addnewiata);
		//String icode = UserActions.getCellData("UserData","Iatacode",2);
		String icode = UserActions.getNumericFormulaCellData("UserData","Iatacode",2);
		UserActions.SetValue(iatanumber,icode);
		UserActions.click(confirmiata);

	}

	public void clickPccConfiguration() {

		boolean isVisible = UserActions.GetDisplayed(pccconfiguration);
		if(isVisible)
		{
			UserActions.click(pccconfiguration);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.click(pccconfiguration);	
		}
	}

	public void selectPOSAndGDS() throws IOException {
        
		String Pos = UserActions.getCellData("UserData","Pos",2);
		//String Gds = UserActions.getCellData("UserData","Gds",2);
		String Gds = UserActions.getNumericFormulaCellData("UserData","Gds",2);
		
		int gdsIndex = Integer.parseInt(Gds);
		UserActions.SelectByOptionValue(selectpos, Pos);
		
		//UserActions.SelectValue(selectgds, Gds);
		UserActions.SelectValueByIndex(selectgds,gdsIndex);
		
	}

	public void enterPCC() throws IOException {

		String Pcc = UserActions.getCellData("UserData","Pcc",2);
		UserActions.SetValue(pcc, Pcc);
	}
	
	
	public void click_SubAction() {

		UserActions.Wait_Sec();
		boolean isVisible = UserActions.GetDisplayed(subaction);
		if(isVisible)
		{
			UserActions.click(subaction);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.click(subaction);
			
		}
		UserActions.Wait_Sec();

	}
	
	public void enterNewSubActionCode() throws IOException {
		
		String sacode = UserActions.getCellData("UserData","SubActionCode",2);
		UserActions.SetValue(subactionCode,sacode);
	}
	
	public void enterNewSubActionName() throws IOException {
		String saname = UserActions.getCellData("UserData","SubActionName",2);
		UserActions.SetValue(subactionName,saname);
	}
	
	public void clickAgentSkills()
	{
		boolean isVisible = UserActions.GetDisplayed(agentskills);
		if(isVisible)
		{
			UserActions.click(agentskills);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.click(agentskills);
			
		}
	}
	
	public void enterAgentSkillCode() throws IOException
	{
		String AgentSkillCode = UserActions.getCellData("UserData","AgentSkillCode",2);
		UserActions.SetValue(agentskillcode, AgentSkillCode);
		
	}
	
	public void enterAgentSkillName() throws IOException
	{
		String AgentSkillName = UserActions.getCellData("UserData","AgentSkillName",2);
		UserActions.SetValue(agentskillname, AgentSkillName);
	}
	
	public void clickLanguageSkills()
	{
		boolean isVisible = UserActions.GetDisplayed(languageskills);
		if(isVisible)
		{
			UserActions.click(languageskills);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.click(languageskills);
			
		}
	}
	
	public void enterLanguageCode() throws IOException
	{
		String lcode = UserActions.getCellData("UserData","LanguageCode",2);
		UserActions.SetValue(languagecode, lcode);
		
	}
	
	public void enterLanguageName() throws IOException
	{
		String lname = UserActions.getCellData("UserData","LanguageName",2);
		UserActions.SetValue(languagename, lname);
	}
	
	
	public void ClickBrand() {

		boolean isVisible = UserActions.GetDisplayed(brands);
		if(isVisible)
		{
			UserActions.click(brands);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.click(brands);
			
		}

	}
	
	public void enterBrandCode() throws IOException
	{
		String bcode = UserActions.getCellData("UserData","BrandCode",2);
		UserActions.SetValue(brandcode, bcode);
		
	}
	
	public void enterBrandName() throws IOException
	{
		String bname = UserActions.getCellData("UserData","BrandName",2);
		UserActions.SetValue(brandname, bname);
		
	}
	
	public void ClickCountry() {

		boolean isVisible = UserActions.GetDisplayed(countries);
		if(isVisible)
		{
			UserActions.click(countries);
		}
		else{
			
			UserActions.click(MasterData);
        	UserActions.click(countries);
			
		}
	}
		
	    public void enterRegionName() throws IOException
		{
			String rname = UserActions.getCellData("UserData","RegionName",2);
			UserActions.SetValue(regionname, rname);
			
		
	     }
	    
	    public void enterCountryCode() throws IOException
		{
			String ccode = UserActions.getCellData("UserData","CountryCode",2);
			UserActions.SetValue(countrycode, ccode);
		
	     }

}