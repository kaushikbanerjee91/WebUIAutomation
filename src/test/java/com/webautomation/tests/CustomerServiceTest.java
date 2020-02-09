package com.webautomation.tests;

import org.testng.annotations.Test;

import com.webautomation.base.BaseClass;

public class CustomerServiceTest extends BaseClass{
	
	@Test
	public void verifyCustomerServiceTitle(){
		homepage.clickOnSupport();
		homepage.clickOnCustomerSupport();
		customerservicepage.verifyCustomerServiceTitle();
	}
	

}
