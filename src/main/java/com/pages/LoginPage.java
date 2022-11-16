package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{

	private WebDriver driver;
	
	//1. By Locators
	private By username= By.xpath("//input[@name='user-name']");
	
	private By password=By.xpath("//input[@name='password']");
	
	private By loginButton=By.xpath("//input[@name='login-button']");
	
	//2. Constructor of the LoginPage class
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//3. page actions:features(behaviour)of the page the form of methods:
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterUserName(String user)
	{
		driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(loginButton).click();
	}
}
