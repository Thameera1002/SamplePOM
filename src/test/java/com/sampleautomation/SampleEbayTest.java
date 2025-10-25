package com.sampleautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleEbayTest {

    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void ebaySearchTest(){
        driver.findElement(By.id("gh-ac")).clear();
        driver.findElement(By.id("gh-ac")).sendKeys("phone");
        new Select(driver.findElement(By.id("gh-cat")))
                .selectByVisibleText("Cell Phones & Accessories");
        driver.findElement(By.id("gh-search-btn")).click();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
