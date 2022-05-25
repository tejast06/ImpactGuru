import base.TestBase;
import listeners.CustomListeners;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.StartANewFundRaiser;
import testdata.TestDataImpactGuru;

import java.io.IOException;

@Listeners(CustomListeners.class)
public class TestCreateFundRaiser extends TestBase implements TestDataImpactGuru {

    public TestCreateFundRaiser() throws IOException {
        super();
    }

    public HomePage homePage;
    public StartANewFundRaiser startANewFundRaiser;

    @BeforeTest
    public void setUp() throws IOException {
        initialization();
        homePage = new HomePage();
    }

    @Test
    public void createFundRaiser() throws IOException, InterruptedException {

        //step1
        startANewFundRaiser = homePage.clickFundRaiser();

        //step2
        startANewFundRaiser.selectIamRaisingFundsFor(medical);
        Thread.sleep(3000);

        //step3
        startANewFundRaiser.enterDetails(name,emailid,number);

        //step4
        startANewFundRaiser.whoAreYouRaisingFundFor(parent);

        //step5
        startANewFundRaiser.setPatientDetails(name,age,male,number,city);









    }



}
