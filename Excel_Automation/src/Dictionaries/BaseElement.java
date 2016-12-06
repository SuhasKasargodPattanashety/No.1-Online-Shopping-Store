package Dictionaries;

import java.util.List;

import org.openqa.selenium.*;
import Utilities.WebDriverFactory;


public class BaseElement implements WebElement {

	protected WebElement webElement;
	protected WebDriver driver = WebDriverFactory.getDriverInstance();

	public BaseElement(WebElement element) {
		webElement = element;
	}

	@Override
	public void clear() {
		webElement.clear();
	}

	@Override
	public void click() {
		webElement.click();
	}

	@Override
	public WebElement findElement(By by) {
		return webElement.findElement(by);
	}

	@Override
	public List<WebElement> findElements(By by) {
		return webElement.findElements(by);
	}

	@Override
	public String getAttribute(String attrName) {
		return webElement.getAttribute(attrName);
	}

	@Override
	public String getCssValue(String propertyName) {
		return webElement.getCssValue(propertyName);
	}

	@Override
	public Point getLocation() {
		return webElement.getLocation();
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTagName() {
		return webElement.getTagName();
	}

	@Override
	public String getText() {
		return webElement.getText();
	}

	@Override
	public boolean isDisplayed() {
		return webElement.isDisplayed();
	}

	@Override
	public boolean isEnabled() {
		return webElement.isEnabled();
	}

	@Override
	public boolean isSelected() {
		return webElement.isSelected();
	}

	@Override
	public void sendKeys(CharSequence... keys) {
		webElement.sendKeys(keys);
	}

	@Override
	public void submit() {
		webElement.submit();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

}
