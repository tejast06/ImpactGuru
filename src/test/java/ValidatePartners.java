import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class ValidatePartners extends TestBase {

    public HomePage homePage;


    public ValidatePartners() throws IOException {
        super();
    }

    @BeforeTest
    public void setUp() throws IOException {

        initialization();
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void validateOurPartnerIsDisplay() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(homePage.isOurPartnerDisplay());
    }


}
