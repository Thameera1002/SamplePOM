package pom.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pom.pages.BasePage;
import pom.pages.ClothResultPage;
import pom.pages.EbayHomePage;
import pom.pages.MobileResultPage;

public class EbaySearchTest extends BaseTest{

    @Test
    @Epic("EbayTest_001")
    @Feature("Mobile Search feature")
    @Story("Search Mobile and select apple")
    public void mobileSearchTest(){
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        EbayHomePage ebayHomePage = basePage.initApp();
        ebayHomePage.enterValueForSearchBox("phone");
        ebayHomePage.selectDDValue(" Cell Phones & Accessories");
        MobileResultPage mobileResultPage = ebayHomePage.clickOnSearchButton();
        mobileResultPage.clickOnAppleCkeckBox();
    }

    @Test
    @Epic("EbaySearch_002")
    @Feature("Dress Search feature")
    @Story("Search TShirt and select short")
    public void dressResultTest(){
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        EbayHomePage ebayHomePage = basePage.initApp();
        ebayHomePage.enterValueForSearchBox("tshirt");
        ebayHomePage.selectDDValue(" Clothing, Shoes & Accessories");
        ClothResultPage clothResultPage = ebayHomePage.clickOnSearchButton();
        clothResultPage.clickOnLongSleevesCheckBox();
    }
}
