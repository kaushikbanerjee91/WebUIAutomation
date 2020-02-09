package com.webautomation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.webautomation.utils.Log;

/*
 * @author Kaushik Banerjee
 */

public class GetPage extends BaseClass {
	
	private final String REPLACEMENT_VALUE="{$replace}";

	public WebElement element(String locator,Locator type){
		WebElement ele=null;
		try{
			ele=driver.findElement(findLocator(locator,type));
			Log.info("Action performed on "+ele);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			Log.info("Element is not present on page");
		}
		return ele;
	}
	
	public WebElement element(String locator,Locator type,String replacement){
		WebElement ele=null;
		String replacedLocator=locator.replace(REPLACEMENT_VALUE, replacement);
		try{
			ele=driver.findElement(findLocator(replacedLocator,type));
			Log.info("Action performed on "+ele);
		}catch(NoSuchElementException e){
			e.printStackTrace();
			Log.info("Element is not present on page");
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
