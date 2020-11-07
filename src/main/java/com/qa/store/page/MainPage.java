package com.qa.store.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.store.base.TestBase;

public class MainPage extends TestBase {
 
	//OR
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement logoLabel; // isDisplayed 
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchBox; //send keys
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchBtn; // click --> SearchPage
	
	@FindBy(xpath="//a[@title='Contact Us']")
	WebElement contactLink; //click --> ContactUsPage
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInLink; //click --> SignInPage
	
	//OR -- Initialized
	public MainPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifymainPageTitle()
	{ //Title
		return driver.getTitle();
	}
	public boolean verifylogoLabel()
	{  //Logo
		return logoLabel.isDisplayed();
	}
	public SearchPage verifysearchBox(String s_box)
	{   
		searchBox.sendKeys(s_box);
		searchBtn.click();
		return new SearchPage();
	}
	public ContactUsPage verifycontactLink()
	{
		contactLink.click();
		return new ContactUsPage();
	}
    public SignInPage verifysignInLink()
    {
    	signInLink.click();
        return new SignInPage();
    }
}
