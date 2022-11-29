package com.igt.stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import org.junit.Assert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.igt.base.TestBase;
import com.igt.base.TestSetup;
import com.igt.pageObjects.ManageMasterData;
import com.igt.pageObjects.ManageSTQ;
import com.igt.pageObjects.ManageUsers;
import com.igt.pageObjects.Reports;
import com.igt.pageObjects.Dashboard;
import com.igt.pageObjects.Login;
import com.igt.utility.UserActions;
import com.igt.utility.Util;
import com.igt.pageObjects.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IQDStepDefinition extends TestSetup {

	@Given("IQD Login Screen")
	public void iqd_login_screen() throws Exception {
		try {
			
			
			
			filename = "TestData.xlsx";
			File src = new File(filename);
			fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			   XSSFFormulaEvaluator.evaluateAllFormulaCells(TestSetup.workbook);
				  FileOutputStream out = new FileOutputStream(TestSetup.filename);
		          TestSetup.workbook.write(out); 
		          TestSetup.workbook.close();
			
			
			
			
			File dir = new File("PassedScreenShot");
			
			File dir1 = new File("FailedScreenShot");
			Util.purgeDirectory(dir);
			System.out.println("deleted passed screenshot");
			Util.purgeDirectory(dir1);
			System.out.println("deleted failed screenshot");
			TestBase.loadProperty();
			System.out.println("successfully loaded property");
			TestBase.loadUserInput();
			System.out.println("successfully loaded userinput");
			TestBase.setWebdriver();
			System.out.println("successfully initialized driver");
			log = new Login(d);
			ExtentCucumberAdapter.addTestStepLog(log.GetAppUrl() + "  " + "Application opened successfully");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {
			//ExtentCucumberAdapter.addTestStepLog(
					//"Application is not loaded. See below error message for more details." + "\n" + e.printStackTrace());
			//e.printStackTrace();
			e.printStackTrace();
					Assert.fail();
		}

	}

	@When("enter login credentials such as username password")
	public void enter_login_credentials_such_as_username_password() throws Exception {

		try {
			log.EnterCredentials();
			ExtentCucumberAdapter.addTestStepLog("Login credentials entered successfully");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {
			ExtentCucumberAdapter
					.addTestStepLog("username or password is not present for this application." + "\n" + e.toString());
		}

	}

	@When("Clicked on logon button")
	public void clicked_on_logon_button() throws Throwable {
		try {
			log.ClickLogOn();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on logon button");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		} catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("Logon Button is not clicked" + "\n" + e.toString());
			Assert.fail();
		}
	}

	@Then("click on manage master data")
	public void click_on_manage_master_data() {

		try {
			mmd = new ManageMasterData(d);
			mmd.ClickManageMasterData();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on manageMasterData");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		} catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("manageMasterData is not clicked" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@Then("click on task")
	public void click_on_task() {
		try {
			mmd.ClickTask();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on task");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		} catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("task is not clicked" + "\n" + e.toString());
			Assert.fail();
		}

	}

	@Then("click on addnew button")
	public void click_on_addnew_button() {

		try {

			mmd.ClickAddNew();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on AddNew");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		} catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("AddNew is not clicked" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I enter taskcode")
	public void i_enter_taskcode_as() {

		try {
			mmd.enterNewTaskCode();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered task code");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("task code is not entered" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I enter taskname")
	public void i_enter_taskname_as() {

		try {
			mmd.enterNewTaskName();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered task name");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("task name is not entered" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@Then("I click on submit button")
	public void i_click_on_submit_button() {

		try {
			mmd.clickSubmit();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on submit button");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("submit button is not clicked" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I click on subtasks")
	public void i_click_on_subtasks() {
		try {
			mmd = new ManageMasterData(d);
			mmd.ClickSubTasks();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on subtask");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		} catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("subtask is not clicked" + "\n" + e.toString());
			Assert.fail();

		}
	}

	@When("I enter subtaskcode")
	public void i_enter_subtaskcode() {

		try {
			mmd.enterNewSubTaskCode();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered subtask code");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		} catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("subtask code is not entered" + "\n" + e.toString());
			Assert.fail();

		}
	}

	@When("I enter subtaskname")
	public void i_enter_subtaskname() {

		try {
			mmd.enterNewSubTaskName();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered subtask name");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		} catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("subtask name is not entered" + "\n" + e.toString());
			Assert.fail();

		}
	}

	@Then("I verify task created successfully message")
	public void i_verify_task_created_successfully_message() {
		String SucMsg;
		try {
			mmd = new ManageMasterData(d);
			SucMsg = mmd.getSuccessMsg();
			ExtentCucumberAdapter.addTestStepLog(SucMsg);
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("task is not created successfully" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@Then("I click OK from the popup")
	public void i_click_ok_from_the_popup() {
		try {
			mmd = new ManageMasterData(d);
			mmd.clickOkPopup();
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Popup is not clicked" + "\n" + e.toString());
			Assert.fail();

		}
	}

	@Then("I verify subtask created successfully message")
	public void i_verify_subtask_created_successfully_message() {
		String SuccMsg;
		try {
			SuccMsg = mmd.getSuccessMsg();
			ExtentCucumberAdapter.addTestStepLog(SuccMsg);
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Subtask is not created successfully" + "\n" + e.toString());
			Assert.fail();

		}
	}

	@When("I click on action")
	public void i_click_on_action() {

		try {
			mmd = new ManageMasterData(d);
			mmd.ClickAction();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on action");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Action is not clicked" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I enter actioncode")
	public void i_enter_actioncode() {
		try {
			mmd.enterNewActionCode();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered action code");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Action code is not entered" + "\n" + e.toString());
			Assert.fail();

		}
	}

	@When("I enter actionname")
	public void i_enter_actionname() {

		try {
			mmd.enterNewActionName();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered action name");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Action name is not entered" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@Then("I verify action created successfully message")
	public void i_verify_action_created_successfully_message() {
		String SMsg;

		try {
			SMsg = mmd.getSuccessMsg();
			ExtentCucumberAdapter.addTestStepLog(SMsg);
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Action not created" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I click on map Task Subtask and action")
	public void i_click_on_map_task_subtask_and_action() {

		try {
			mmd = new ManageMasterData(d);
			mmd.clickMapSubtaskAction();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on Map task Subtask Action button");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Map Task Subtask Action button is not clicked" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select task from the dropdown")
	public void i_select_task_from_the_dropdown() {

		try {
			mmd.selectTask();
			ExtentCucumberAdapter.addTestStepLog("task selected from the dropdown");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("task is not selected from the dropdown" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I click on Map Task Subtask Action button")
	public void i_click_on_map_task_subtask_action_button() {

		try {
			mmd.clickMapTaskSubtaskAction_Button();
			ExtentCucumberAdapter.addTestStepLog("Map Task Subtask Action button is clicked successfully");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Map Task Subtask Action button is not clicked" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select subtask from the dropdown")
	public void i_select_subtask_from_the_dropdown() {

		try {
			mmd.selectSubTask();
			ExtentCucumberAdapter.addTestStepLog("subtask selected from the dropdown");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		} catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("subtask not selected from the dropdown" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select action from the dropdown")
	public void i_select_action_from_the_dropdown() throws InterruptedException {
        try{
		mmd.selectAction();
		ExtentCucumberAdapter.addTestStepLog("action selected from the dropdown");
		Util.TakeScreenShot(d, System.currentTimeMillis());
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	ExtentCucumberAdapter.addTestStepLog("action not selected from the dropdown" + "\n" + e.toString());
			Assert.fail();
        	
        }

	}
	
	@When("I select subaction from the dropdown")
	public void i_select_subaction_from_the_dropdown() {
	    
        try{
		mmd.selectSubAction();
		ExtentCucumberAdapter.addTestStepLog("subaction selected from the dropdown");
		Util.TakeScreenShot(d, System.currentTimeMillis());
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	ExtentCucumberAdapter.addTestStepLog("subaction not selected from the dropdown" + "\n" + e.toString());
			Assert.fail();
        	
        }
		
	}

	@Then("I verify action mapped to task and subtask successfully")
	public void i_verify_action_mapped_to_task_and_subtask_successfully() {

		String SM;

		try {
			SM = mmd.getSuccessMsg();
			ExtentCucumberAdapter.addTestStepLog(SM);
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Action not mapped to task and subtask" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I click on POS")
	public void i_click_on_pos() {

		try {
			mmd = new ManageMasterData(d);
			mmd.clickPOS();
			ExtentCucumberAdapter.addTestStepLog("Clicked on POS");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		} catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("POS is not clicked" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I enter POS code and POS name")
	public void i_enter_pos_code_as_and_pos_name_as() {

		try {
			mmd.enterPosCode();
			mmd.enterPosName();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered POS code and POS name");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("POS code and POS name is not entered" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select country,brand,currency")
	public void i_select_country_as_brand_as_currency_as() {

		try {
			mmd.selectCountry();
			mmd.selectBrand();
			mmd.selectCurrency();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected country,brand and currency");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("country or brand or currency is not selected" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select LangId and POSIATACode")
	public void i_select_langid_and_posiata_code() {

		try {
			mmd.selectLangId();
			mmd.addIataCode();
			ExtentCucumberAdapter.addTestStepLog("langId selected and IATA code entered");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter
					.addTestStepLog("langId is not selected or IATA code is not entered" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@Then("I verify POS created successfully")
	public void i_verify_pos_created_successfully() {

		try {
			String vpos;
			vpos = mmd.getSuccessMsg();
			ExtentCucumberAdapter.addTestStepLog(vpos);
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("POS is not created successfully" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I click on PccConfiguration")
	public void i_click_on_pcc_configuration() {

		try {
			mmd = new ManageMasterData(d);
			mmd.clickPccConfiguration();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on PCC Configuration");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("PCC Configuration is not clicked" + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select POS and select GDS")
	public void i_select_pos_and_select_gds() {

		try {
			mmd.selectPOSAndGDS();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected POS and GDS");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("POS and GDS is not selected" + "\n" + e.toString());
			Assert.fail();
		}
	}

	@When("I enter pcc")
	public void i_enter_pcc() {

		try {
			mmd.enterPCC();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered PCC");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("PCC not entered." + "\n" + e.toString());
			Assert.fail();

		}
	}

	@Then("I verify PCC created successfully")
	public void i_verify_pcc_created_successfully() {

		try {
			String psuc;
			psuc = mmd.getSuccessMsg();
			ExtentCucumberAdapter.addTestStepLog(psuc);
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("PCC not created successfully." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I click on manage STQ")
	public void i_click_on_manage_stq() {

		try {
			ms = new ManageSTQ(d);
			ms.clickManageSTQ();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on manage STQ");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Manage STQ is not clicked." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I click on GDS Queue Configuration")
	public void i_click_on_gds_queue_configuration() {

		try {
			ms.clickGDSQueueConfiguration();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on GDS Queue Configuration");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("GDS Queue Configuration is not clicked." + "\n" + e.toString());
			Assert.fail();

		}
	}

	@When("click on addnew")
	public void click_on_addnew() {

		try {
			ms.AddNew_Click();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on addnew");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Addnew is not clicked." + "\n" + e.toString());
			Assert.fail();

		}
	}

	@When("I enter GDS queue name")
	public void i_enter_gds_queue_name() {

		try {
			ms.enterGDSQueueName();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered GDS queue name.");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to enter GDS queue." + "\n" + e.toString());
			Assert.fail();

		}
	}

	@When("I select GDS type")
	public void i_select_gds_type_as() {

		try {
			ms.selectGDS();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected GDS type.");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to select GDS type." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select POS and POS IATA Number and Pcc")
	public void i_select_pos_as_and_pos_iata_number_as_and_pcc_as() {

		try {
			ms.selectPOS();
			ms.selectPOSIata();
			ms.selectPcc();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected POS,POSIata,PCC");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to select POS,POSIata,PCC." + "\n" + e.toString());
			Assert.fail();

		}
	}

	@When("I select Target THT Hour and Minute")
	public void i_select_target_tht_hour_and_minute() {

		try {
			ms.selectTargetTHT();

			ExtentCucumberAdapter.addTestStepLog("Successfully selected THT hour and THT minute");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		} catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to select THT hour and THT minute." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select Task and Subtask")
	public void i_select_task_and_subtask() {

		try {
			ms.selectTaskAndSubTask();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected task and subtask");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to select task and subtask." + "\n" + e.toString());
			Assert.fail();
		}

	}

	@When("I select Skill")
	public void i_select_skill() {

		try {
			ms.selectSkill();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected skill");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to select skill." + "\n" + e.toString());
			Assert.fail();
		}
	}

	@When("I select Duration hour and minute")
	public void i_select_duration_hour_and_minute() {

		try {
			ms.selectDuration();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected Duration hour and Duration minute");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to select skill." + "\n" + e.toString());
			Assert.fail();
		}
	}

	@When("I select timezone")
	public void i_select_timezone() {

		try {
			ms.selectTimeZone();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected timezone");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}
		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to select timezone." + "\n" + e.toString());
			Assert.fail();
		}
	}
	
	
	
	@When("I click on Test Connection button if available")
	public void i_click_on_test_connection_button_if_available() {
	    
		try{
		ms.clickTestConnection();
		}
		catch(Exception e)
		{
			ExtentCucumberAdapter.addTestStepLog("Unable to click on Test Connection." + "\n" + e.getMessage());
			Assert.fail();
		}
	}

	@When("I click on submit")
	public void i_click_on_submit() {

		try {
			ms.submit();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on submit");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to click on submit." + "\n" + e.toString());
			Assert.fail();

		}

	}
	
	
	@Then("I verify GDS Queue created successfully message")
	public void i_verify_gds_queue_created_successfully_message() {
	    
		String SucMsg;
		try {
			mmd = new ManageMasterData(d);
			SucMsg = mmd.getSuccessMsg();
			ExtentCucumberAdapter.addTestStepLog(SucMsg);
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("GDS Queue is not created successfully" + "\n" + e.toString());
			Assert.fail();
		}	
	}

	@When("I click on reporting")
	public void i_click_on_reporting() {

		rep = new Reports(d);
		rep.clickReporting();

	}

	@When("I click on agent report")
	public void i_click_on_agent_report() {

		rep.clickAgentReport();

	}

	@When("I select site, site partition, datefilter, startDate, endDate")
	public void i_select_site_site_partition_date_filter_start_date_end_date() throws IOException {

		rep.selectSite();
		rep.selectSitePartions();
		rep.selectDateType();

	}

	@Then("I click on download button")
	public void i_click_on_download_button() {

		rep.clickDownload();

	}

	@When("I click on agent performance report")
	public void i_click_on_agent_performance_report() {

		rep.clickAgentPerformance();

	}

	@When("I select site, site partition, pos, datefilter, startDate, endDate")
	public void i_select_site_site_partition_pos_datefilter_start_date_end_date() throws IOException

	{
		rep.selectSite_AgentPerformance();
		rep.selectSitePartions_AgentPerformance();
		rep.select_pos();
		rep.selectDateType_AgentPerformance();
	}

	@Then("I click on download")
	public void i_click_on_download() {

		rep.download();

	}

	@When("I click on work itme details report")
	public void i_click_on_work_itme_details_report() {

		try {
			rep.click_WorkItemDetails();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on WorkItemDetails.");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to click on WorkItemDetails." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select OnDateType, site, sitePartition, workItemType, startDate, endDate, datefilter")
	public void i_select_ondatetype_site_sitepartition_workitemtype_startdate_enddate_datefilter() {

		try {
			rep.selectOnDateType();
			rep.selectSite_WorkItemDetails();
			rep.selectSitePartions_WorkItemDetails();
			rep.selectWorkItemType();
			rep.selectDateByDateType_WorkItemDetails();
			ExtentCucumberAdapter.addTestStepLog(
					"Successfully selected OndateType or site or sitepartition or workitemtype or startdate or enddate.");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog(
					"Unable to select OndateType or site or sitepartition or workitemtype or startdate or enddate."
							+ "\n" + e.toString());
			Assert.fail();
		}

	}

	@When("I select task")
	public void i_select_task() throws InterruptedException {

		try {
			rep.selectTask();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected task.");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("Unable to select task." + "\n" + e.toString());
			Assert.fail();
		}
	}

	@When("I click on SLA Compliance report")
	public void i_click_on_sla_compliance_report() {

		try {
			rep.click_SLACompliance();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on SLA Compliance.");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("SLA Compliance report is not clicked." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select site, sitepartition, datefilter, startDate, endDate")
	public void i_select_vendor_vendorpartition_datefilter_startdate_enddate() {

		try {
			rep.selectSite_SLACompliance();
			rep.selectSitePartions_SLACompliance();
			rep.selectDateType_SLACompliance();
			ExtentCucumberAdapter
					.addTestStepLog("Successfully selected vendor,vendor partition,datefilter,startdate,enddate.");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog(
					"Unable to select vendor,vendor partition,datefilter,startdate,enddate." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I click task or STQ radio button")
	public void i_click_task_or_stq_radio_button() throws InterruptedException {

		try {
			rep.clickRadioButton();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected task or STQ radio button.");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		} catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Unable to select task or STQ radio button." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select task or STQ from the dropdown")
	public void i_select_task_or_stq_from_the_dropdown() {

		try {
			rep.selectValueFromDropdown();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected task or STQ.");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			ExtentCucumberAdapter
					.addTestStepLog("Unable to select task or STQ from the dropdown." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select subtask or ASTQ from the checkbox")
	public void i_select_subtask_or_astq_from_the_checkbox() {

		try {
			rep.selectValueFromCheckbox();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected subtask or ASTQ from the checkbox.");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		} catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter
					.addTestStepLog("Unable to select subtask or ASTQ from the checkbox." + "\n" + e.toString());
			Assert.fail();

		}
	}

	@When("I click on SingleWorkItem report")
	public void i_click_on_single_work_item_report() {
		try {
			rep.click_SingleWorkItem();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on singleWorkItem.");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to click on singleWorkItem." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I enter WorkItemId and PNRRecordlocator")
	public void i_enter_work_item_id_as_and_pnr_recordlocator_as() {

		try {
			rep.enterWorkItemIdAndPnr();
			ExtentCucumberAdapter.addTestStepLog("Successfully entered WorkItemId and PNRRecordLocator.");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		}

		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter
					.addTestStepLog("Unable to enter WorkItemId and PNRRecordLocator." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I click on escalated work item report")
	public void i_click_on_escalated_work_item_report() {

		try {
			rep.click_EscalatedWorkItem();
			ExtentCucumberAdapter.addTestStepLog("Successfully clicked on escalated work item report.");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		} catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter
					.addTestStepLog("Unable to click on escalated work item report." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select site, sitepartition, startDate, endDate")
	public void i_select_site_sitepartition_startdate_enddate() {

		try {
			rep.selectSite_EscalatedWorkItem();
			rep.selectSitePartions_EscalatedWorkItem();
			rep.selectDateByDateType();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected site, sirepartition,startdate,enddate");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}

		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter
					.addTestStepLog("Unable to select site, sirepartition,startdate,enddate." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select STQ from the dropdown")
	public void i_select_stq_from_the_dropdown() {

		try {
			rep.selectSTQ();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected STQ from the dropdown");
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to select STQ from the dropdown." + "\n" + e.toString());
			Assert.fail();

		}

	}

	@When("I select ASTQ from the checkbox")
	public void i_select_astq_from_the_checkbox() {

		try {
			rep.selectValueFromCheckboxes();
			ExtentCucumberAdapter.addTestStepLog("Successfully selected ASTQ from the checkbox");
			Util.TakeScreenShot(d, System.currentTimeMillis());

		} catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to select ASTQ from the checkbox." + "\n" + e.toString());
			Assert.fail();

		}
	}
	
	@When("I click on SubAction")
	public void i_click_on_sub_action() {

		try{
		mmd = new ManageMasterData(d);
		mmd.click_SubAction();
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked on SubAction.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		
		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to click on SubAction." + "\n" + e.toString());
			Assert.fail();

		}
		
	}
	
	
	@When("I enter subaction code")
	public void i_enter_subaction_code() {
	   
		try{
		mmd.enterNewSubActionCode();
		ExtentCucumberAdapter.addTestStepLog("Successfully entered subaction code.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to enter subaction code." + "\n" + e.toString());
			Assert.fail();

		}
		
	}
	@When("I enter subaction name")
	public void i_enter_subaction_name() {
	   
		try{
		mmd.enterNewSubActionName();
		ExtentCucumberAdapter.addTestStepLog("Successfully entered subaction name.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to enter subaction name." + "\n" + e.toString());
			Assert.fail();

		}
		
	}
	@Then("I verify subaction created successfully message")
	public void i_verify_subaction_created_successfully_message() {
	    
		try{
		String success = mmd.getSuccessMsg();
		ExtentCucumberAdapter.addTestStepLog(success);
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		
		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to verify subaction created successfully." + "\n" + e.toString());
			Assert.fail();

		}
		
	}
	
	@When("I click on agentskills from the menu")
	public void i_click_on_agentskills_from_the_menu() {
	   
		try{
		mmd.clickAgentSkills();
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked on AgentSkills from the menu.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		
		catch(Exception e)
		
		{
			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to click AgentSkills from the menu." + "\n" + e.toString());
			Assert.fail();
			
		}
		
		
	}
	@When("I enter agentskillcode")
	public void i_enter_agentskillcode() {
	    
		try{
		mmd.enterAgentSkillCode();
		ExtentCucumberAdapter.addTestStepLog("Successfully entered agentSkillCode.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to enter agentSkillCode." + "\n" + e.toString());
			Assert.fail();
			
		}	
	}
	@When("I enter agentskillname")
	public void i_enter_agentskillname_as() {
	
		try{
		mmd.enterAgentSkillName();
		ExtentCucumberAdapter.addTestStepLog("Successfully entered agentSkillName.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to enter agentSkillName." + "\n" + e.toString());
			Assert.fail();
			
		}		
		
	}
	@Then("I verify agent skill created successfully message")
	public void i_verify_agent_skill_created_successfully_message() {
	    
		try{
		String success = mmd.getSuccessMsg();
		ExtentCucumberAdapter.addTestStepLog(success);
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		
		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to verify agentskills created successfully." + "\n" + e.toString());
			Assert.fail();

		}
	}
	
	@When("I click on languageskills from the menu")
	public void i_click_on_languageskills_from_the_menu() {
	   
		try{
		mmd = new ManageMasterData(d);
		mmd.clickLanguageSkills();
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked on languageSkills from the menu.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		
		}
		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to click on languageSkills from the menu." + "\n" + e.toString());
			Assert.fail();

		}
		
		
	}
	@When("I enter languagecode")
	public void i_enter_languagecode() {
	   
		try{
		mmd.enterLanguageCode();
		ExtentCucumberAdapter.addTestStepLog("Successfully entered language code.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch (Exception e) {
			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to enter language code." + "\n" + e.toString());
			Assert.fail();
		}		
	}
	@When("I enter language name")
	public void i_enter_language_name_as() {
	   
		try{
		mmd.enterLanguageName();
		ExtentCucumberAdapter.addTestStepLog("Successfully entered language name.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch (Exception e) {

			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to enter language name." + "\n" + e.toString());
			Assert.fail();
		}
	}
	
	@Then("I verify language skills created successfully message")
	public void i_verify_language_skills_created_successfully_message() {
		    
			try{
			String success = mmd.getSuccessMsg();
			ExtentCucumberAdapter.addTestStepLog(success);
			Util.TakeScreenShot(d, System.currentTimeMillis());
			}
			
			catch (Exception e) {

				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to verify language skills created successfully." + "\n" + e.toString());
				Assert.fail();

			}
		
	}
	
	
	@When("I click on dashboard from the menu")
	public void i_click_on_dashboard_from_the_menu() {
		db = new Dashboard(d);
		try{
		db.click_Dashboard();
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked dashboard from the menu.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to click on dashboard." + "\n" + e.toString());
			Assert.fail();
		}
	}
	
	@When("I click on AgentAndWorkItem dashboard")
	public void i_click_on_agent_and_work_item_dashboard() {
	    
		try{
		db.click_agentworkitem();
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked on AgentAndWorkItem dashboard.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to click on AgentAndWorkItem dashboard." + "\n" + e.toString());
			Assert.fail();
		}	
	}
	
	@When("I select site, sitepartition, duration")
	public void i_select_site_as_sitepartition_as_duration_as() throws IOException {
	   try{
		db.select_Site_Sitepartitions_Duration();
		ExtentCucumberAdapter.addTestStepLog("Successfully selected site,sitepartition, duration.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
	   }
	   catch(Exception e)
	   {
			e.printStackTrace();
			ExtentCucumberAdapter.addTestStepLog("Unable to select site,sitepartition,duration." + "\n" + e.toString());
			Assert.fail();
	   }
	}
	@When("I select STQ")
	public void i_select_stq() {
	
		try{
		db.select_Stq();
		ExtentCucumberAdapter.addTestStepLog("Successfully selected stq.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to select stq." + "\n" + e.toString());
				Assert.fail();
		   }
		
	}
	@Then("I click on search button")
	public void i_click_on_search_button() {
	   
		try{
		db.click_Search();
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked on search button.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to search." + "\n" + e.toString());
				Assert.fail();
		   }
		
	}	
	
	@When("I click on STQ\\/ASTQ dashboard")
	public void i_click_on_stq_astq_dashboard() {
	    
		try{
		db.click_StqAstq();
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked on STQ/ASTQ dashboard.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		
		}
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to click on STQ/ASTQ dashboard." + "\n" + e.toString());
				Assert.fail();
		   }	
	}
	
	@Then("I click on the expand arrow of 'New ITEMS'")
	public void i_click_on_the_expand_arrow_of() {
	    try{
		db.click_ExpandArrow();
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked on expand arrow.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
	    }
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to click on expand arrow." + "\n" + e.toString());
				Assert.fail();
		   }
			
	}
	@Then("I verify 'Work Item Status' dialog box")
	public void i_verify_dialog_box() {
	 
		try{
		db.verifyExpandDialog();
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to verify expand arrow dialog." + "\n" + e.toString());
				Assert.fail();
		   }
	}
	
	@When("I click on STQ dropdown")
	public void i_click_on_stq_dropdown() {
	  
		try{
       db.expandAllSTQ();
       ExtentCucumberAdapter.addTestStepLog("Successfully expanded all stqs.");
       Util.TakeScreenShot(d, System.currentTimeMillis());
       
		}
		
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to expand all stqs." + "\n" + e.toString());
				Assert.fail();
		   }
		
	}
	@Then("I verify if the count of COMPLETED WORK ITEMS, NEW WORK ITEMS, SLA BREACHED \\(NEW), AGENTS ASSIGNED, AGENTS WORKING, AGENTS ON BREAK, AGENTS IDLE is displaying as expected")
	public void i_verify_if_the_count_of_completed_work_items_new_work_items_sla_breached_new_agents_assigned_agents_working_agents_on_break_agents_idle_is_displaying_as_expected() {
	    
		try{
		db.click_Search();
		UserActions.Wait_Sec();
		db.verifyCompletedWorkItemsCount();
        db.verifyNewWorkItemsCount();
        db.verifySLABreachedCount();
        db.verifyAgentsAssignedCount();
        db.verifyAgentsWorkingCount();
        db.verifyAgentsOnBreakCount();
        db.verifyAgentsIdleCount();
        ExtentCucumberAdapter.addTestStepLog("Successfully verified the count of COMPLETED WORK ITEMS, NEW WORK ITEMS, SLA BREACHED, AGENTS ASSIGNED, AGENTS WORKING, AGENTS ON BREAK, AGENTS IDLE .");
        Util.TakeScreenShot(d, System.currentTimeMillis());
        
		}
		
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to verify the count of COMPLETED WORK ITEMS, NEW WORK ITEMS, SLA BREACHED, AGENTS ASSIGNED, AGENTS WORKING, AGENTS ON BREAK, AGENTS IDLE ." + "\n" + e.toString());
				Assert.fail();
		   }
	}
	
	@When("I add all the agents from the data sheet")
	public void add_all_the_agents_from_the_data_sheet() throws IOException, InterruptedException {
	   
		try{
		mu = new ManageUsers(d);
		mu.manageAgent();
		ExtentCucumberAdapter.addTestStepLog("Successfully added all the agents data from the excel sheet.");
		Util.TakeScreenShot(d, System.currentTimeMillis());

		}
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to add agents data from the excel." + "\n" + e.toString());
				Assert.fail();
		   }
	}
	
	
	@When("I add all the supervisor from the data sheet")
	public void i_add_all_the_supervisor_from_the_data_sheet() throws IOException, InterruptedException {
	   
		mu = new ManageUsers(d);
		mu.manageSupervisor();
		
		
		
		
		
	}

	
	@When("I click on brand")
	public void i_click_on_brand() {
	 
		try{
		mmd = new ManageMasterData(d);	
		mmd.ClickBrand();
		ExtentCucumberAdapter.addTestStepLog("Successfully clicked on brand from the menu.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		
		}
		
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to click on brand from the menu." + "\n" + e.toString());
				Assert.fail();
		   }
	}
	@When("I enter brand code")
	public void i_enter_brand_code() throws IOException {
	
		
		try{
		mmd.enterBrandCode();
		ExtentCucumberAdapter.addTestStepLog("Successfully entered brand code.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		
		}
		
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to enter brand code." + "\n" + e.toString());
				Assert.fail();
		   }
	}
	@When("I enter brand name")
	public void i_enter_brand_name() {
	    
		
		try{
		mmd.enterBrandName();
		ExtentCucumberAdapter.addTestStepLog("Successfully entered brand name.");
		Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		   catch(Exception e)
		   {
				e.printStackTrace();
				ExtentCucumberAdapter.addTestStepLog("Unable to enter brand name." + "\n" + e.toString());
				Assert.fail();
		   }	
	}
	@Then("I verify brand created successfully message")
	public void i_verify_brand_created_successfully_message() {
	
		String SMsg;

		try {
			SMsg = mmd.getSuccessMsg();
			ExtentCucumberAdapter.addTestStepLog(SMsg);
			Util.TakeScreenShot(d, System.currentTimeMillis());
		}
		catch (Exception e) {

			ExtentCucumberAdapter.addTestStepLog("Brand is not created successfully." + "\n" + e.toString());
			Assert.fail();

		}		
	}
	
	@When("I click on countries")
	public void i_click_on_countries() {
	  
		
		
		
		
	}
	@When("I enter region name")
	public void i_enter_region_name() {
	   
		
		
		
		
	}
	@When("I enter country code")
	public void i_enter_country_code() {
	
		
		
		
	}
	@When("I enter country name")
	public void i_enter_country_name() {
	  
		
		
		
	}
	@Then("I verify country created successfully message")
	public void i_verify_country_created_successfully_message() {
	    
		
		
		
	}
}
	

