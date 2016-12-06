package scripts;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Login {
public static WebDriver oBrowser;
static String UN="abcdxyz";
static String PWD="xyzabcd";
	 
	 @BeforeClass
	 @Parameters("url")
	  public static void initialise(String url) throws Exception 
	  {
	    oBrowser=new FirefoxDriver();
	    oBrowser.get(url);
	    util.Delay.waitfor(2);
	    oBrowser.manage().window().maximize();
	  }
	 
	 //Validating With out User name and With out Password
	 @Test(priority=1)
	 @Parameters({"lang_type","Exp_res_UN","Exp_res_PWD"})
	  public static void Negative_login_English_Without_UN_PWD(String lang_type,String Exp_res_UN,String Exp_res_PWD) throws Exception 
	   {
		 WebElement oSelect=oBrowser.findElement(By.id("Language"));
		 Select select=new Select(oSelect);
		 select.selectByVisibleText(lang_type);
		 util.Delay.waitfor(3);
		
		 oBrowser.findElement(By.name("Command")).click();
		 util.Delay.waitfor(3);
		    
		 String Expected_Result1=Exp_res_UN;
		 String Expected_Result2=Exp_res_PWD;
		 String Actual_Result1=oBrowser.findElement(By.xpath(".//*[@id='signin']/div[2]/div/span/span")).getText();
		 String Actual_Result2=oBrowser.findElement(By.xpath(".//*[@id='signin']/div[3]/div/span/span")).getText();
		 assert Expected_Result1.equals(Actual_Result1);
		 assert Expected_Result2.equals(Actual_Result2);
	   }
	  
	//Validating With User name and With out Password
	 @Test(priority=2)
	 @Parameters("Exp_res_PWD")
	 public static void Negative_login_English_With_UN_Without_PWD(String Exp_res_PWD) throws Exception 
	  {
	 	 util.Delay.waitfor(3);
	 	 oBrowser.findElement(By.id("UserName")).sendKeys(UN);
	 	 oBrowser.findElement(By.name("Command")).click();
	 	    
	 	 String Expected_Result3=Exp_res_PWD;
	 	 String Actual_Result3=oBrowser.findElement(By.xpath(".//*[@id='signin']/div[3]/div/span/span")).getText();
	 	 assert Expected_Result3.equals(Actual_Result3);
	  }

	 //Validating With out User name and With Password
	 @Test(priority=3)
	 @Parameters("Exp_res_UN")
	 public static void Negative_login_English_Without_UN_With_PWD(String Exp_res_UN) throws Exception 
	  {
	 	 util.Delay.waitfor(2);
	 	 oBrowser.findElement(By.id("UserName")).clear();
	 	 util.Delay.waitfor(2);
	 	 oBrowser.findElement(By.id("Password")).sendKeys(PWD);
	 	 oBrowser.findElement(By.name("Command")).click();
	 	 util.Delay.waitfor(3);
	 	    
	 	 String Expected_Result4=Exp_res_UN;
	 	 String Actual_Result4=oBrowser.findElement(By.xpath(".//*[@id='signin']/div[2]/div/span/span")).getText();
	 	 assert Expected_Result4.equals(Actual_Result4);
	  }
		
	  //Validating With invalid User name and invalid Password
	  @Test(priority=4)
	  @Parameters("Exp_res_invalid")
	  public static void Negative_login_English_Invalid_UN_PWD(String Exp_res_invalid) throws Exception 
	   {
		 util.Delay.waitfor(3);
		 oBrowser.findElement(By.id("UserName")).clear();
		 oBrowser.findElement(By.id("Password")).clear();
		 util.Delay.waitfor(2);
		    
		 oBrowser.findElement(By.id("UserName")).sendKeys(UN);
		 util.Delay.waitfor(2);
	     oBrowser.findElement(By.id("Password")).sendKeys(PWD);
	     util.Delay.waitfor(2);
	     oBrowser.findElement(By.name("Command")).click();
	     util.Delay.waitfor(3);
	    	
	     String Expected_Result5=Exp_res_invalid;
	     String Actual_Result5=oBrowser.findElement(By.xpath(".//*[@id='signin']/div[2]")).getText();
	     assert Actual_Result5.endsWith(Expected_Result5);
	     util.Delay.waitfor(3);   
	   }
	  
	  @Test(priority=5)
	  @Parameters({"lang_type","sheetName","verify_url"})
	  public static void login(String lang_type,String sheetName,String verify_url) throws Exception 
	   {
		FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\Controller\\testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fin);
		Sheet s=wb.getSheet(sheetName);
		String uN=s.getRow(1).getCell(0).getStringCellValue();
		String pWD=s.getRow(1).getCell(1).getStringCellValue();
		  
		oBrowser.findElement(By.id("UserName")).clear();
		oBrowser.findElement(By.id("Password")).clear();
		util.Delay.waitfor(2);
	    oBrowser.findElement(By.id("UserName")).sendKeys(uN);
	    util.Delay.waitfor(2);
	    oBrowser.findElement(By.id("Password")).sendKeys(pWD);
	    util.Delay.waitfor(2);
	    oBrowser.findElement(By.name("Command")).click();
	    util.Delay.waitfor(3);
	    
	    assert verify_url.equals(oBrowser.getCurrentUrl());
	    util.Delay.waitfor(3);  
	   }
	  
	  @Test(priority=6)
	  @Parameters({"lang_type","place","settings_url"})
	  public static void Change_User_language(String lang_type,String place,String settings_url)
	   {
	    WebElement R1=oBrowser.findElement(By.cssSelector("span.title"));
		
		Actions a1 = new Actions(oBrowser);
		a1.moveToElement(R1).build().perform();
		util.Delay.waitfor(3);
		
		oBrowser.findElement(By.xpath("//li[4]/a")).click();
		util.Delay.waitfor(3);
		
		assert settings_url.equals(oBrowser.getCurrentUrl());
	    util.Delay.waitfor(3);
		
		WebElement oSelect=oBrowser.findElement(By.id("DateFormat"));
		Select select=new Select(oSelect);
		select.selectByVisibleText(lang_type);
		util.Delay.waitfor(3);
		 
		oBrowser.findElement(By.id("TimeZoneInfo_chosen")).click();
		util.Delay.waitfor(2);
		oBrowser.findElement(By.cssSelector(".chosen-search>input")).sendKeys(place);
		util.Delay.waitfor(2);
		oBrowser.findElement(By.cssSelector(".chosen-search>input")).sendKeys(Keys.ENTER);
		util.Delay.waitfor(2);
		oBrowser.findElement(By.xpath("//div[3]/div/input")).click();
		util.Delay.waitfor(2);
	   }
	  
	  @Test(priority=7)
	  @Parameters({"sheetName","department_url"})
	  public static void Create_department(String sheetName,String department_url) throws Exception
	   {
		FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\Controller\\testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fin);
		Sheet s=wb.getSheet(sheetName);
		String dept=s.getRow(6).getCell(0).getStringCellValue();
		
		WebElement R2=oBrowser.findElement(By.xpath("//li[10]/a/span"));
		Actions a2 = new Actions(oBrowser);
		a2.moveToElement(R2).build().perform();
		util.Delay.waitfor(2);
		
		WebElement R3=oBrowser.findElement(By.xpath("//li[10]/ul/li[5]/a/span"));
		Actions a3 = new Actions(oBrowser);
		a3.moveToElement(R3).build().perform();
		util.Delay.waitfor(2);
		
		oBrowser.findElement(By.xpath("//li[5]/ul/li[5]/a")).click();
		util.Delay.waitfor(2);
		
		assert department_url.equals(oBrowser.getCurrentUrl());
	    util.Delay.waitfor(3);
		
		oBrowser.findElement(By.xpath("//p/a")).click();
		util.Delay.waitfor(2);
		oBrowser.findElement(By.id("Name")).sendKeys(dept);
		util.Delay.waitfor(2);
		oBrowser.findElement(By.xpath("//div[2]/div/input")).click();
		util.Delay.waitfor(2);
	   }
	  
	  @Test(priority=8)
	  @Parameters({"sheetName","location_url"})
	  public static void Create_location(String sheetName,String location_url) throws Exception
	   {
		FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\Controller\\testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fin);
		Sheet s=wb.getSheet(sheetName);
		String country=s.getRow(9).getCell(0).getStringCellValue(); 
		String location=s.getRow(9).getCell(1).getStringCellValue();
		String description=s.getRow(9).getCell(2).getStringCellValue();
		
		WebElement R2=oBrowser.findElement(By.xpath("//li[10]/a/i"));
		Actions a2 = new Actions(oBrowser);
		a2.moveToElement(R2).build().perform();
		util.Delay.waitfor(2);
			
		WebElement R3=oBrowser.findElement(By.xpath("//li[10]/ul/li[5]/a"));
		Actions a3 = new Actions(oBrowser);
		a3.moveToElement(R3).build().perform();
		util.Delay.waitfor(2);
			
		oBrowser.findElement(By.xpath("//li[5]/ul/li[4]/a")).click();
		util.Delay.waitfor(2);
		
		assert location_url.equals(oBrowser.getCurrentUrl());
	    util.Delay.waitfor(3);
		
		oBrowser.findElement(By.xpath("//p/a")).click();
		util.Delay.waitfor(2);
		oBrowser.findElement(By.id("CountryName")).sendKeys(country);
		util.Delay.waitfor(2);
		oBrowser.findElement(By.id("LocationName")).sendKeys(location);
		util.Delay.waitfor(2);
		oBrowser.findElement(By.id("Description")).sendKeys(description);
		util.Delay.waitfor(2);
		oBrowser.findElement(By.xpath("//div[4]/div/input")).click();
		util.Delay.waitfor(2);
	   }
	  
	  @Test(priority=9)
	  @Parameters({"sheetName","businessunit_url"})
	  public static void Create_businessunit(String sheetName,String businessunit_url) throws Exception
	   {
		FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\Controller\\testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fin);
		Sheet s=wb.getSheet(sheetName);
		String bucode=s.getRow(12).getCell(0).getStringCellValue(); 
		String buname=s.getRow(12).getCell(1).getStringCellValue();
		String description=s.getRow(12).getCell(2).getStringCellValue();
			
		WebElement R2=oBrowser.findElement(By.xpath("//li[10]/a/i"));
		Actions a2 = new Actions(oBrowser);
		a2.moveToElement(R2).build().perform();
		util.Delay.waitfor(2);
			
		WebElement R3=oBrowser.findElement(By.xpath("//li[10]/ul/li[5]/a"));
		Actions a3 = new Actions(oBrowser);
		a3.moveToElement(R3).build().perform();
		util.Delay.waitfor(2);
		
		oBrowser.findElement(By.xpath("//li[5]/ul/li[3]/a")).click();
		util.Delay.waitfor(2);
		
		assert businessunit_url.equals(oBrowser.getCurrentUrl());
	    util.Delay.waitfor(2);
		
		oBrowser.findElement(By.xpath("//div[2]/a")).click();
		util.Delay.waitfor(2);
		oBrowser.findElement(By.id("BusinessUnitCode")).sendKeys(bucode);
		util.Delay.waitfor(2);
		oBrowser.findElement(By.id("Name")).sendKeys(buname);
		util.Delay.waitfor(2);
		oBrowser.findElement(By.id("Description")).sendKeys(description);
		util.Delay.waitfor(2);
		oBrowser.findElement(By.xpath("//div[5]/div/input")).click();
		util.Delay.waitfor(2);
	   }
	  
	  @AfterClass
	  @Parameters({"logout","authenticate_url"})
	  public static void logout(String logout,String authenticate_url) throws Exception 
	   {
		try{
			 WebElement R1=oBrowser.findElement(By.cssSelector("span.title"));
		
			 Actions a1 = new Actions(oBrowser);
			 a1.moveToElement(R1).build().perform();
			 util.Delay.waitfor(3);
		
			 oBrowser.findElement(By.linkText(logout)).click();
			 util.Delay.waitfor(3);
			 
			 assert authenticate_url.equals(oBrowser.getCurrentUrl());
			 util.Delay.waitfor(3);
			 
			 //oBrowser.quit();
		   } catch(Exception e)
		      {  
			    File scrFile = ((TakesScreenshot)oBrowser).getScreenshotAs(OutputType.FILE);  
			    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\failure.png"));  
			  }  
	    }
     }