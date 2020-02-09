package com.webautomation.tests;

import org.testng.annotations.Test;
import com.webautomation.base.BaseClass;

public class HomePageTest extends BaseClass{
	
	@Test
	public void verifyHeaderLogo(){
		homepage.verifyHeaderLogo();
	}
	
	@Test
	public void verifyAllHeaders(){
		homepage.verifyPrimaryHeaders();
	}
}
