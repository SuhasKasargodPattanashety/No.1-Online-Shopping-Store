package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
  private static Properties properties = new Properties();

  static {
    try {
      //File file = new File("config/config.properties");
      InputStream fileInput = ConfigProperties.class.getClassLoader().getSystemResourceAsStream("config/config.properties");
      properties.load(fileInput);
      fileInput.close();

    } catch (FileNotFoundException e) {
      System.err.println("Unable to find config.properties file - FileNotFoundException: " + e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println("Exception on loading stream file to properties object: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public ConfigProperties() {
  }

  public String getPropertyValue(String key, String defaultValue) {
    return properties.getProperty(key, defaultValue);
  }
  
  public String getBrowser(){
    return properties.getProperty("defaultBrowser");
  }
  
  public String getWaitTime(){
    return properties.getProperty("wait");
  }
  
  public String getGGUrl(){
    return properties.getProperty("goldenGrocer");
  }
  
  public String getGGUserID(){
    return properties.getProperty("userID");
  }
  
  public String getGGPwd(){
    return properties.getProperty("pwd");
  }
  
  public String getConsoleUrl(){
    return properties.getProperty("console");
  }

  public String getMQUrl(){
    return properties.getProperty("mqurl");
  }

  public String getMQUsr(){
    return properties.getProperty("mqusr");
  }
  
  public String getMQPwd(){
    return properties.getProperty("mqpwd");
  }
  
  public String getMongoServerName(){
	    return properties.getProperty("serverName");
  }
  
  public int getMongoPort(){
	    return Integer.parseInt(properties.getProperty("mongoPort"));
}
  
  public static String getPromoDeleteUrl(){
	    return properties.getProperty("promoDeleteURL");
}
}
