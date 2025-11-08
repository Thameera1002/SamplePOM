package pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothResultPage extends BasePage{
    public ClothResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Long Sleeve']")
    WebElement chkLongSleeves;

    @Step("Select longSleeves")
    public void clickOnLongSleevesCheckBox(){
        click(chkLongSleeves);
    }
}
