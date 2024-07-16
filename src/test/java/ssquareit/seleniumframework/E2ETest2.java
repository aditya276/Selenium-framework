package ssquareit.seleniumframework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ssqareit.selenium.framework_part2.CartPage2;
import ssqareit.selenium.framework_part2.CheckoutPage2;
import ssqareit.selenium.framework_part2.HomePage2;
import ssqareit.selenium.framework_part2.LandingPage2;
import ssqareit.selenium.framework_part2.LoginPage2;
import ssqareit.selenium.framework_part2.ProductDetails2;
import ssqareit.selenium.framework_part2.ProductsPage2;
import testComponent.BaseTest;

public class E2ETest2 extends BaseTest {
	
	@Test(dataProvider="getData")
	public void e2eTest(String username,String password) throws IOException, InterruptedException {
		String camera = "Nikon D300";
		String quantity = "2";
		//initialization
	 	WebDriver driver=initBrowser();
		
		// landing page
		LandingPage2 obj = new LandingPage2(driver);
		LoginPage2 loginpage = obj.navigateToLoginPage();
		// login page
		HomePage2 hp = loginpage.Login(username, password);
		// Home page
		ProductsPage2 pp = hp.clickOnCamerasTab();
		// product page=we will use limiting the scope of webdriver
		// List<WebElement> products =
		// driver.findElements(By.cssSelector("div.product-thumb"));
		List<WebElement> products = pp.getProducts();
		ProductDetails2 pd = pp.getProductByName(camera);
		// products details page
		// first validation=external indexing and child to parent using ..
		// String price=driver.findElement(By.xpath("(//h1[text()='Nikon
		// D300']/../div/following-sibling::ul)[2]/li/h2")).getText();
		String price = pd.getPrice();
		Assert.assertEquals(price, "$98.00");
		CartPage2 cartpage = pd.setQuantity(quantity);
		// cart page
		// String
		// totalPrice=driver.findElement(By.xpath("//strong[text()='Total']/../following-sibling::td")).getText();
		String totalPrice = cartpage.totalPrice();
		System.out.println(totalPrice);
		boolean isEqual = totalPrice.equalsIgnoreCase("$196.00");
		Assert.assertTrue(isEqual);
		// driver.findElement(By.xpath("//strong[text()='Checkout']")).click();
		CheckoutPage2 checkoutPage = cartpage.clickOnCheckOut();
		// checkout page
		// driver.findElement(By.cssSelector("button.close")).click();
		checkoutPage.clickCloseButton();
		// String succesMessage=driver.findElement(By.xpath("(//a[text()='Nikon
		// D300'])[2]/following-sibling::span")).getText();
		String succesMessage = checkoutPage.getSuccessMessage();
		isEqual = succesMessage.equalsIgnoreCase("***");
		Assert.assertTrue(isEqual);
		
		//closing
		tearDown();
	}
	
	
	@DataProvider(name="getData")
	public Object[][] getData(){
		return new  Object[][] {
			{"cadace31890@nolanzip.com","john@123"},
			{"cadace3189@nolanzip.com","depp@123"}
		};
	}

}
