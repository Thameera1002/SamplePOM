package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public EbayHomePage initApp(){
        navigateToURL("https://www.ebay.com/");
        return PageFactory.initElements(driver, EbayHomePage.class);
    }
    public void navigateToURL(String url){
        driver.get(url);
    }

    public void type(WebElement element, String text){
        waitForTheElement(element,30);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element){
        waitForTheElement(element,30);
        element.click();
    }

    public void selectDDValueByVisibleText(WebElement element, String visibleText){
        waitForTheElement(element,30);
        new Select(element).selectByVisibleText(visibleText);
    }

    public void waitForTheElement(WebElement element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
