package ssqareit.selenium.framework_part2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
//	driver.findElement(By.id("input-email")).sendKeys(username);
//	driver.findElement(By.id("input-password")).sendKeys(password);
//	driver.findElement(By.cssSelector("input[type='submit']")).click();
	
	static WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(css="input[type='submit']")
	private WebElement submitButton;
	
	public LoginPage2(WebDriver driver) {
		LoginPage2.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage2 Login(String userName,String Password) {
		email.sendKeys(userName);
		password.sendKeys(Password);
		submitButton.click();
		HomePage2 hp=new HomePage2(driver);
		return hp;
	}
}
