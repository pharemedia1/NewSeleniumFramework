package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//Page Factory or Object Repository - "OR" 
	@FindBy(name ="username")
	WebElement username;
	
	@FindBy(name="passwod")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[href='https://api.cogmento.com/register']")
	WebElement SignUp;
	
	//Initialize all the object repository or page factory by creating a constructor of this class
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();
	}

}
