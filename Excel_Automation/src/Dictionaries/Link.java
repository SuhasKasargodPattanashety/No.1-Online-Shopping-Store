package Dictionaries;

import org.openqa.selenium.WebElement;

public class Link extends BaseElement {

	public Link(WebElement element) {
		super(element);
	}

	@Override
	public void click() {
		webElement.click();
	}

}
