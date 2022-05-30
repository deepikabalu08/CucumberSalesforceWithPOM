package com.salesforce.pages.sdfclogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.salesforce.base.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;
    @FindBy(linkText = "Close")WebElement lightningPopUp;
	@FindBy(xpath = "//a[@class='switch-to-lightning']")WebElement lightningExperience;
	@FindBy(xpath = "//div[@id='userNav-arrow']")WebElement userMenu;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")WebElement logOut;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	public String getTitleOfTheHomePage() {
		String title=getTitleOfThePage();
		System.out.println("title of the page"+title);
		return title;
	}
	public String getTextFromLightningExperienceElement() {
		String text = readText(lightningExperience, "home page");
		return text;
	}
	public void getUserMenu() {
		clickElement(userMenu, "user Menu dropdown");
	}
	public void clicklogoutbutton() {
		clickElement(logOut, "logout button");
	}
	public void closeLightningPopUp() {	
		waitUntilVisible(lightningPopUp, "lightning popup");
		clickElement(lightningPopUp, "lightning popup");
	}

	

}
