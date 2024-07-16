package Infy.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

//	private WebElement myAccount;
//	private WebElement loginButton;
//	
//	public LandingPage(WebDriver driver) {
//		myAccount=driver.findElement(By.xpath("//a[@title='My Account']"));
//		loginButton=driver.findElement(By.xpath("//a[text()='Login']"));
//	}
	
	//using pageFactory
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginButton;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToLoginPage() {
		myAccount.click();
		loginButton.click();
	}
}
