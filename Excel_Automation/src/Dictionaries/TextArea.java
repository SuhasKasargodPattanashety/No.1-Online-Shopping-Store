package Dictionaries;

import org.openqa.selenium.WebElement;

public class TextArea extends BaseElement {

  public TextArea(WebElement element) {
    super(element);
  }

  public void setText(String text) {
    if (text == null) {
      return;
    }
    webElement.clear();
    webElement.sendKeys(text);
  }

  public String getText() {
    return webElement.getAttribute("value");
  }

  public boolean isReadOnly(){
    if (webElement.getAttribute("readonly") != null && (webElement.getAttribute("readonly").equalsIgnoreCase("true")))
      return true;
    else
      return false;
  }
}
