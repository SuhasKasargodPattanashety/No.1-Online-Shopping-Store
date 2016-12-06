package Dictionaries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Table extends BaseElement {
	WebElement tableLocator = null;

	public Table(WebElement element) {
		super(element);
		tableLocator = element;
	}
	public void verifyTableColumnHeader(String[] array, String tableName)
	{
		WebElement tableHeader = tableLocator.findElement(By
				.tagName("thead"));
		WebElement headerRow = tableHeader.findElement(By.tagName("tr"));
		List<WebElement> headerColumns=headerRow.findElements(By.tagName("th"));

		String[] actualHeader= new String[headerColumns.size()];
		int i = 0;

		for (WebElement headerColumn : headerColumns) {

			actualHeader[i] = headerColumn.getText();
			Assert.assertTrue(actualHeader[i].contains(array[i]));

			i++;
		}
	}
	


  public int getRowCount() {
    int totalRows = 0;
    totalRows = this.findElements(By.cssSelector("tbody tr")).size();
    return totalRows;
  }
  
  public int getColumnCount() {
    int totalColumns = 0;
    totalColumns = this.findElements(By.cssSelector("thead tr:first-child th")).size();
    return totalColumns;
  }
  
  public WebElement getRowWithText(String text) {
    WebElement rowWithText = null;
    if(this.findElements(By.xpath("//tbody/tr/td/a")).size() !=0){
    	rowWithText=this.findElement(By.xpath("//tbody/tr/td/a[text() = '"+text+"']/ancestor::tr"));
    }else{
    	rowWithText=this.findElement(By.xpath("//tbody/tr/td[text() = '"+text+"']/.."));
    }
    return rowWithText;
  }
  
  public WebElement getCellWithText(String text) {
    WebElement cellWithText = null;
    if(this.findElements(By.xpath("//tbody/tr/td/a")).size() !=0){
    	cellWithText=this.findElement(By.xpath("//tbody/tr/td/a[text() = '"+text+"']/.."));
    }else{
    	cellWithText=this.findElement(By.xpath("//tbody/tr/td[text() = '"+text+"']"));
    }
    return cellWithText;
  }
  
  public String getContentOfNthRow(int rowNum){
	  return this.findElement(By.cssSelector("tbody tr:nth-child("+rowNum+")")).getText();	  
  }
  
  public String getContentOfCell(int rowNum, int colNum){
	  return this.findElement(By.cssSelector("tbody tr:nth-child("+rowNum+") td:nth-child("+colNum+")")).getText();	  
  }
}
