package com.igt.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.igt.base.TestSetup;
import com.igt.utility.UserActions;

public class Dashboard extends TestSetup {
	
	
	public WebDriver d;

	public Dashboard(WebDriver d) {
		this.d = d;

	}
	
	public final By dashboard = By.xpath(p.getProperty("Dashboard_locator"));
	public final By agentworkitem = By.xpath(p.getProperty("AgentAndWorkItem_locator"));
	public final By site = By.xpath(p.getProperty("site_locator"));
	public final By sitepartitions = By.xpath(p.getProperty("sitepartitions_locator"));
	public final By duration = By.xpath(p.getProperty("duration_locator"));
	public final By search = By.xpath(p.getProperty("searchbutton_locator"));
	public final By stqOrastq = By.xpath(p.getProperty("stq/astq_locator"));
	public final By expandarrow = By.xpath(p.getProperty("arrow_locator"));
	public final By workitemstatus = By.xpath(p.getProperty("workitemstatus_locator"));
	public final By newitems = By.xpath(p.getProperty("newitems_locator"));
	
	
	
	
	public void click_Dashboard()
	{
		UserActions.Click_JavaScript(dashboard);
	}
	
	public void click_agentworkitem()
	{
		boolean isVisible = UserActions.GetDisplayed(agentworkitem);
		if(isVisible)
		{
		UserActions.Click_JavaScript(agentworkitem);
		}
		else{		
			UserActions.Click_JavaScript(dashboard);
			UserActions.Click_JavaScript(agentworkitem);	
		}
	}
	
	public void select_Site_Sitepartitions_Duration() throws IOException
	{
		String dsite = UserActions.getCellData("UserData","Site_AgentWorkItem",2);
		UserActions.SelectValue(site, dsite);
		String dsitepartitions = UserActions.getCellData("UserData","SitePartitions_AgentWorkItem",2);
		UserActions.SelectValue(sitepartitions, dsitepartitions);
		String dduration = UserActions.getCellData("UserData","Duration_AgentWorkItem",2);
		//String dduration = UserActions.getNumericFormulaCellData("UserData","Duration_AgentWorkItem",2);
		UserActions.SelectValue(duration, dduration);
	}
	
	public void select_Stq() throws IOException, InterruptedException
	{
		String dstq = UserActions.getCellData("UserData","Stq_AgentWorkItem",2);
		UserActions.dynamicxpath(dstq);
		
	}
	
	public void click_Search()
	{
		UserActions.Click_JavaScript(search);
	}
	
	public void click_StqAstq()
	{
		boolean isVisible = UserActions.GetDisplayed(stqOrastq);
		if(isVisible){
		UserActions.Click_JavaScript(stqOrastq);
	     }
		else{
			
			UserActions.Click_JavaScript(dashboard);
			UserActions.Click_JavaScript(stqOrastq);
		}
	}
	
	public void click_ExpandArrow()
	{
		UserActions.mouseHover(newitems);
		UserActions.Click_JavaScript(expandarrow);
	}
	
	public void verifyExpandDialog()
	{
		UserActions.Wait_Sec();
		boolean isVisible = UserActions.GetDisplayed(workitemstatus);
		if(isVisible)
		{
			ExtentCucumberAdapter.addTestStepLog("Expand arrow verified successfully.");
			
		}
		
		else{
			
			ExtentCucumberAdapter.addTestStepLog("Error occured in expand arrow.");
		}
		
	}
	
	public void expandAllSTQ()
	{
		int stqsize = d.findElements(By.xpath("//table[@class='table ']//td[contains(@id,'stq')]")).size();
		for(int i=1;i<=stqsize;i++)
		{
			UserActions.Wait_Sec();
			d.findElement(By.xpath("(//table[@class='table ']//td[contains(@id,'stq')])["+i+"]")).click();
			
		}
	}
	
	public void verifyCompletedWorkItemsCount()
	{

		int l = d.findElements(By.xpath("//table[@class='table ']//tr[@class='accordion-toggle collapsed']")).size();		
		for(int k = 1;k<=l;k++)
		{	
		//d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])[1]"));
		String stqname = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[contains(@id,'stq')]")).getText();
		String completedworkitems_count = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[2]")).getText();	
		ExtentCucumberAdapter.addTestStepLog("Completed work items count for"+ stqname + " is " +completedworkitems_count);	
		
		}			
	}
	
	public void verifyNewWorkItemsCount()
	{

		int l = d.findElements(By.xpath("//table[@class='table ']//tr[@class='accordion-toggle collapsed']")).size();		
		for(int k = 1;k<=l;k++)
		{	
		//d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])[1]"));
		String stqname = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[contains(@id,'stq')]")).getText();
		String newworkitems_count = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[3]")).getText();	
		ExtentCucumberAdapter.addTestStepLog("New work items count for"+ stqname + " is " +newworkitems_count);	
		
		}			
	}
	
	public void verifySLABreachedCount()
	{

		int l = d.findElements(By.xpath("//table[@class='table ']//tr[@class='accordion-toggle collapsed']")).size();		
		for(int k = 1;k<=l;k++)
		{	
		//d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])[1]"));
		String stqname = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[contains(@id,'stq')]")).getText();
		String slacount = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[4]")).getText();	
		ExtentCucumberAdapter.addTestStepLog("SLA breached count for"+ stqname + " is " +slacount);	
		
		}			
	}
	
	public void verifyAgentsAssignedCount()
	{

		int l = d.findElements(By.xpath("//table[@class='table ']//tr[@class='accordion-toggle collapsed']")).size();		
		for(int k = 1;k<=l;k++)
		{	
		//d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])[1]"));
		String stqname = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[contains(@id,'stq')]")).getText();
		String agentassigned_count = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[5]")).getText();	
		ExtentCucumberAdapter.addTestStepLog("Agent Assigned count for"+ stqname + " is " +agentassigned_count);	
		
		}			
	}
	
	public void verifyAgentsWorkingCount()
	{

		int l = d.findElements(By.xpath("//table[@class='table ']//tr[@class='accordion-toggle collapsed']")).size();		
		for(int k = 1;k<=l;k++)
		{	
		//d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])[1]"));
		String stqname = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[contains(@id,'stq')]")).getText();
		String agentworking_count = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[6]")).getText();	
		ExtentCucumberAdapter.addTestStepLog("Agents working count for"+ stqname + " is " +agentworking_count);	
		
		}			
	}
	
	public void verifyAgentsOnBreakCount()
	{

		int l = d.findElements(By.xpath("//table[@class='table ']//tr[@class='accordion-toggle collapsed']")).size();		
		for(int k = 1;k<=l;k++)
		{	
		//d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])[1]"));
		String stqname = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[contains(@id,'stq')]")).getText();
		String agentonbreak_count = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[7]")).getText();	
		ExtentCucumberAdapter.addTestStepLog("Agents on break count for"+ stqname + " is " +agentonbreak_count);	
		
		}			
	}
	
	public void verifyAgentsIdleCount()
	{

		int l = d.findElements(By.xpath("//table[@class='table ']//tr[@class='accordion-toggle collapsed']")).size();		
		for(int k = 1;k<=l;k++)
		{	
		//d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])[1]"));
		String stqname = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[contains(@id,'stq')]")).getText();
		String agentidle_count = d.findElement(By.xpath("(//table[@class='table ']//tr[@class='accordion-toggle collapsed'])["+k+"]//td[8]")).getText();	
		ExtentCucumberAdapter.addTestStepLog("Agents idle count for"+ stqname + " is " +agentidle_count);	
		
		}			
	}
	
}
