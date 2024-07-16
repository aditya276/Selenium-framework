package ssqareit.selenium.framework_part2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage2 {

	WebDriver driver;
	
	@FindBy(xpath = "//strong[text()='Total']/../following-sibling::td")
	private  WebElement totalPrice;
	
	@FindBy(xpath="//strong[text()='Checkout']")
	private WebElement checkout;
	public CartPage2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public  String totalPrice() {
		return totalPrice.getText();
	}
	
	public CheckoutPage2 clickOnCheckOut() {
		checkout.click();
		CheckoutPage2 checkoutPage=new CheckoutPage2(driver);
		return checkoutPage;
	}
}
