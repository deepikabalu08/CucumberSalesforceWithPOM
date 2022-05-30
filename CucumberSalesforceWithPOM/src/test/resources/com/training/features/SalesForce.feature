
Feature: Login to salesforce application

Background:
	Given User open salesforce application
 @Testcase1
  Scenario: Login with valid username and clear password field
    When User on "SDFCLoginPage"
    When User enters value into text box username as "deepikabalusamy-e5pl@force.com"
    When User clear password field
    When Click on Login button
    Then verify error message as "Please enter your password."

  @Testcase2
  Scenario: Login with valid username and valid password
    When User on "SDFCLoginPage"
    When User enters value into text box username as "deepikabalusamy-e5pl@force.com"
    When User enters value into text box password as "danbrown8"
    When Click on Login button
    Then verify text as "Welcome to your free trial"
   
  @Testcase3 
  Scenario: Login with valid username and password and check remember me checkbox
    When User on "SDFCLoginPage"
    When User enters value into text box username as "deepikabalusamy-e5pl@force.com"
    When User enters value into text box password as "danbrown8"
    When User select remember me checkbox
    When Click on Login button
    When User close lightning popup window
    When User on "HomePage"
    When Click on user menu dropdown
    When Click on Logout button
    When User on "SDFCLoginPage"
    Then verify username field is present with username "deepikabalusamy-e5pl@force.com"

@Testcase4  
  Scenario: Test forgot password
    When User on "SDFCLoginPage"
    When User click on forgot password
    When User on "ForgotPasswordPage"
    When User enter a username as "deepikabalusamy-e5pl@force.com"   
    When Click on Continue button
    When User on "CheckYourEmailPage"
    Then verify page title as "Check Your Email | Salesforce"
  

@Testcase5  
  Scenario: Login with 123 username and 22131 password
    When User on "SDFCLoginPage"
    When User enters value into username field as "123"
    When User enters value into password field as "22131"
    When Click on Login button
    Then verify text displayed as "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
  
  