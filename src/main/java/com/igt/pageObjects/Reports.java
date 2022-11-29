package com.igt.pageObjects;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.igt.base.TestSetup;
import com.igt.utility.Const;
import com.igt.utility.UserActions;

public class Reports extends TestSetup {

	String STARTDATE;
	String ENDDATE;
	String SDATE;
	String EDATE;
	LocalDate date;

	public Reports(WebDriver d) {

		this.d = d;

	}

	public final By report = By.xpath(p.getProperty("Reporting_locator"));
	public final By agentreport = By.xpath(p.getProperty("AgentReport_locator"));
	public final By site = By.xpath(p.getProperty("Site_locator"));
	public final By sitepartition = By.xpath(p.getProperty("SitePartition_locator"));
	public final By datefilter = By.xpath(p.getProperty("DateFilter_locator"));
	public final By sdate = By.xpath(p.getProperty("StartDate_locator"));
	public final By edate = By.xpath(p.getProperty("EndDate_locator"));
	public final By download = By.xpath(p.getProperty("Download_locator"));
	public final By agentperformance = By.xpath(p.getProperty("AgentPerformance_locator"));
	public final By posSelection = By.xpath(p.getProperty("selectpos_locator"));
	public final By downloadButton = By.xpath(p.getProperty("DownloadButton_locator"));
	public final By workitemdetails = By.xpath(p.getProperty("WorkItemDetails_locator"));
	public final By ondatetype = By.xpath(p.getProperty("OnDateType_locator"));
	public final By workitemtype = By.xpath(p.getProperty("WorkItemType_locator"));
	public final By taskname = By.xpath(p.getProperty("selectTaskName_locator"));
	public final By SLACompliance = By.xpath(p.getProperty("SLACompliance_locator"));
	public final By stask = By.xpath(p.getProperty("taskSelect_locator"));
	public final By sSTQ = By.xpath(p.getProperty("SelectSTQ_locator"));
	public final By singleworkitem = By.xpath(p.getProperty("SingleWorkItem_locator"));
	public final By workitemid = By.xpath(p.getProperty("WorkItemId_locator"));
	public final By pnr = By.xpath(p.getProperty("PNR_locator"));
	public final By escalatedworkitem = By.xpath(p.getProperty("EscalatedWorkItem_locator"));

	
	
	
	
	/**
	 * @author S.Panigrahi
	 * Clicking on report menu
	 *
	 */
	public void clickReporting() {

		UserActions.click(report);

	}
	
	
	/**
	 * @author S.Panigrahi
	 * Clicking on agent report
	 *
	 */

	public void clickAgentReport() {

		UserActions.click(agentreport);

	}
	
	
	/**
	 * Select vendor from the dropdown
	 * @param SITE
	 * @throws IOException 
	 */

	public void selectSite() throws IOException {

		String arsite = UserActions.getCellData("UserData","Site_AgentReport",2);
		UserActions.SelectValue(site, arsite);

	}
	
	public void selectSite_AgentPerformance() throws IOException {

		String apsite = UserActions.getCellData("UserData","Site_AgentPerformanceReport",2);
		UserActions.SelectValue(site, apsite);

	}
	
	public void selectSite_SLACompliance() throws IOException {

		String slasite = UserActions.getCellData("UserData","Site_SLAComplianceReport",2);
		UserActions.SelectValue(site, slasite);

	}
	
	public void selectSite_EscalatedWorkItem() throws IOException {

		String escsite = UserActions.getCellData("UserData","Site_EscalatedWorkItemReport",2);
		UserActions.SelectValue(site,escsite);

	}
	
	public void selectSite_WorkItemDetails() throws IOException {

		String wisite = UserActions.getCellData("UserData","Site_WorkItemDetailsReport",2);
		UserActions.SelectValue(site,wisite);

	}
	
	
	
	/**
	 * Select vendor partition from the dropdown
	 * @param SITEPARTITION
	 * @throws IOException 
	 */

	public void selectSitePartions() throws IOException {

		String arsitepartition = UserActions.getCellData("UserData","SitePartition_AgentReport",2);
		UserActions.SelectValue(sitepartition,arsitepartition );

	}
	
	public void selectSitePartions_AgentPerformance() throws IOException {

		String apsitepartition = UserActions.getCellData("UserData","SitePartition_AgentPerformanceReport",2);
		UserActions.SelectValue(sitepartition,apsitepartition );
	}
	
	public void selectSitePartions_SLACompliance() throws IOException {

		String slasitepartition = UserActions.getCellData("UserData","SitePartition_SLAComplianceReport",2);
		UserActions.SelectValue(sitepartition,slasitepartition );
	}
	
