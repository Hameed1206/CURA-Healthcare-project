package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class UserHomePage extends BaseClass {

	@FindBy (id = "combo_facility")
	WebElement chooseFacility;
	
	@FindBy (id = "chk_hospotal_readmission")
	WebElement chooseAdmissionCheckBox;
	
	@FindBy (xpath = "//label[@class='radio-inline']/input")
	List<WebElement> chooseHealthProgram;
	
	@FindBy (id = "txt_visit_date")
	WebElement selectDateBox;
	
	@FindBy (xpath = "//table/tbody//td[@class='day']")
	List<WebElement> selectDate;
	
	@FindBy (id = "txt_comment")
	WebElement commentBox;
	
	@FindBy (id = "btn-book-appointment")
	WebElement bookApnmt;
	
	@FindBy (id = "menu-toggle")
	WebElement menuButton;
	
	@FindBy (xpath = "//a[text() = 'History']")
	WebElement historyBtn;
	
	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("");
		System.out.println("User HomePage URL--> "+driver.getCurrentUrl());
	}

	public UserHomePage getMenuButton() {
		menuButton.click();
		return this;
	}
	public HistoryPage getHistoryBtn() {
		historyBtn.click();
		return new HistoryPage(driver);
	}
	public UserHomePage getChooseFacility(int index) {
		selectFromDropDown(chooseFacility, index);
		return this;
	}
	public UserHomePage getChooseAdmissionCheckBox() {
		chooseAdmissionCheckBox.click();
		return this;
	}
	public UserHomePage getChooseHealthProgram(int i) {
		chooseHealthProgram.get(i).click();
		return this;
	}
	public UserHomePage getSelectDate(int i) {
		selectDateBox.click();
		selectDate.get(i).click();
		return this;
	}
	public UserHomePage getCommentBox() {
		commentBox.sendKeys("General Checkup");
		return this;
	}
	public AppointmentPage getBookApnmt() {
		bookApnmt.click();
		return new AppointmentPage(driver);
	}
	
	
	
}
