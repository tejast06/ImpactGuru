package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {

    public StartAFundRaiser startAFundRaiser;

    @FindBy(xpath="//a[text()='Start a free fundraiser']")
    WebElement fundRaiser;

    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    public StartAFundRaiser clickOnFundRaiser() throws IOException {
        fundRaiser.click();
        return new StartAFundRaiser();
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
