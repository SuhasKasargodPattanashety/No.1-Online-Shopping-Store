package Driver;
 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import Utilities.*;
import testscripts.SignIn_Action;
 
public class DriverScript {
 private static WebDriver driver = null;
  
 @Test
 public static void Run() throws Exception{
	 

  //public static void main(String[] args) throws Exception {
  
  //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
	  
    ExcelUtils.setExcelFile(Constants.Path_controller + Constants.File_controller,"Sheet1");
 
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(Constants.URL);
    SignIn_Action.logIn(driver);
    System.out.println("Login Successfully, now it is the time to Log Off buddy.");	
    //driver.quit();
 
   //This is to send the PASS value to the Excel sheet in the result column.
 
     ExcelUtils.setCellData("Pass", 1, 3);
 
  }
 
}