	public void selectSitePartions_EscalatedWorkItem() throws IOException {

		String escsitepartition = UserActions.getCellData("UserData","SitePartition_EscalatedWorkItemReport",2);
		UserActions.SelectValue(sitepartition,escsitepartition );
	}
	
	public void selectSitePartions_WorkItemDetails() throws IOException {

		String wisitepartition = UserActions.getCellData("UserData","SitePartition_WorkItemDetailsReport",2);
		UserActions.SelectValue(sitepartition,wisitepartition);
	}

	/**
	 * select start date and end date if date type is past date
	 * @param DateType
	 * @throws IOException 
	 */
	
	public void selectDateType() throws IOException

	{

		String ardatetype = UserActions.getCellData("UserData","DateType_AgentReport",2);
		UserActions.SelectValue(datefilter, ardatetype);
		if (ardatetype.equals(Const.PAST_DATE)) {
			UserActions.Wait_Sec();
			WebElement input_Sdate = d.findElement(By.xpath("//input[@name='reportBean.startDate']"));
			UserActions.Wait_Sec();
			JavascriptExecutor executor = (JavascriptExecutor) d;
			executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", input_Sdate);

			LocalDate date = LocalDate.now();
			System.out.println("Date: " + date);

			LocalDate local = date.minusDays(30);
			System.out.println("New Date: " + local);
			STARTDATE = local.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

			input_Sdate.sendKeys(STARTDATE);

			UserActions.Wait_Sec();

			WebElement input_Edate = d.findElement(By.xpath("//input[@name='reportBean.endDate']"));
			UserActions.Wait_Sec();
			executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", input_Edate);

			LocalDate edate = date.minusDays(10);
			System.out.println("New Date: " + edate);
			ENDDATE = edate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

			input_Edate.sendKeys(ENDDATE);

		}

	}
	
	public void selectDateType_AgentPerformance() throws IOException

	{

		String apdatetype = UserActions.getCellData("UserData","DateFilter_AgentPerformanceReport",2);
		UserActions.SelectValue(datefilter, apdatetype);
		if (apdatetype.equals(Const.PAST_DATE)) {
			UserActions.Wait_Sec();
			WebElement input_Sdate = d.findElement(By.xpath("//input[@name='reportBean.startDate']"));
			UserActions.Wait_Sec();
			JavascriptExecutor executor = (JavascriptExecutor) d;
			executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", input_Sdate);

			LocalDate date = LocalDate.now();
			System.out.println("Date: " + date);

			LocalDate local = date.minusDays(30);
			System.out.println("New Date: " + local);
			STARTDATE = local.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

			input_Sdate.sendKeys(STARTDATE);

			UserActions.Wait_Sec();

			WebElement input_Edate = d.findElement(By.xpath("//input[@name='reportBean.endDate']"));
			UserActions.Wait_Sec();
			executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", input_Edate);

			LocalDate edate = date.minusDays(10);
			System.out.println("New Date: " + edate);
			ENDDATE = edate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

			input_Edate.sendKeys(ENDDATE);

		}

	}
	
	
	
	public void selectDateType_SLACompliance() throws IOException

	{

		String sladatetype = UserActions.getCellData("UserData","DateType_SLAComplianceReport",2);
		UserActions.SelectValue(datefilter, sladatetype);
		if (sladatetype.equals(Const.PAST_DATE)) {
			UserActions.Wait_Sec();
			WebElement input_Sdate = d.findElement(By.xpath("//input[@name='reportBean.startDate']"));
			UserActions.Wait_Sec();
			JavascriptExecutor executor = (JavascriptExecutor) d;
			executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", input_Sdate);

			LocalDate date = LocalDate.now();
			System.out.println("Date: " + date);

			LocalDate local = date.minusDays(30);
			System.out.println("New Date: " + local);
			STARTDATE = local.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

			input_Sdate.sendKeys(STARTDATE);

			UserActions.Wait_Sec();

			WebElement input_Edate = d.findElement(By.xpath("//input[@name='reportBean.endDate']"));
			UserActions.Wait_Sec();
			executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", input_Edate);

			LocalDate edate = date.minusDays(10);
			System.out.println("New Date: " + edate);
			ENDDATE = edate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

			input_Edate.sendKeys(ENDDATE);

		}

	}

	
	/**
	 * Click on download button
	 */
	public void clickDownload() {
		UserActions.Wait_Sec();
		UserActions.click(download);
		UserActions.Wait_Sec();
	}

