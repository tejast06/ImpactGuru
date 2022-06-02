package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class StartAOldFundRaiser extends TestBase {

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

    @FindBy(css = "#otp")
    WebElement otp;



    public StartAOldFundRaiser() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    public void setNameEmailMobileNumber(String name, String emailID,String num) throws InterruptedException {
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
    public void selectCause(String cause) throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='selected-text']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='"+cause+"']")).click();
    }

    public void setBeneficiaryInformation(String nameField,String health,String hospitalName,String cityField) throws InterruptedException {
        Thread.sleep(3000);
        oldPatientName.sendKeys(nameField);
        oldHealthIssue.sendKeys(health);
        oldWhichHospital.sendKeys(hospitalName);
        oldCity.sendKeys(cityField);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@xpath='1']")).click();

    }

    public void setOtp(String otpField){
        otp.sendKeys(otpField);
    }
}
