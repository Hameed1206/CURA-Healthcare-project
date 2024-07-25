package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HistoryPage extends BaseClass {

	@FindBy (xpath = "//section/div/div[2]//div[@class='panel-heading']")
	WebElement apnmtDate;
	
	@FindBy (xpath = "//section/div/div[1]//p")
	WebElement apnmtStatus;
	
	@FindBy (xpath = "//a[text()='Logout']")
	WebElement logoutBtn;
	
	@FindBy (id = "menu-toggle")
	WebElement menuButton; 
	
	public HistoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("");
		System.out.println("History Page URL--> "+driver.getCurrentUrl());
	}

	public HistoryPage getApnmtStatus() {
		System.out.println("Appointment date is "+apnmtDate.getText());
		return this;
	}
	public HistoryPage getHistory() {
		System.out.println("Appointment date is "+apnmtStatus.getText());
		return this;
	}
	public HistoryPage getMenuButton() {
		menuButton.click();
		return this;
	}
	public HomePage getLogoutBtn() {
		System.out.println("Logging out");
		System.out.println("");
		logoutBtn.click();
		return new HomePage(driver);
	}
	
	
	
}
