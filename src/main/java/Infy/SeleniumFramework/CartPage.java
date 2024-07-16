package Infy.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(xpath = "//strong[text()='Total']/../following-sibling::td")
	private  WebElement totalPrice;
	
	@FindBy(xpath="//strong[text()='Checkout']")
	private WebElement checkout;
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public  String totalPrice() {
		return totalPrice.getText();
	}
	
	public void clickOnCheckOut() {
		checkout.click();
	}
}
