package com.webautomation.pages;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.webautomation.base.GetPage;
import com.webautomation.base.Locator;
import com.webautomation.utils.PropFileHandler;

/*
 * @author Kaushik Banerjee
 */

public class HomePage extends GetPage{
	public WebDriver driver;
	ResourceBundle rb;

	public HomePage(WebDriver driver){
		this.driver = driver;
		this.rb=PropFileHandler.getPageObjectElements("HomePage");
	}

	public void verifyHeaderLogo(){
		Assert.assertEquals(element(rb.getString("Header_Logo_CSS"), Locator.css).getAttribute("alt"), "www.expedia.co.in");
	}

}
