package com.igt.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.igt.base.TestSetup;

public class Util extends TestSetup {

	public static void purgeDirectory(File dir) {
		for (File file : dir.listFiles()) {
			if (file.isDirectory())
				purgeDirectory(file);
			file.delete();
		}
	}

	public static void TakeScreenShot(WebDriver d, long ms) {
		try {
			File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			// String Pass = scenario.getName()+"_Pass";
			FileUtils.copyFile(src,
					new File(System.getProperty("user.dir") + "//PassedScreenShot//" + ms + "_Pass" + ".png"));

		}

		catch (Exception e) {
			e.getMessage();
		}

	}

	public static byte[] getByteScreenShot(WebDriver d) throws IOException {
		File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		byte[] image = FileUtils.readFileToByteArray(src);
		return image;
	}

}
