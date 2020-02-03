package com.webautomation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/*
 * @author Kaushik Banerjee
 */

public class GetPage extends BaseClass {

	public WebElement element(String locator,Locator type){
		WebElement ele=null;
		try{
			ele=driver.findElement(findLocator(locator,type));
		}catch(NoSuchElementException e){
			e.printStackTrace();
			System.out.println("Element is not present on page");
		}
		return ele;
	}
	
	
	public By findLocator(String locator,Locator type){
		switch (type) {
		case id:
			return By.id(locator);
		case css:
			return By.cssSelector(locator);
		case classname:
			return By.className(locator);
		case name:
			return By.name(locator);
		case xpath:
			return By.xpath(locator);
		case linktext:
			return By.linkText(locator);
		default:
			return By.id(locator);
		}
	}
	
	public static void switchToDefaultFrame(){
		driver.switchTo().defaultContent();
	}
}
