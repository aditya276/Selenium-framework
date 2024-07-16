package ssqareit.selenium.framework_part2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage2 {

	@FindBy(css="button.close")
	private WebElement closeButton;
	
	@FindBy(xpath="(//a[text()='Nikon D300'])[2]/following-sibling::span")
	private WebElement successMessage;
	
	public CheckoutPage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void clickCloseButton() {
		closeButton.click();
	}
	
	public String getSuccessMessage() {
		return successMessage.getText();
	}
	
}
