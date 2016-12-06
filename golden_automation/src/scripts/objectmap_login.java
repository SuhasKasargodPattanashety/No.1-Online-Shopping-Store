package scripts;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import util.objectmap;

import org.openqa.selenium.WebElement;

public class objectmap_login {
public static WebDriver oBrowser;
public static objectmap objmap;
  
@BeforeClass
@Parameters("url")
public static void initialise(String url) throws Exception 
{
 oBrowser=new FirefoxDriver();
 oBrowser.get(url);
 util.Delay.waitfor(2);
 oBrowser.manage().window().maximize();
 }
  
@Test(priority=1)
@Parameters({"username","password"})
public void login(String username, String password) throws Exception
{   
 objmap = new objectmap (System.getProperty("user.dir")+"/object_PropertyFile/objectmap.properties");
 
 WebElement btnmainlogin = oBrowser.findElement(objmap.getLocator("Main_Login_button"));
 btnmainlogin.click();  
 util.Delay.waitfor(2);
 WebElement txtusername = oBrowser.findElement(objmap.getLocator("Username_field"));
 txtusername.sendKeys(username);
 util.Delay.waitfor(2);
 WebElement txtpassword = oBrowser.findElement(objmap.getLocator("Password_field"));
 txtpassword.sendKeys(password);
 util.Delay.waitfor(2);
 WebElement btnlogin = oBrowser.findElement(objmap.getLocator("Login_button"));
 btnlogin.click();
 util.Delay.waitfor(2);   
}
   
@Test(priority=2)
public void FoodOrder() throws Exception
{  
 WebElement btnFoodCupboard = oBrowser.findElement(objmap.getLocator("FoodCupboard_button"));
 
 Actions a1 = new Actions(oBrowser);
 a1.moveToElement(btnFoodCupboard).build().perform();
 util.Delay.waitfor(5);
 
 WebElement btnChocolateSweets = oBrowser.findElement(objmap.getLocator("ChocolateSweets_button"));
 btnChocolateSweets.click();
 util.Delay.waitfor(2);
 
}

@AfterClass
public static void logout() throws Exception 
{
 try{
	 util.Delay.waitfor(5);
	 WebElement R1=oBrowser.findElement(objmap.getLocator("user_button"));
		
	 Actions a1 = new Actions(oBrowser);
	 a1.moveToElement(R1).build().perform();
	 util.Delay.waitfor(5);
		
	 oBrowser.findElement(objmap.getLocator("Logout_button")).click();
	 util.Delay.waitfor(5);
	 } catch(Exception e)
	      {  
		    File scrFile = ((TakesScreenshot)oBrowser).getScreenshotAs(OutputType.FILE);  
		    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/Screenshots/failure.png"));  
		  }  
    }  
  
@AfterSuite
public void Quit() throws Exception
{
 oBrowser.quit();
}
}
