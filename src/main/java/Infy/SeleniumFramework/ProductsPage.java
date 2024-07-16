package Infy.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePageClass;

public class ProductsPage extends BasePageClass{
	//	List<WebElement> products = driver.findElements(By.cssSelector("div.product-thumb"));

	@FindBy(css="div.product-thumb")
	private List <WebElement> products;
	
	By productLocation=By.cssSelector("h4 a");
	
	public ProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public List<WebElement> getProducts(){
		visibilityOfElementLocated(productLocation);
		return products;
	}
	
	
	public void getProductByName(String camera) {
		for (WebElement product : products) {
			String productName = product.findElement(productLocation).getText();
			System.out.println(productName);
			if (productName.equalsIgnoreCase(camera)) {
				product.findElement(By.cssSelector("h4 a")).click();
			}
		}
	}
}
