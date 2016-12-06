package Dictionaries;

import org.openqa.selenium.WebElement;

public class CheckBox extends BaseElement{

  public CheckBox(WebElement element){
    super(element);
  }
  
  @Override
  public void click() {
    webElement.click();
  }
  
}
