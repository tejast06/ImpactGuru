package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class StartAFundRaiser extends TestBase {

    //New flow page element
    @FindBy(xpath = "//button[text()='Start A Fundraiser']")
    WebElement startAFundRaiser;

    @FindBy(css = "#fullName")
    WebElement name;

    @FindBy(css = "#email")
    WebElement email;

    @FindBy(css = "#mobile")
    WebElement mobile;

    @FindBy(xpath = "//button[text()='Get OTP']")
    WebElement otp;

    @FindBy(xpath = "//button[text()='Start a Fundraiser For Free']")
    WebElement startAFundRaiserForFree;

    @FindBy(xpath = "//button[text()='UNLOCK ₹50 MORE']")
    WebElement unlock50More;

    @FindBy(xpath = "//input[@id='benName']")
    WebElement patientName;

    @FindBy(xpath = "//input[@id='age']")
    WebElement patientAge;

    @FindBy(xpath = "//input[@name='address']")
    WebElement patientCity;

    @FindBy(css = "#benMobile")
    WebElement patientMobile;

    @FindBy(xpath = "//button[text()='UNLOCK ₹200 MORE']")
    WebElement unlock200More;

    @FindBy(xpath = "//input[@name='disease']")
    WebElement disease;

    @FindBy(xpath = "//input[@id='goal_amount']")
    WebElement goalAmt;

    @FindBy(xpath = "//input[@name='ngoYear']")
    WebElement raiseGoalAmtBy;

    @FindBy(xpath = "//input[@name='hospital']")
    WebElement hospitalName;

    @FindBy(xpath = "//button[text()='UNLOCK ₹100 MORE']")
    WebElement unlock100More;

    @FindBy(css = "#plan-8-button")
    WebElement selectAndContinue;




    //Old flow web element:
    @FindBy(xpath="//input[@name='full_name']")
    WebElement oldFullName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement oldEmail;

    @FindBy(xpath = "//input[@name='mobile']")
    WebElement oldMobileNum;

    @FindBy(xpath = "//i[@class='fas fa-sort-down']")
    WebElement OldDropDown;

    @FindBy(css = "#consentGiven")
    WebElement oldCheckBox;

    @FindBy(css = "[type='submit']")
    WebElement oldNext;

    @FindBy(css = "#beneficiary")
    WebElement oldPatientName;

    @FindBy(xpath = "//input[@name='disease']")
    WebElement oldHealthIssue;

    @FindBy(xpath = "//input[@name='hospital']")
    WebElement oldWhichHospital;

    @FindBy(xpath = "//input[@name='address']")
    WebElement oldCity;




    public StartAFundRaiser() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }


    //******************--
    /**
     * Created by Tejas Toley
     * This method select the cause from dropdown and click on Start a fund raiser button.
     * @param cause
     */
    public void selectIamRaisingFundsFor(String cause) throws InterruptedException {
        driver.findElement(By.xpath("//option[text()='"+cause+"']")).click();
        Thread.sleep(2000);
        startAFundRaiser.click();
    }

    /**
     * Created by Tejas Toley
     * This method enter the name,email and mobile and click on OTP
     * @param nameField
     * @param emailField
     * @param mobileField
     */
    public void enterDetails(String nameField,String emailField,String mobileField) throws InterruptedException {
        name.sendKeys(nameField);
        email.sendKeys(emailField);
        mobile.sendKeys(mobileField);
        otp.click();
        Thread.sleep(20000);
        startAFundRaiserForFree.click();
    }

    /**
     * Created by Tejas Toley
     * This method select the checkbox for 'Who are you raising fund for'
     * @param cause
     */
    public void whoAreYouRaisingFundFor(String cause) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='mt-3']/div[@class='radio-custom form-check']/input/following::label[text()='"+cause+"']")).click();
        Thread.sleep(2000);
        unlock50More.click();
    }

    public void setPatientDetails(String name,String age,String gender,String mobile,String city) throws InterruptedException {
        Thread.sleep(2000);
        patientName.sendKeys(name);
        patientAge.sendKeys(age);
        driver.findElement(By.xpath("//div[@class='d-flex flex-column ml-5']/select/option[text()='"+gender+"']")).click();
        patientMobile.sendKeys(mobile);
        patientCity.sendKeys(city);
        unlock200More.click();
    }

    public void setCampaignDetails(String diseaseField,String goalAmtField,String date) throws InterruptedException {
        disease.sendKeys(diseaseField);
        goalAmt.sendKeys(goalAmtField);
        raiseGoalAmtBy.sendKeys(date);
        unlock200More.click();
        Thread.sleep(3000);
    }

    public void setHospitalizationStatus(String status,String hospital){
        driver.findElement(By.xpath("//option[text()='"+status+"']")).click();
        hospitalName.sendKeys(hospital);
        unlock100More.click();
    }

    public void clickUnlock100More() throws InterruptedException {
        Thread.sleep(2000);
        unlock100More.click();
    }

    public void uploadDocument() throws InterruptedException {
        driver.findElement(By.cssSelector("#upload")).sendKeys("C:\\Users\\impac\\Desktop\\HuaweiP30 - Copy.png");
        Thread.sleep(2000);
        unlock200More.click();
    }

    public void clickSelectAndContinue() throws InterruptedException {
        selectAndContinue.click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".close-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Skip']")).click();
    }

    //********************old flow**********************

    public void setOldFlowNameEmailMobileNumber(String name, String emailID,String num) throws InterruptedException {
        oldFullName.sendKeys(name);
        oldEmail.sendKeys(emailID);
        oldMobileNum.sendKeys(num);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='country_id']/option[text()='+1'][1]")).click();

        String css = ".custom-control-label";
        ((JavascriptExecutor)driver).executeScript("document.querySelector(arguments[0],':before').click();",css);
        oldNext.click();
        Thread.sleep(3000);
    }
    public void selectOldFlowCause(String cause) throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='selected-text']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='"+cause+"']")).click();
    }

    public void setOldFlowBeneficiaryInformation(String nameField,String health,String hospitalName,String cityField) throws InterruptedException {
        Thread.sleep(3000);
        oldPatientName.sendKeys(nameField);
        oldHealthIssue.sendKeys(health);
        oldWhichHospital.sendKeys(hospitalName);
        oldCity.sendKeys(cityField);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@xpath='1']")).click();

    }

    public void clickOnFundRaiser(){
        driver.findElement(By.xpath("//a[text()='Start a free fundraiser']")).click();
    }
}
