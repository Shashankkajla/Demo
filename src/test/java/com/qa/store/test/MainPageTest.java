package com.qa.store.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.store.base.TestBase;
import com.qa.store.page.ContactUsPage;
import com.qa.store.page.MainPage;
import com.qa.store.page.SignInPage;

public class MainPageTest extends TestBase
{
	//InstanceVars.
	MainPage mainPage;
	ContactUsPage contactUsPage;
	SignInPage signInPage;
	
	public MainPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initilization();
	    mainPage = new MainPage();
	    contactUsPage = new ContactUsPage();
	    signInPage =  new SignInPage();
	}
	
	@Test(priority=1)
	public void verifymainPageTitleTest()
	{
		String value = mainPage.verifymainPageTitle();
		Assert.assertEquals(value, "My Store", "If value is not match Fail TestCase");
	}
	@Test(priority=2)
	public void verifylogoLabelTest()
	{
		boolean flag = mainPage.verifylogoLabel();
		Assert.assertTrue(flag, "Fail Tc if logo is not present");
	}
	@Test(priority=3)
	public void verifycontactLinkTest()
	{
	 contactUsPage= mainPage.verifycontactLink();
	}
	@Test(priority=4)
	public void verifysignInLinkTest()
	{
	 signInPage = mainPage.verifysignInLink();
	}
	
	// 1 Tc remaining
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}			
	
 }
