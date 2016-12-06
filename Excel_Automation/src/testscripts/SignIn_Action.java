package testscripts;

import org.openqa.selenium.WebDriver;

import PageObjects.LandingPage;
import Utilities.CustomPageFactory;
import Utilities.ExcelUtils;

public class SignIn_Action {
static LandingPage landingPage;
 
  public static void logIn(WebDriver driver) throws Exception {

	String sUserName = ExcelUtils.getCellData(1, 1);
	String sPassword = ExcelUtils.getCellData(1, 2);
	
	landingPage = CustomPageFactory.initElements(LandingPage.class);
	landingPage.logInBtn.click();
	landingPage.emailID.setText(sUserName);
	landingPage.wait(3);
	landingPage.password.setText(sPassword);
	landingPage.wait(3);
	landingPage.signIn.click();

   }
}
