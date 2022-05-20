import base.TestBase;
import listeners.CustomListeners;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.StartAFundRaiser;
import testdata.TestDataImpactGuru;

import java.io.IOException;

@Listeners(CustomListeners.class)
public class TestCase1 extends TestBase implements TestDataImpactGuru {

    public HomePage homePage;
    public StartAFundRaiser startAFundRaiser;

    public TestCase1() throws IOException {
        super();
    }

    @BeforeTest
    public void setUp() throws IOException {

        initialization();
        homePage = new HomePage();
        startAFundRaiser = new StartAFundRaiser();
    }

    @Test(priority = 1)
    public void validatePageTitle() throws InterruptedException {

        String actualTitle = homePage.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void validateButtonsAreDisplayedOnHomePage(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isFundRaiserDisplayed(),"Fund Raiser button is not displayed on Home Page");
        softAssert.assertTrue(homePage.isBrowserFundRaiserDisplayed(),"Browser Fund Raiser button is not displayed" +
                "on Home Page");
        softAssert.assertTrue(homePage.isHowItWorksDisplayed(),"How it works button is not displayed on Home Page");
        softAssert.assertAll();

    }

    @Test(priority = 3)
    public void clickFundRaiser() throws IOException, InterruptedException {

        startAFundRaiser = homePage.clickOnFundRaiser();
        Thread.sleep(5000);

        startAFundRaiser.selectCause(cause);

        startAFundRaiser.setNameEmailMobileNumber(name,email,number);
    }

    @AfterTest
    public void closeTheBrowser() throws IOException {
        driver.quit();
    }
}
