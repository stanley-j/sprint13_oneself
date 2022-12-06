package org.locator;

import org.openqa.selenium.By;

public interface Page_Element {

	//By startEvent = By.className("");
	// By = By.xpath();
	
         By email = By.xpath("//input[@placeholder='Enter your email']");
	     By password = By.xpath("//input[@placeholder='Enter your password']");
	     By signin = By.xpath("//button[@type='submit']");
	     By welcome = By.xpath("//h1[@class='ff-roboto fs30 fw700 text-grey-h']");
	     By txtWelcome = By.xpath("//h1[text()=\"Welcome\"]");
	     By errEmail = By.xpath("//div[text()=\"Enter a valid email\"]");
	     By errPassword = By.xpath("//label[@class='form-check-label']");
	     By invaliduserandpass = By.xpath("//div[@class='toast-top-right toast-container']");
	     By passwordReq = By.xpath("//div[text()='Password is required']");
	     By table = By.xpath("//span[text()='Tables']");
}
