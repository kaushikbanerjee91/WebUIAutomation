package com.webautomation.pages;

import java.util.List;
import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.webautomation.base.GetPage;
import com.webautomation.base.Locator;
import com.webautomation.utils.Log;
import com.webautomation.utils.PropFileHandler;

/*
 * @author Kaushik Banerjee
 */

public class HomePage extends GetPage{
	public WebDriver driver;
	ResourceBundle rb;
	final String listOfPrimaryHeadersName[]={"hotel","flight","package",
			"car","activity","lastminute","deals",
			"rewards","app","travelblog"};

	public HomePage(WebDriver driver){
		this.driver = driver;
		this.rb=PropFileHandler.getPageObjectElements("HomePage");
	}

	public void verifyHeaderLogo(){
		Assert.assertEquals(element(rb.getString("Header_Logo_CSS"), Locator.css).getAttribute("alt"), "www.expedia.co.in");
		Log.info("User verified header logo");
	}

	public void clickOnSupport(){
		element(rb.getString("Header_Support_ID"), Locator.id).click();
		Log.info("User clicked on support header");
	}

	public void clickOnCustomerSupport(){
		element(rb.getString("Customer_Support_ID"), Locator.id).click();
		Log.info("User clicked to open customer support service");
	}

	public void verifyPrimaryHeaders(){
		for(String header:listOfPrimaryHeadersName){
			Assert.assertTrue(element(rb.getString("Primary_Header_ID"), Locator.id, header).isEnabled());
			Log.info("User verifies that "+header+" is enabled");
		}
	}

}
