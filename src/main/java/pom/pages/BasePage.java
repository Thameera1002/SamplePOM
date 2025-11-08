package pom.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.util.ExtentReportManager;

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
        try{
            driver.get(url);
            ExtentReportManager.logPass("Successfully navigated to the url : "+url);
        }catch (Exception e){
            ExtentReportManager.logFail("There is an issue with navigate to the url :"+url+"\n"+e.getMessage());
        }

    }

    public void type(WebElement element, String text){
        try{
            waitForTheElement(element,30);
            element.clear();
            element.sendKeys(text);
            ExtentReportManager.logPass("[ "+text+" ] is successfully added to the locator : "+element);
        }catch (NoSuchElementException e){
            ExtentReportManager.logFail("No such element found ! "+element);
        }

    }

    public void click(WebElement element){
        try{
            waitForTheElement(element,30);
            element.click();
            ExtentReportManager.logPass("Clicked : "+element);
        }catch (NoSuchElementException e){
            ExtentReportManager.logFail("No such element found ! "+element);
        }

    }

    public void selectDDValueByVisibleText(WebElement element, String visibleText){
        try {
            waitForTheElement(element,30);
            new Select(element).selectByVisibleText(visibleText);
            ExtentReportManager.logPass("Selected ["+visibleText+"] successfully !");
        }catch (NoSuchElementException e){
            ExtentReportManager.logFail("No such element found ! "+element);
        }

    }

    public void waitForTheElement(WebElement element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
