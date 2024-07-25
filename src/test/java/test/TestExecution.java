package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import base.BaseClass;
import pages.HomePage;

public class TestExecution extends BaseClass {

	//All reporting variables made Instance
	ExtentSparkReporter crtreport;
	ExtentReports extent;
	ExtentTest snap;
	
	//DataProvider method having information about test datas in excel
	@DataProvider (name="SignIn Validation")
	public Object[][] signInTestDataE() throws IOException {
		Object[][] datas = TestData.SignIndatas();
		return datas;
	}
	
    //Constructor to invoke reporting activities
    // We are asking report to track activities of all test and prepare a report with screenshots
	public TestExecution(String name) {
		long timeMillis = System.currentTimeMillis();
		String reportPath = "C:\\Users\\91936\\eclipse-workspace\\CURA_Healthcare_Service\\target\\CURA_Healthcare_Service_"+timeMillis+".html";
		crtreport = new ExtentSparkReporter(reportPath);
		crtreport.config().setReportName(name);
		crtreport.config().setDocumentTitle("Web Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(crtreport);
	}
	
	// Validating sign in function using decision table technique by passing different combination of values
	@Test(dataProvider = "SignIn Validation", priority = 1)
	public void validateloginFunction(String s1, String s2, String s3) throws IOException {
		HomePage home = new HomePage(driver);
		TestExecution exe = new TestExecution("Validate Login Function");
		snap = extent.createTest("Validate Login Function");
		try{ 
		System.out.println(s1);
		home.getMenuButton().getLoginButton()
		.getUserNameForValidation(s2).getPasswordForValidation(s3).getLoginBtn();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		} try {
			snap.addScreenCaptureFromPath(captureScreenshot(), s1);
			snap.log(Status.PASS, s1);
			extent.flush();
	    } catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		} 
	}
	
	//Validating appointment booking feature
	@Test(priority = 2)
	public void validateAppointmentBooking() throws IOException {
		HomePage home = new HomePage(driver);
		TestExecution exe = new TestExecution("Validate Appointment Booking");
		snap = extent.createTest("Validate Appointment Booking");
		try{ 
		home.getMenuButton().getLoginButton()
		.getDemoUserName().getDemoPassword().getUserName().getPassword().getLoginBtn()
		.getChooseFacility(0).getChooseHealthProgram(0).getSelectDate(30)
		.getCommentBox().getBookApnmt().getCnfrmMessage();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		} try {
			snap.addScreenCaptureFromPath(captureScreenshot(), "Validate Appointment Booking");
			snap.log(Status.PASS, "Validate Appointment Booking");
			extent.flush();
	      } catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		} 
		
	}
	
	//Validating the history field for booked appointments
	@Test(priority = 3)
	public void validateAppointmentBookingInHistoryField() throws IOException {
		HomePage home = new HomePage(driver);
		TestExecution exe = new TestExecution("Validate Appointment Booking in History field");
		snap = extent.createTest("Validate Appointment Booking in History field");
		try{ 
		home.getMenuButton().getLoginButton()
		.getDemoUserName().getDemoPassword().getUserName().getPassword().getLoginBtn()
		.getChooseFacility(1).getChooseAdmissionCheckBox().getChooseHealthProgram(1).getSelectDate(28)
		.getCommentBox().getBookApnmt().getCnfrmMessage().getMenuButton().getHistoryBtn().getApnmtStatus();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		} try {
			snap.addScreenCaptureFromPath(captureScreenshot(), "Validate Appointment Booking in History field");
			snap.log(Status.PASS, "Validate Appointment Booking in History field");
			extent.flush();
	    } catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		} 
	}
	
	//Validating history field without booking
	@Test(priority = 4)
		public void validateHistoryFieldWithoutBooking() throws IOException {
			HomePage home = new HomePage(driver);
			TestExecution exe = new TestExecution("Validate History Field Without Booking");
			snap = extent.createTest("Validate History Field Without Booking");
			try{ 
			home.getMenuButton().getLoginButton()
			.getDemoUserName().getDemoPassword().getUserName().getPassword().getLoginBtn()
			.getChooseFacility(1).getMenuButton().getHistoryBtn().getHistory();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage() +" "+ e.getClass());
			} try {
				snap.addScreenCaptureFromPath(captureScreenshot(), "Validate History Field Without Booking");
				snap.log(Status.PASS, "Validate History Field Without Booking");
				extent.flush();
	        } catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage() +" "+ e.getClass());
				} 
		}
	      
	//Validating end to end functionality
	@Test(priority = 5)
	public void validateEndToEnd() throws IOException {
		HomePage home = new HomePage(driver);
		TestExecution exe = new TestExecution("Validate End To End");
		snap = extent.createTest("Validate End To End");
		try{ 
		home.getMenuButton().getLoginButton()
		.getDemoUserName().getDemoPassword().getUserName().getPassword().getLoginBtn()
		.getChooseFacility(2).getChooseAdmissionCheckBox().getChooseHealthProgram(2).getSelectDate(26)
		.getCommentBox().getBookApnmt().getCnfrmMessage().getMenuButton().getHistoryBtn().getApnmtStatus().getMenuButton().getLogoutBtn();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		} try {
			snap.addScreenCaptureFromPath(captureScreenshot(), "Validate End To End");
			snap.log(Status.PASS, "Validate End To End");
			extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		} 
	}

}
