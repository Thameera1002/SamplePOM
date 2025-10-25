package pom.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    private BrowserFactory(){}

    private static BrowserFactory browserFactory;

    ThreadLocal<WebDriver> tlWebDriver = ThreadLocal.withInitial(()->{
        String browser = System.getProperty("browser","chrome");
        WebDriver driver = switch (browser){
            case "chrome" -> WebDriverManager.chromedriver().create();
            case "firefox"-> WebDriverManager.firefoxdriver().create();
            case "edge"-> WebDriverManager.edgedriver().create();
            default -> throw new RuntimeException("No such driver");
        };
        driver.manage().window().maximize();
        return driver;
    });

    public static BrowserFactory getInstance(){
        if (browserFactory == null){
            browserFactory = new BrowserFactory();
        }
        return browserFactory;
    }

    public WebDriver getDriver(){
        return tlWebDriver.get();
    }

    public void quitDriver(){
        tlWebDriver.get().quit();
        tlWebDriver.remove();
    }

}