	/*
	 * public void fetchExcelData() {
	 * 
	 * String value = UserActions.readExcel(System.getProperty("user.dir")+
	 * "\\Config\\AgentDetailsReport_04-01-2022_04-01-2022.xlsx",1,1);
	 * ExtentCucumberAdapter.addTestStepLog("Site name is"+"  "+value);
	 * 
	 * 
	 * }
	 */

	/**
	 * Click on agent performance report
	 */
	
	public void clickAgentPerformance() {

		UserActions.Wait_Sec();
		UserActions.click(agentperformance);

	}

	/**
	 * Select POS from the dropdown or list
	 * @param POS
	 * @throws IOException 
	 */
	
	
	public void select_pos() throws IOException {

		String apPos = UserActions.getCellData("UserData","Pos_AgentPerformanceReport",2);
		UserActions.SelectValue(posSelection, apPos);
	}

	/**
	 * Click on download button
	 */
	public void download() {

		UserActions.click(downloadButton);

	}

	/**
	 * Click on work item details
	 */
	
	public void click_WorkItemDetails() {

		UserActions.Wait_Sec();
		UserActions.Click_JavaScript(workitemdetails);
		UserActions.Wait_Sec();

	}
	
	/**
	 * select value from ondatetype dropdown
	 * @param ONDATETYPE
	 * @throws IOException 
	 */

	public void selectOnDateType() throws IOException {
        
		String ONDATETYPE = UserActions.getCellData("UserData","OnDateType_WorkItemDetailsReport",2);
		UserActions.SelectValue(ondatetype, ONDATETYPE);
	}
	
	/**
	 * select work item type from the dropdown
	 * @param WORKITEMTYPE
	 * @throws IOException 
	 */

	public void selectWorkItemType() throws IOException {

		Boolean isAvailable = d.findElement(workitemtype).isDisplayed();
		if (isAvailable) {
			String WORKITEMTYPE = UserActions.getCellData("UserData","WorkItemType_WorkItemDetailsReport",2);
			UserActions.SelectValue(workitemtype, WORKITEMTYPE);
		}

	}

	/**
	 * select task from the list
	 * @param TASK
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	
	
	public void selectTask() throws InterruptedException, IOException {

		String TASK = UserActions.getCellData("UserData","Task_WorkItemDetailsReport",2);
		UserActions.dynamicxpath(TASK);

	}
	
	/**
	 * Enter past date for StartDate and EndDate field
	 * @param DateFilter
	 * @throws IOException 
	 */

	public void selectDateByDateType_WorkItemDetails() throws IOException

	{

		Boolean isAvailable = d.findElement(datefilter).isDisplayed();
		if (isAvailable) {
			String DateFilter = UserActions.getCellData("UserData","DateFilter_WorkItemDetailsReport",2);
			UserActions.SelectValue(datefilter, DateFilter);

			if (DateFilter.equals(Const.PAST_DATE)) {
				UserActions.Wait_Sec();
				WebElement input_Sdate = d.findElement(By.xpath("//input[@name='reportBean.startDate']"));
				UserActions.Wait_Sec();
				JavascriptExecutor executor = (JavascriptExecutor) d;
				executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", input_Sdate);

				date = LocalDate.now();
				// displaying date
				System.out.println("Date: " + date);

				LocalDate local = date.minusDays(15);
				System.out.println("New Date: " + local);
				SDATE = local.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

				input_Sdate.sendKeys(SDATE);

				LocalDate edate = date.minusDays(5);
				System.out.println("New Date: " + edate);
				EDATE = edate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

				UserActions.Wait_Sec();
				WebElement input_Edate = d.findElement(By.xpath("//input[@name='reportBean.endDate']"));
				UserActions.Wait_Sec();
				executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", input_Edate);

				input_Edate.sendKeys(EDATE);

			}

		}

		else {

			Boolean isExist = UserActions.GetExistance(sdate);
			UserActions.Wait_Sec();
			if (isExist) {
				WebElement w = d.findElement(sdate);
				JavascriptExecutor executor = (JavascriptExecutor) d;
				executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", w);
				date = LocalDate.now();
				LocalDate local = date.minusDays(15);
				System.out.println("New Date: " + local);
				SDATE = local.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

				UserActions.SetValue(sdate, SDATE);
			}

			isExist = UserActions.GetExistance(edate);
			UserActions.Wait_Sec();
			if (isExist) {
				WebElement w1 = d.findElement(edate);
				JavascriptExecutor executor = (JavascriptExecutor) d;
				executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", w1);

				LocalDate ldate = date.minusDays(5);
				System.out.println("New Date: " + ldate);
				EDATE = ldate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

				UserActions.SetValue(edate, EDATE);
			}

		}

	}
	
