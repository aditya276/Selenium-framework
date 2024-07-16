package testComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	public static WebDriver driver;

	public static WebDriver initBrowser() throws IOException {
		FileInputStream fis = new FileInputStream(
				"F:\\SSquareit\\Automation testing\\Selenium  Practice\\SeleniumFramework\\src\\test\\java\\resources\\Properties.properties");

		Properties prop = new Properties();
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		return driver;
	}

	public static void tearDown() {
		driver.close();
	}

	public static String takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String path = System.getProperty("user.dir") + "//reports//" + testCaseName + ".jpeg";
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileHandler.copy(source, destination);
		return path;
	}
}
