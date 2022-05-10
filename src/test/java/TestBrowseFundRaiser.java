import base.TestBase;
import listeners.CustomListeners;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BrowseFundRaiser;
import pages.HomePage;
import testdata.TestDataImpactGuru;
import java.io.IOException;

@Listeners(CustomListeners.class)
public class TestBrowseFundRaiser extends TestBase implements TestDataImpactGuru {

    public HomePage homePage;
    public BrowseFundRaiser browseFundRaiser;

    public TestBrowseFundRaiser() throws IOException {
        super();
    }

    @BeforeTest
    public void setUp() throws IOException {
        initialization();
        homePage = new HomePage();
        browseFundRaiser = new BrowseFundRaiser();
    }

    @Test(priority = 1)
    public void clickOnBrowseFundRaiser() throws IOException {
        browseFundRaiser = homePage.clickBrowseFundRaiser();
    }

    @Test(priority = 2)
    public void validateBrowseFundRaiserTitle(){
        System.out.println(driver.getTitle());
        Assert.assertTrue(browseFundRaiser.getTitle().equals(browseFundTitle),"Browser Fund Raise title" +
                "page is not displayed");
    }

    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }
}
