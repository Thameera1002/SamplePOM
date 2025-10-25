package pom.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pom.util.BrowserFactory;

public class BaseTest {

    protected WebDriver driver;

    public BrowserFactory browserFactory = BrowserFactory.getInstance();

    @BeforeMethod
    public void beforeMethod(){
//        driver = WebDriverManager.chromedriver().create();
//        driver.manage().window().maximize();
        driver = browserFactory.getDriver();
    }

    @AfterMethod
    public void afterMethod(){
//        driver.quit();
        browserFactory.quitDriver();
    }
}
