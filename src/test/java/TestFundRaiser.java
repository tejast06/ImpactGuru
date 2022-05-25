import base.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.StartANewFundRaiser;
import testdata.TestDataImpactGuru;

import java.io.IOException;

public class TestFundRaiser extends TestBase implements TestDataImpactGuru {

    public TestFundRaiser() throws IOException {
    }

    public HomePage homePage;
    public StartANewFundRaiser startANewFundRaiser;

    @BeforeTest
    public void setUp() throws IOException {
        initialization();
        homePage = new HomePage();
    }

    @Test(enabled = false)
    public void createFundRaiser() throws IOException, InterruptedException {

        //step1
        startANewFundRaiser = homePage.clickFundRaiser();

        //step2
        startANewFundRaiser.selectIamRaisingFundsFor(medical);
        Thread.sleep(3000);

        //step3
        startANewFundRaiser.enterDetails(name,emailid,number);
        Thread.sleep(3000);

        //step4
        startANewFundRaiser.whoAreYouRaisingFundFor(parent);

        //step5
        startANewFundRaiser.setPatientDetails(name,age,male,number,city);

        //step6
        startANewFundRaiser.setCampaignDetails(disease,amt,date);

        startANewFundRaiser.setHospitalizationStatus(status,hospitalName);

        startANewFundRaiser.clickUnlock100More();

        startANewFundRaiser.uploadDocument();


    }
}
