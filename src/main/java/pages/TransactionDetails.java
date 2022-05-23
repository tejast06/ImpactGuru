package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class TransactionDetails extends TestBase {

    @FindBy(css = "#full_name")
    WebElement fullName;

    @FindBy(css = "[id = 'email_receipt']")
    WebElement email;

    @FindBy(xpath = "//input[@id='mobile']")
    WebElement phone;

    @FindBy(css = "#city_text")
    WebElement city;

    @FindBy(css = "#campaign_is_in_yes")
    WebElement radioBtnYes;

    @FindBy(css = "#story-popup-donate-button")
    WebElement donateBtn;

    public TransactionDetails() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }


}
