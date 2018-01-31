@BHphoto @Smoke @Regression
Feature: BH Great Electronic store 
Scenario: Login and price test 
	Given The user navigates the BHUrl 
	When The user goes to tmep email Url and create a temporary email 
	And The user navigates back to BHUrl 
	And The user goes to My Account and clicks the create a B&H Account 
	And The user fills out the form 
	And The user takes a screen-shot and store it 
	And The user clicks the register 
	And The user navigate to main page 
	When The user search for item "Canon eos 5d mark iii" 
	Then The user captures the first price and decide whether it is more than the budget and prints an advise 
