package Infy.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//	driver.findElement(By.id("input-email")).sendKeys(username);
//	driver.findElement(By.id("input-password")).sendKeys(password);
//	driver.findElement(By.cssSelector("input[type='submit']")).click();
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(css="input[type='submit']")
	private WebElement submitButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String userName,String Password) {
		email.sendKeys(userName);
		password.sendKeys(Password);
		submitButton.click();
	}
}
