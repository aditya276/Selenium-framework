package Infy.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePageClass;

public class ProductDetails extends BasePageClass{
//    //first validation=external indexing and child to parent using ..
//driver.findElement(By.xpath("(//h1[text()='Nikon D300']/../div/following-sibling::ul)[2]/li/h2")).getText();
//	driver.findElement(By.id("input-quantity")).clear();
//	driver.findElement(By.id("input-quantity")).sendKeys("2");
//	driver.findElement(By.cssSelector("button#button-cart")).click();
//	driver.findElement(By.xpath("//span[@id='cart-total']/..")).click();

	@FindBy(xpath = "(//h1[text()='Nikon D300']/../div/following-sibling::ul)[2]/li/h2")
	private WebElement price;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(id = "button-cart")
	private WebElement setQuantityButton;

	public ProductDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getPrice() {
		String productPrice = price.getText();
		return productPrice;
	}
	
	
	public void setQuantity(String productQuantity) {
		quantity.clear();
		quantity.sendKeys(productQuantity);
		setQuantityButton.click();
		addToCartButton();
	}

}
