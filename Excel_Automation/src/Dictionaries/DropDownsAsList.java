package Dictionaries;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import java.util.ArrayList;
import java.util.Iterator;


public class DropDownsAsList extends BaseElement {

	WebElement dropdownLocator = null;


	public DropDownsAsList(WebElement element) {
		super(element);
		dropdownLocator = element;
	}


	public void selectOption(String option) {
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdownLocator).clickAndHold().release();
		Action action = actions.build();
		action.perform();


		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement optionElem = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
		actions.moveToElement(optionElem).click();
		actions.perform();
	}


	public void selectOption(ArrayList<String> option) {
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdownLocator).clickAndHold().release();
		Action action = actions.build();
		action.perform();

		Iterator optionTextItr = option.iterator();
		try {
			Thread.sleep(2000);

			while (optionTextItr.hasNext()) {
				// actions = new Actions(driver);
				// WebElement optionElem = null;
				String ddValue = (String) optionTextItr.next();
				if (this.findElements(By.xpath("/ul//li/a[contains(text(),'" + ddValue + "')]")).size() != 0) {
					this.findElement(By.xpath("//a[contains(text(),'" + ddValue + "')]")).click();
				} else {
					this.findElement(By.xpath("/ul//li/a/span[contains(text(),'" + ddValue + "')]")).click();
				}

				// action = actions.moveToElement(optionElem).clickAndHold().release().build();
				// action.perform();

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
