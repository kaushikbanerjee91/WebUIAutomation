package com.webautomation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.webautomation.base.GetPage;
import com.webautomation.base.Locator;
import com.webautomation.utils.Log;
import com.webautomation.utils.PropFileHandler;

public class CustomerServicePage extends GetPage{
	
	public WebDriver driver;
	ResourceBundle rb;

	public CustomerServicePage(WebDriver driver){
		this.driver = driver;
		this.rb=PropFileHandler.getPageObjectElements("CustomerServicePage");
	}
	
	public void verifyCustomerServiceTitle(){
		Assert.assertTrue(element(rb.getString("Customer_Service_Title_XPATH"), Locator.xpath).isDisplayed());
		Log.info("Customer service title is present");
	}
}
