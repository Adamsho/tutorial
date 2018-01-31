package com.bh.step_definitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bh.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


//These methods run before and after every scenario.
//It must be always located within step_definition package.
//Cucumber will look for this class in this package.

public class Hook {

	@Before
	public void setUp(){
		Driver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Driver.getInstance().manage().window().maximize();
	}
	
	@After//Cucumber has it's own annotations
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "imgage/png");
		}
		//Driver.closeDriver();
	}

	
	
}
