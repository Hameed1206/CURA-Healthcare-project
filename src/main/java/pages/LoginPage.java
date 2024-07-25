package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy (xpath = "//div[contains(@class , 'alert-info')]/div[1]//input")
	WebElement demoUserName;
	
	@FindBy (xpath = "//div[contains(@class , 'alert-info')]/div[2]//input")
	WebElement demoPassword;
	
	@FindBy (id = "txt-username")
	WebElement userName;
	
	@FindBy (id = "txt-password")
	WebElement password;
	
	@FindBy (id = "btn-login")
	WebElement loginBtn;
	
	@FindBy (xpath = "//p[contains(@class , 'text-danger')]")
	WebElement errorMsg;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("");
		System.out.println("Login Page URL--> "+driver.getCurrentUrl());
	}
	
	static String user;
	static String pass;
	public LoginPage getDemoUserName() {
		user = demoUserName.getAttribute("Value");
		System.out.println("Username is "+user);
		return this;
	}
	public LoginPage getDemoPassword() {
		pass = demoPassword.getAttribute("Value");
		System.out.println("Password is "+pass);
		return this;
	}
	public LoginPage getUserNameForValidation(String userN) {
		userName.sendKeys(userN);
		return this;
	}
	public LoginPage getPasswordForValidation(String passW) {
		password.sendKeys(passW);
		return this;
	}
	public LoginPage getUserName() {
		userName.sendKeys(user);
		return this;
	}
	public LoginPage getPassword() {
		password.sendKeys(pass);
		return this;
	}
	public UserHomePage getLoginBtn() {
		loginBtn.click();
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("appointment")) {
			System.out.println("User logged in succesfully");
		} else {
			System.out.println(errorMsg.getText());
		}
		return new UserHomePage(driver);
	}
}
