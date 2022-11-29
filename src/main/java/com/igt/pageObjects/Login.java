package com.igt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.igt.base.TestSetup;
import com.igt.utility.UserActions;

public class Login extends TestSetup {
	
	
	
	public WebDriver d;

	public Login(WebDriver d) {
		this.d = d;

	}

	public final By userid = By.xpath(p.getProperty("id_locator"));
	public final By pass = By.xpath(p.getProperty("pass_locator"));
	public final By logon = By.xpath(p.getProperty("LoginButton_locator"));

	public String GetAppUrl() {
		String appUrl = UserActions.GetCurrentUrl();
		return appUrl;
	}

	public void EnterCredentials() {
		UserActions.SetValue(userid, System.getProperty("Username"));
		UserActions.SetValue(pass, System.getProperty("Password"));

	}

	public void ClickLogOn() {
		UserActions.click(logon);
		UserActions.Wait_Sec();
	}
	

}
