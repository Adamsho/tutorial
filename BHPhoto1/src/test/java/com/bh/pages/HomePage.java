package com.bh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bh.utilities.Driver;


public class HomePage {

	public HomePage(){
		PageFactory.initElements(Driver.getInstance(), this);
	}
	
	
	@FindBy(css=".create-account")
	public WebElement createAccount;
	
	@FindBy(css=".user.login-account")//#js-login
	public WebElement account;
	
	@FindBy(css="#top-search-input")
	public WebElement search;
	
}
