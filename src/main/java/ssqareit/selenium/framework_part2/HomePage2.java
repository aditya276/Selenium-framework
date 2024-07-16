package ssqareit.selenium.framework_part2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage2 {

	static WebDriver driver;
	
	@FindBy(xpath="//li/a[text()='Cameras']")
	private WebElement camerasTab;
	
	public HomePage2(WebDriver driver) {
		HomePage2.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProductsPage2 clickOnCamerasTab() {
	camerasTab.click();
	ProductsPage2 pp=new ProductsPage2(driver);
	return pp;
	}
	
}
