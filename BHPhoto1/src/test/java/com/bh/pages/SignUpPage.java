package com.bh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bh.utilities.Driver;


public class SignUpPage {

	public SignUpPage(){
		PageFactory.initElements(Driver.getInstance(), this);
	}
	
	@FindBy(xpath="//input[@name='firstName']")
	public WebElement fName;
	
	@FindBy(xpath="//input[@name='lastName']")
	public WebElement LName;
	
	@FindBy(xpath="//input[@name='companyName']")
	public WebElement companyName;
	
	@FindBy(xpath="//input[@name='newEmailAddress']")
	public WebElement email;
	
	@FindBy(xpath="//input[@name='retypedNewEmailAddress']")
	public WebElement emailConfirm;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='retypedNewPassword']")
	public WebElement passwordConfirm;
	
	@FindBy(css=".c12.bold.fs18")
	public WebElement register;
	
	
}
