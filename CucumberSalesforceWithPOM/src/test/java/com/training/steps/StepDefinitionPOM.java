package com.training.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.salesforce.pages.sdfclogin.CheckYourEmailPage;
import com.salesforce.pages.sdfclogin.ForgotPasswordPage;
import com.salesforce.pages.sdfclogin.HomePage;
import com.salesforce.pages.sdfclogin.SDFCLoginPage;
import com.salesforce.utilities.ForceCommonUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionPOM {
	
	WebDriver driver;
	SDFCLoginPage login;
	HomePage home;
	ForgotPasswordPage forgotpswd;
	CheckYourEmailPage email;
	
	// we can have multiple before and after method using order parameter mention order sequence
	@Before(order=0)
	public void setUp1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}	
	@Before(order=1) 
	public void setUp2() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}	
	
	@Given("User open salesforce application")
	public void user_open_salesforce_application() {
	   driver.get("https://login.salesforce.com/");
	}

	@When("User on {string}")
	public void user_on(String page) {
		if(page.equalsIgnoreCase("sdfcloginpage")) {
			login = new SDFCLoginPage(driver);
		}
		else if(page.equalsIgnoreCase("homepage")) {
			 home = new HomePage(driver);
		}
		else if(page.equalsIgnoreCase("forgotpasswordpage")) {
			forgotpswd = new ForgotPasswordPage(driver);
		}	
		else if(page.equalsIgnoreCase("checkyouremailpage")) {
			email = new CheckYourEmailPage(driver);
		}
	}
	@When("User enters value into text box username as {string}")
	public void user_enters_value_into_text_box_username_as(String data) {
		login = new SDFCLoginPage(driver);
		login.enterUsername(data);
		System.out.println("user name entered");
	}

	@When("User clear password field")
	public void user_clear_password_field() {
		String password = ForceCommonUtilities.getApplicationProperty("password");
		login.clearPasswordfield(password);
		System.out.println("password field cleared");
	   
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		login.clickloginbutton();
		System.out.println("login button clicked");
	   
	}

	@Then("verify error message as {string}")
	public void verify_error_message_as(String expected) {
		String actual = login.getTextFromErrorMessage();
		Assert.assertEquals(actual, expected);	    
	}
	
	@When("User enters value into text box password as {string}")
	public void user_enters_value_into_text_box_password_as(String data) {
		login.enterPassword(data);
		System.out.println("password entered");
	}

	@Then("verify text as {string}")
	public void verify_text_as(String expected) {
		HomePage home = new HomePage(driver);
		String actual = home.getTextFromLightningExperienceElement();
		Assert.assertEquals(actual, expected);
	}
	@When("User select remember me checkbox")
	public void user_select_remember_me_checkbox() {
		login.clickrememberMeCheckBox();	    
	}
	@When("User close lightning popup window")
	public void user_close_lightning_popup_window() {
		 home = new HomePage(driver);
		home.closeLightningPopUp();
	}

	@When("Click on user menu dropdown")
	public void click_on_user_menu_dropdown() {
		home.getUserMenu();	   
	}

	@When("Click on Logout button")
	public void click_on_logout_button() {
		home.clicklogoutbutton();
	}

	@Then("verify username field is present with username {string}")
	public void verify_username_field_is_present_with_username(String expected) {
		login = new SDFCLoginPage(driver);
		String actual = login.checkUserNameField();
		Assert.assertEquals(actual, expected);   
	}	
	@When("User click on forgot password")
	public void user_click_on_forgot_password() {
		login.clickForgotPassword();
	   
	}
	@When("User enter a username as {string}")
	public void user_enter_a_username_as(String data) {
		String userName = ForceCommonUtilities.getApplicationProperty("username");
		forgotpswd = new ForgotPasswordPage(driver);
		forgotpswd.enterUserName(userName);
	   
	}
	@When("Click on Continue button")
	public void click_on_continue_button() {
		forgotpswd.clickContinueButton();	   
	}
	@Then("verify page title as {string}")
	public void verify_page_title_as(String expected) {
		String actual= CheckYourEmailPage.getTitleOfThePage();
		Assert.assertEquals(actual, expected);
	   
	}
	@When("User enters value into username field as {string}")
	public void user_enters_value_into_username_field_as(String string) {
		login.enterWrongUserName();    
	}

	@When("User enters value into password field as {string}")
	public void user_enters_value_into_password_field_as(String string) {
		login.enterWrongPassword();	    
	}
	@Then("verify text displayed as {string}")
	public void verify_text_displayed_as(String expected) {
		String actual = login.getTextFromWrongUsernameAndPassword();
		Assert.assertEquals(actual, expected);
	}

	
	
	
	
	
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
