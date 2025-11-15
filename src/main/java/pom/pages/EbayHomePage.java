package pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomePage extends BasePage{
    public EbayHomePage(WebDriver driver) {
        super(driver);
    }

    String dropdownValue;
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
    @Step("Enter value for search box")
    public void enterValueForSearchBox(String value){
        type(ebaySearchBox,value);
    }

    @Step("Click on search button")
    public <T> T clickOnSearchButton(){
        if (dropdownValue.equalsIgnoreCase(" Cell Phones & Accessories")){
            click(searchButton);
            return PageFactory.initElements(driver, (Class<T>)MobileResultPage.class);
        }else if (dropdownValue.equalsIgnoreCase(" Clothing, Shoes & Accessories")){
            click(searchButton);
            System.out.println("Clicked updated 1");
            System.out.println("Test modification");
            return PageFactory.initElements(driver, (Class<T>)ClothResultPage.class);
        }
        return null;

    }

    @Step("Select Dropdown value")
    public void selectDDValue(String value){
        dropdownValue = value;
        selectDDValueByVisibleText(categoryDD,value);
    }

}
