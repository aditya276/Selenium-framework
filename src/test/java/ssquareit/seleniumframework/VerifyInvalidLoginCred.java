package ssquareit.seleniumframework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ssqareit.selenium.framework_part2.LandingPage2;
import ssqareit.selenium.framework_part2.LoginPage2;
import testComponent.BaseTest;

public class VerifyInvalidLoginCred extends BaseTest {

	@Test
	public void invalidLoginAttempt() throws IOException {
		WebDriver driver=initBrowser();
		LandingPage2 lp2=new LandingPage2(driver);
		lp2.navigateToLoginPage();
		LoginPage2 lp=new LoginPage2(driver);
		lp.Login("cadace3189@nolanzip.com","asdw123");
		String actulaURL=driver.getCurrentUrl();
		String expected="https://tutorialsninja.com/demo/index.php?route=account/account";
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actulaURL, expected);
		
		sa.assertAll();
		tearDown();
		
	}

}
