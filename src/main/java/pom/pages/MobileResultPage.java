package pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileResultPage extends BasePage{

    public MobileResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Apple']")
    WebElement chkApple;

    @Step("Select apple")
    public void clickOnAppleCkeckBox(){
        click(chkApple);
    }
}
