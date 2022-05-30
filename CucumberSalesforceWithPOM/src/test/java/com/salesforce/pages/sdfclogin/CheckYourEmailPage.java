package com.salesforce.pages.sdfclogin;

import org.openqa.selenium.WebDriver;

import com.salesforce.base.BasePage;

public class CheckYourEmailPage extends BasePage {
	
	public CheckYourEmailPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getTitleOfCheckYourEmailPage() {
		String title= getTitleOfThePage();
		System.out.println("title of the page"+title);
		return title;
	}

}
