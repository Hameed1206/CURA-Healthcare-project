package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy (id = "menu-toggle")
	WebElement menuButton;
	
	@FindBy (xpath = "//a[text() = 'Login']")
	WebElement loginButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Home Page URL--> "+driver.getCurrentUrl());
	}
	
	public HomePage getMenuButton() {
		menuButton.click();
		return this;
	}
	public LoginPage getLoginButton() {
		loginButton.click();
		return new LoginPage(driver);
	}
	
}
