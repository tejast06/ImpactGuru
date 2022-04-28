package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class StartAFundRaiser extends TestBase {

    @FindBy(xpath="//input[@name='full_name']")
    WebElement fullName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='mobile']")
    WebElement mobileNum;

    @FindBy(xpath = "//i[@class='fas fa-sort-down']")
    WebElement dropDown;

    public StartAFundRaiser() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    public void setNameEmailMobileNumber(String name, String emailID,String num){
        fullName.sendKeys(name);
        email.sendKeys(emailID);
        mobileNum.sendKeys(num);
    }



    public void selectCause(String cause) throws InterruptedException {

        driver.findElement(By.xpath("//div[text()='Medical']")).click();

        driver.findElement(By.xpath("//div[text()='"+cause+"']")).click();
    }
}
