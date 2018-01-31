package com.bh.step_definitions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bh.pages.HomePage;
import com.bh.pages.ResultPage;
import com.bh.pages.SignUpPage;
import com.bh.utilities.ConfigurationReader;
import com.bh.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Test {
	
	HomePage homePage = new HomePage();
	SignUpPage signUpPage = new SignUpPage();
	ResultPage resultPage = new ResultPage();
	String tempEmail;

	@Given("^The user navigates the BHUrl$")
	public void the_user_navigates_the_BHUrl() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("urlBH"));
		Driver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Connected to URL");
	}

	@When("^The user goes to tmep email Url and create a temporary email$")
	public void the_user_goes_to_tmep_email_Url_and_create_a_temporary_email() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("urlTE"));
		tempEmail = Driver.getInstance().findElement(By.xpath("//input[@id='mail']")).getAttribute("value");

	}

	@When("^The user navigates back to BHUrl$")
	public void the_user_navigates_back_to_BHUrl() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("urlBH"));
	}

	@When("^The user goes to My Account and clicks the create a B&H Account$")
	public void the_user_goes_to_My_Account_and_clicks_the_create_a_B_H_Account() throws Throwable {
		Actions action = new Actions(Driver.getInstance());
		Thread.sleep(1000);
		action.moveToElement(homePage.account).perform();
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);
		wait.until(ExpectedConditions.visibilityOf(homePage.createAccount));
		homePage.createAccount.click();
		
	}

	@When("^The user fills out the form$")
	public void the_user_fills_out_the_form() throws Throwable {
		Driver.getInstance().switchTo().frame("loginframe");
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);
		wait.until(ExpectedConditions.visibilityOf(signUpPage.fName));
		signUpPage.fName.sendKeys(ConfigurationReader.getProperty("fName"));
		signUpPage.LName.sendKeys(ConfigurationReader.getProperty("LName"));
		signUpPage.companyName.sendKeys(ConfigurationReader.getProperty("companyName"));
		signUpPage.email.sendKeys(tempEmail);
		signUpPage.emailConfirm.sendKeys(tempEmail);
		signUpPage.password.sendKeys(ConfigurationReader.getProperty("password"));
		signUpPage.passwordConfirm.sendKeys(ConfigurationReader.getProperty("password"));
		//Driver.getInstance().switchTo().defaultContent();
	}

	@When("^The user takes a screen-shot and store it$")
	public void the_user_takes_a_screen_shot_and_store_it() throws Throwable {
		File picture = ((TakesScreenshot)Driver.getInstance()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(picture, new File("./target/ScreenShot.png"));
	}

	@When("^The user clicks the register$")
	public void the_user_clicks_the_register() throws Throwable {
		signUpPage.register.click();
	}

	@When("^The user navigate to main page$")
	public void the_user_navigate_to_main_page() throws Throwable {
		String title ="B&H Photo Video Digital Cameras, Photography, Camcorders";
		Assert.assertEquals(title, Driver.getInstance().getTitle());
	}

	@When("^The user search for item \"([^\"]*)\"$")
	public void the_user_search_for_item(String itemFromFeatureFile) throws Throwable {
	    homePage.search.sendKeys(itemFromFeatureFile+Keys.ENTER);
	}

	@Then("^The user captures the first price and decide whether it is more than the budget and prints an advise$")
	public void the_user_captures_the_first_price_and_decide_whether_it_is_more_than_the_budget_and_prints_an_advise()
			throws Throwable {
		String firstPrice = resultPage.price.getText().substring(1,6).replace(",", "");
		//String firstPrice = resultPage.price.getText().replace("$", "").replace(",", "");
		int myNumber = Integer.parseInt(firstPrice);
		if (myNumber <= Integer.parseInt(ConfigurationReader.getProperty("budget"))) {
			System.out.println("Great!!! We can buy it.");
		}
		else
			System.out.println("Item price is out of budget limit");
	}
}
