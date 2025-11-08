package pom.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pom.util.BrowserFactory;
import pom.util.ExtentReportManager;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;

    public BrowserFactory browserFactory = BrowserFactory.getInstance();

    @BeforeTest
    public void beforeTest(){
        ExtentReportManager.initReport();
    }
    @BeforeMethod
    public void beforeMethod(Method method){
//        driver = WebDriverManager.chromedriver().create();
//        driver.manage().window().maximize();
        driver = browserFactory.getDriver();
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(){
//        driver.quit();
        browserFactory.quitDriver();
    }

    @AfterTest
    public void afterTest(){
        ExtentReportManager.flushReport();
    }
}
