package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class StartANewFundRaiser extends TestBase {

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




    public StartANewFundRaiser() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

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
}
