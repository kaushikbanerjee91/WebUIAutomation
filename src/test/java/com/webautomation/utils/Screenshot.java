package com.webautomation.utils;

import com.webautomation.base.BaseClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

public class Screenshot extends BaseClass{

	public static void takeScreenshot(String path,String name){
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_a");
		Date date = new Date();
		String date_time = dateFormat.format(date);
		
		File file = new File(path + File.separator + date_time);
		boolean exists = file.exists();
		if (!exists) {
			new File(path + File.separator + name + File.separator
					+ date_time).mkdir();
		}
		TakesScreenshot scrshot= (TakesScreenshot) driver;
		File scrfile= scrshot.getScreenshotAs(OutputType.FILE);
		String saveImgFile = path + File.separator + name
				+ File.separator + date_time + File.separator
				+ "screenshot.png";
		File destfile = new File(saveImgFile);
		try {
			FileUtils.copyFile(scrfile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void takeScreenshotOnException(ITestResult result,String path,String name){
		if(result.getStatus() == ITestResult.FAILURE){
			if(driver!=null){
				takeScreenshot(path,name);
			}
		}
	}
}
