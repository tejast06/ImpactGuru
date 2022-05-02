package testcases;

import base.TestBase;
import listeners.CustomListeners;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
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
        Assert.assertTrue(homePage.getTitle().contains(title));
        Thread.sleep(5000);

    }

    @Test(priority = 2)
    public void clickFundRaiser() throws IOException, InterruptedException {
        startAFundRaiser = homePage.clickOnFundRaiser();
        Thread.sleep(5000);

        startAFundRaiser.selectCause(cause);

        startAFundRaiser.setNameEmailMobileNumber(name,email,number);

    }


}
