package com.freecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage; // Define this loginpage variable in order to use it in all methods if wanted
	
	// Create a constructor and use super keyword to call TestBase class constructor
	public LoginPageTest()
	{
		// Using super keyword will call TestBase class constructor.
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization(); //This call the initialization method in TestBase class
		
		// Create an Object of Login Page class
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest()
	{
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "CRM");
		
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
		
	}

}
