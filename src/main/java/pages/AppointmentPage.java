package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class AppointmentPage extends BaseClass {

	@FindBy (xpath = "//section/div[@class='container']/div/div")
	List<WebElement> cnfrmMessage;
	
	@FindBy (id = "menu-toggle")
	WebElement menuButton;
	
	@FindBy (xpath = "//a[text() = 'History']")
	WebElement historyBtn;
	
	public AppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("");
		System.out.println("Appointment Page URL--> "+driver.getCurrentUrl());
	}

	public AppointmentPage getCnfrmMessage() {
		for (int i = 0; i < cnfrmMessage.size()-1; i++) {
			System.out.print(cnfrmMessage.get(i).getText());
		}
		return this;
	}
	public AppointmentPage getMenuButton() {
		menuButton.click();
		return this;
	}
	public HistoryPage getHistoryBtn() {
		historyBtn.click();
		return new HistoryPage(driver);
	}
	
	
}
