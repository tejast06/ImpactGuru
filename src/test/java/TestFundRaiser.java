import base.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.StartAFundRaiser;
import pages.StartAOldFundRaiser;
import testdata.TestDataImpactGuru;

import java.io.IOException;

public class TestFundRaiser extends TestBase implements TestDataImpactGuru {

    public String sid = "AC31d4e73587b0f18d20cdaac96012ca8a";
    public String token = "a1221a3fac9f89fda109fe747e03e1d0";

    public TestFundRaiser() throws IOException {
    }

    public HomePage homePage;
    public StartAFundRaiser startAFundRaiser;

    public StartAOldFundRaiser startAOldFundRaiser;

    @BeforeTest
    public void setUp() throws IOException {
        initialization();
        homePage = new HomePage();
        startAFundRaiser = new StartAFundRaiser();
    }

    @Test
    public void createFundRaiser() throws IOException, InterruptedException {


        startAFundRaiser.clickOnFundRaiser();
        String title = driver.getTitle();

        if (title.contains("Crowdfunding India | Best Crowdfunding Platform in India - Impact Guru")){
            startAFundRaiser.selectOldFlowCause(medical);
            startAFundRaiser.setOldFlowNameEmailMobileNumber(name,emailid,number);
            startAFundRaiser.setOldFlowBeneficiaryInformation(patientName,healthIssue,hospitalName,city);
        }
        else {

            //step2
        startAFundRaiser.selectIamRaisingFundsFor(medical);
        Thread.sleep(3000);

        //step3
            startAFundRaiser.enterDetails(name,emailid,number);
        Thread.sleep(3000);

        //step4
            startAFundRaiser.whoAreYouRaisingFundFor(parent);

        //step5
            startAFundRaiser.setPatientDetails(name,age,male,number,city);

        //step6
            startAFundRaiser.setCampaignDetails(disease,amt,date);

            startAFundRaiser.setHospitalizationStatus(status,hospitalName);

            startAFundRaiser.clickUnlock100More();

            startAFundRaiser.uploadDocument();

        Thread.sleep(3000);

            startAFundRaiser.clickSelectAndContinue();


        }





        //step1

//
        //startAOldFundRaiser.selectCause(medical);
//
//        startAOldFundRaiser.setNameEmailMobileNumber(name,emailid,number);
//
//        Twilio.init(sid,token);
//
//        String msg = getMessage();
//        System.out.println(msg);
//        String otp = msg.replaceAll("[^-?0-9]+", " ");
//
//        startAOldFundRaiser.setOtp(otp);

        //startAOldFundRaiser.setBeneficiaryInformation(patientName,healthIssue,hospitalName,city);


        //step2
//        startANewFundRaiser.selectIamRaisingFundsFor(medical);
//        Thread.sleep(3000);
//
//        //step3
//        startANewFundRaiser.enterDetails(name,emailid,number);
//        Thread.sleep(3000);
//
//        //step4
//        startANewFundRaiser.whoAreYouRaisingFundFor(parent);
//
//        //step5
//        startANewFundRaiser.setPatientDetails(name,age,male,number,city);
//
//        //step6
//        startANewFundRaiser.setCampaignDetails(disease,amt,date);
//
//        startANewFundRaiser.setHospitalizationStatus(status,hospitalName);
//
//        startANewFundRaiser.clickUnlock100More();
//
//        startANewFundRaiser.uploadDocument();
//
//        Thread.sleep(3000);
//
//        startANewFundRaiser.clickSelectAndContinue();

    }



}
