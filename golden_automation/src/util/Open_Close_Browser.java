package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Open_Close_Browser {
 public static WebDriver oBrowser;
 
public void initialise() throws Exception 
{
 oBrowser=new FirefoxDriver();
}
 
public void navigate(String url)
{
 oBrowser.get(url);
 util.Delay.waitfor(2);
 oBrowser.manage().window().maximize(); 
}
 
public void Quit() throws Exception
{
 oBrowser.quit();
}
}
