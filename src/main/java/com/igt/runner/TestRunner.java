package com.igt.runner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import com.igt.base.TestSetup;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/main/resources/Feature"}, glue = { "com.igt.stepDefinition",
		"com.igt.base" },
monochrome = true, dryRun =false,tags=("@login or @task or @subtask or @action or @subaction or @mapping or @posAndpcc or @stq or @report or @agentSkills or @languageSkills or @dashboard or @brand"),
plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

)
public class TestRunner extends AbstractTestNGCucumberTests   {

	@AfterSuite()
	public void last() throws IOException {
		
/*		   XSSFFormulaEvaluator.evaluateAllFormulaCells(TestSetup.workbook);
		  FileOutputStream out = new FileOutputStream(TestSetup.filename);
          TestSetup.workbook.write(out); 
          TestSetup.workbook.close();*/
		 TestSetup.d.quit();
		//tags=("@login or @task or @subtask or @action or @subaction or @mapping or @posAndpcc or @stq or @report or @agentSkills or @languageSkills or @dashboard or @brand")

		 
		 
	}
}
