package Dictionaries;

import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

	public Button(WebElement element) {
		super(element);
	}

	@Override
	public void click() {
		webElement.click();
	}

}
