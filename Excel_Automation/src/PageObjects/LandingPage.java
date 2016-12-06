package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Dictionaries.*;

public class LandingPage {
public static WebDriver driver;
  @FindBy(css="a.signinBtn > span")
  public Button logInBtn;
  
  @FindBy(css="div[id='loginBarInner'] input[name='email']")
  public TextBox emailID;
  
  @FindBy(css="div[id='loginBarInner'] input[name='password']")
  public TextBox password;
  
  @FindBy(css="div[id='loginBarInner'] > form > button")
  public Button signIn;
  
  @FindBy(css="a[id='accountPreviewInner'] span span:nth-child(2)")
  public BaseElement signedInUserName;
  
  @FindBy(className="productSearch")
  public TextBox searchField;
  
  @FindBy(css="ol.searchSuggestions")
  public BaseElement searchSuggestion;
  
  @FindBy(css="li.productSuggestion:nth-child(2)")
  public BaseElement firstSuggestion;
  
  @FindBy(name="submitSearch")
  public Button submitSearch;
  
  @FindBy(css="li[itemid='7763'] a.addtocart")
  public BaseElement addToCartDasaniWater;
  
  @FindBy(id="cartPreviewInner")
  public BaseElement cartView;
  
  @FindBy(className="instacheckout")
  public Button instaCheckOut;
  
  @FindBy(css="div[id=lightboxContent] button")
  public Button closeLightBox;
  
  @FindBy(css="nav[id='categoryNav'] section:first-child div:nth-child(2) a")
  public BaseElement onSaleCategory;
  
  @FindBy(css="nav[id='categoryNav'] section:first-child div:nth-child(3) a")
  public BaseElement newCategory;
  
  public WebElement getCategoryLinks(String categoryName){
    return driver.findElement(By.cssSelector("nav[id='categoryNav'] div a[href='/" + categoryName + "']"));
  }

}
