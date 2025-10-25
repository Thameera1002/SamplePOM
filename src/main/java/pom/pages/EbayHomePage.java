package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomePage extends BasePage{
    public EbayHomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="gh-ac")
    WebElement ebaySearchBox;

    @FindBy(id = "gh-cat")
    WebElement categoryDD;

    @FindBy(id = "gh-search-btn")
    WebElement searchButton;

//    By searchBox  = By.id("gh-ac");
//
//    public void test(){
//        WebElement element = driver.findElement(searchBox);
//    }
    public void enterValueForSearchBox(String value){
        type(ebaySearchBox,value);
    }

    public MobileResultPage clickOnSearchButton(){
        click(searchButton);
        return PageFactory.initElements(driver, MobileResultPage.class);
    }

    public void selectDDValue(String value){
        selectDDValueByVisibleText(categoryDD,value);
    }

}
