package com.bh.runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)//these two annotations make a file a cucumber runner file.
@CucumberOptions(
		plugin = {"html:target/cucumber-reports", "json:target/cucumber.json"},
		features = "./src/test/resources/feature",
		glue = "com/bh/step_definitions",
		tags = "@Regression",// @BHphoto  @Smoke
		dryRun = true
		)//by default is false.
//test -Dcucumber.options="--tags @Smoke" THIS WILL OVERRIDE THETAG WE HAVE IN OUR
// CUCUS RUNNER AND USES THE ONE WE PROVIDED.
public class CukesRunner {

}