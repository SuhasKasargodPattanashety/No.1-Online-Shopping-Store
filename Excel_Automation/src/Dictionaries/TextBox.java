package Dictionaries;

import org.openqa.selenium.WebElement;

public class TextBox extends BaseElement {
  
  public TextBox(WebElement element){
    super(element);
  }
  
  public boolean setText(String text){
    if(text!=null){
      webElement.sendKeys(text);
      return true;
    }else{
      return false;
    }  
  }
  
  public void clear(){
    webElement.clear();
  }
}
