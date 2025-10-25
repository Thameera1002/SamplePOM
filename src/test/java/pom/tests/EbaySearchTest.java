package pom.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pom.pages.BasePage;
import pom.pages.ClothResultPage;
import pom.pages.EbayHomePage;
import pom.pages.MobileResultPage;

public class EbaySearchTest extends BaseTest{

    @Test
    public void mobileSearchTest(){
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        EbayHomePage ebayHomePage = basePage.initApp();
        ebayHomePage.enterValueForSearchBox("phone");
        ebayHomePage.selectDDValue(" Cell Phones & Accessories");
        MobileResultPage mobileResultPage = ebayHomePage.clickOnSearchButton();
        mobileResultPage.clickOnAppleCkeckBox();
    }

    @Test
    public void dressResultTest(){
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        EbayHomePage ebayHomePage = basePage.initApp();
        ebayHomePage.enterValueForSearchBox("tshirt");
        ebayHomePage.selectDDValue(" Clothing, Shoes & Accessories");
        ClothResultPage clothResultPage = ebayHomePage.clickOnSearchButton();
        clothResultPage.clickOnLongSleevesCheckBox();
    }
}