	/**
	 * select a particular radio button from the list
	 * @param Task
	 * @throws InterruptedException
	 * @throws IOException 
	 */

	public void clickRadioButton() throws InterruptedException, IOException {

		String Task = UserActions.getCellData("UserData","SelectRadio_SLAComplianceReport",2);
		UserActions.dynamicxpathUsingAttribute(Task);

	}
	
	/**
	 * select a particular value from the dropdown
	 * @param SelectDropdownValue
	 * @throws IOException 
	 */

	public void selectValueFromDropdown() throws IOException {
		
		String SelectDropdownValue = UserActions.getCellData("UserData","SelectTask/Stq_SLAComplianceReport",2);
		Boolean isAvailable = d.findElement(stask).isDisplayed();
		if (isAvailable) {
			UserActions.SelectValue(stask, SelectDropdownValue);
		}

		isAvailable = d.findElement(sSTQ).isDisplayed();
		if (isAvailable) {

			UserActions.SelectValue(sSTQ, SelectDropdownValue);

		}
	}

	
	/**
	 * 
	 * select a particular checkbox from the list
	 * @param SelectCheckbox
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	
	public void selectValueFromCheckbox() throws InterruptedException, IOException {

		String SelectCheckbox = UserActions.getCellData("UserData","SelectSubTask/Astq_SLAComplianceReport",2);
		UserActions.dynamicxpath(SelectCheckbox);

	}
	
	public void selectValueFromCheckboxes() throws InterruptedException, IOException {

		String SelectCheckbox = UserActions.getCellData("UserData","SelectAstq_EscalatedWorkItemReport",2);
		UserActions.dynamicxpath(SelectCheckbox);

	}
	
	/**
	 * click on single work item report
	 */

	public void click_SingleWorkItem() {

		UserActions.Wait_Sec();
		UserActions.Click_JavaScript(singleworkitem);
		UserActions.Wait_Sec();

	}
	
	/**
	 * Enter value to WorkId and PNR field
	 * @param WORKID
	 * @param PNR
	 * @throws IOException 
	 */

	public void enterWorkItemIdAndPnr() throws IOException {

		String WorkId = UserActions.getCellData("UserData","WorkId_SingleWorkItemReport",2);
		String  Pnr = UserActions.getCellData("UserData","Pnr_SingleWorkItemReport",2);
		
		UserActions.SetValue(workitemid,WorkId);
		UserActions.SetValue(pnr, Pnr);

	}

	/**
	 * click on SLACompliance
	 * 
	 */
	
	public void click_SLACompliance() {

		UserActions.Wait_Sec();
		UserActions.click(SLACompliance);
		UserActions.Wait_Sec();

	}
	
	/**
	 * click on escalated work item report
	 * 
	 */
	
	public void click_EscalatedWorkItem() {

		UserActions.Wait_Sec();
		UserActions.click(escalatedworkitem);
		UserActions.Wait_Sec();

	}
	
	/**
	 * Enter past date for StartDate and EndDate field
	 * @param DateFilter
	 *
	 */
	
	public void selectDateByDateType()

	{

			Boolean isExist = UserActions.GetExistance(sdate);
			UserActions.Wait_Sec();
			if (isExist) {
				WebElement w = d.findElement(sdate);
				JavascriptExecutor executor = (JavascriptExecutor) d;
				executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", w);
				date = LocalDate.now();
				LocalDate local = date.minusDays(15);
				System.out.println("New Date: " + local);
				SDATE = local.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

				UserActions.SetValue(sdate, SDATE);
			}

			isExist = UserActions.GetExistance(edate);
			UserActions.Wait_Sec();
			if (isExist) {
				WebElement w1 = d.findElement(edate);
				JavascriptExecutor executor = (JavascriptExecutor) d;
				executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", w1);

				LocalDate ldate = date.minusDays(5);
				System.out.println("New Date: " + ldate);
				EDATE = ldate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

				UserActions.SetValue(edate, EDATE);
			}

		}
	
	/**
	 * Select STQ from the dropdown
	 * @param SelectDropdownValue
	 * @throws IOException 
	 */
	public void selectSTQ() throws IOException {

		    String  SelectDropdownValue = UserActions.getCellData("UserData","SelectStq_EscalatedWorkItemReport",2);
			UserActions.SelectValue(sSTQ, SelectDropdownValue);
	}




}
