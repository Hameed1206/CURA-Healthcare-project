package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass {

public static WebDriver driver;
	
	public static void launch(String browser) {
		
		if(browser.equals("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		} else if (browser.equals("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		} else {
		driver = new ChromeDriver();	
		}
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));	
	}
	public static void explicitWait(WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void selectFromDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public static String captureScreenshot() throws IOException {
		TakesScreenshot tk = (TakesScreenshot)driver;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		File file = tk.getScreenshotAs(OutputType.FILE);
		long timeMillis = System.currentTimeMillis();
		String title = driver.getTitle();
		String snapPath = "C:\\Users\\91936\\eclipse-workspace\\CURA_Healthcare_Service\\Snaps\\"+title+"-"+timeMillis+".jpg";
		File path = new File(snapPath);
		Files.copy(file, path);
		return snapPath;
	}
	public static XSSFSheet readValueFromExcel(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\91936\\eclipse-workspace\\CURA_Healthcare_Service\\Excel_File\\CURA_Healthcare_Service.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = wBook.getSheet(sheetName);
		return sheet;
	}
	public static void closeBrowser() {
		 driver.quit();
	}
}
