import base.TestBase;
import listeners.CustomListeners;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BrowseFundRaiser;
import pages.HomePage;
import pages.TransactionDetails;
import testdata.TestDataImpactGuru;

import java.io.IOException;

@Listeners(CustomListeners.class)
public class FailDonation extends TestBase implements TestDataImpactGuru {

    public HomePage homePage;
    public BrowseFundRaiser browseFundRaiser;
    public TransactionDetails transactionDetails;

     Logger log = LogManager.getLogger(FailDonation.class);
     static {
         BasicConfigurator.configure();
     }

     public FailDonation() throws IOException {
        super();
    }

    @BeforeTest
    public void setUp() throws IOException {
        log.info("Launch the browser");
        initialization();
        homePage = new HomePage();
        browseFundRaiser = new BrowseFundRaiser();
     }

    @Test(priority = 1)
    public void validateSearchFunctionality() throws InterruptedException, IOException {
         log.info("Enter "+searchText+" on Search field and press enter");
        Thread.sleep(4000);
        browseFundRaiser = homePage.enterTextOnFieldAncClick(searchText);
    }

    @Test(priority = 2)
    public void failDonation() throws InterruptedException, IOException {
        log.info("Click on Donate button, enter Name:"+name+", Email:"+email+",Number:"+number+" and City:"+city+"");
        transactionDetails = browseFundRaiser.clickDonateAndEnterDetailsAndValidateDonationGetsFailed(name,email,number,city);
        Thread.sleep(2000);

    }
}
