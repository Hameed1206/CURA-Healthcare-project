package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.UtilityClass;

public class BaseClass extends UtilityClass {

	@BeforeMethod
	public static void startUp() {
		launch("chrome");
	}
	@AfterMethod
	 public static void tearDown() {
		 closeBrowser();
	 }
}
