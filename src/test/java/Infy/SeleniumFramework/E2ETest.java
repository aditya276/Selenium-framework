package Infy.SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ETest {
	@Test
	public void e2eTest() {
		String username = "cadace3189@nolanzip.com";
		String password = "john@123";
		String camera = "Nikon D300";
		String quantity="2";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

		// landing page
//		driver.findElement(By.xpath("//a[@title='My Account']")).click();
//		driver.findElement(By.xpath("//a[text()='Login']")).click();
		LandingPage obj=new LandingPage(driver);
		obj.navigateToLoginPage();
		
		//login page
//		driver.findElement(By.id("input-email")).sendKeys(username);
//		driver.findElement(By.id("input-password")).sendKeys(password);
//		driver.findElement(By.cssSelector("input[type='submit']")).click();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Login(username, password);

		// Home page
		//driver.findElement(By.xpath("//li/a[text()='Cameras']")).click();
		HomePage hp=new HomePage(driver);
		hp.clickOnCamerasTab();
		
		
		// product page=we will use limiting the scope of webdriver
		//List<WebElement> products = driver.findElements(By.cssSelector("div.product-thumb"));
		
		ProductsPage pp=new ProductsPage(driver);
		List<WebElement>products=pp.getProducts();
		pp.getProductByName(camera);
		
		
		//products details page
         //first validation=external indexing and child to parent using ..
		//String price=driver.findElement(By.xpath("(//h1[text()='Nikon D300']/../div/following-sibling::ul)[2]/li/h2")).getText();
		
		ProductDetails pd=new ProductDetails(driver);
		String price=pd.getPrice();
		Assert.assertEquals(price,"$98.00");
//		driver.findElement(By.id("input-quantity")).clear();
//		driver.findElement(By.id("input-quantity")).sendKeys("2");
//		driver.findElement(By.cssSelector("button#button-cart")).click();
//		driver.findElement(By.xpath("//span[@id='cart-total']/..")).click();
		pd.setQuantity(quantity);
		
		//cart page
		//String totalPrice=driver.findElement(By.xpath("//strong[text()='Total']/../following-sibling::td")).getText();
		CartPage cartpage=new CartPage(driver);
		String totalPrice=cartpage.totalPrice();
		System.out.println(totalPrice);
		boolean isEqual=totalPrice.equalsIgnoreCase("$196.00");
		Assert.assertTrue(isEqual);
		//driver.findElement(By.xpath("//strong[text()='Checkout']")).click();
		cartpage.clickOnCheckOut();
		//checkout page
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		//driver.findElement(By.cssSelector("button.close")).click();
		checkoutPage.clickCloseButton();
		//String succesMessage=driver.findElement(By.xpath("(//a[text()='Nikon D300'])[2]/following-sibling::span")).getText();
		String succesMessage=checkoutPage.getSuccessMessage();
		isEqual=succesMessage.equalsIgnoreCase("***");
		Assert.assertTrue(isEqual);
	}

}
