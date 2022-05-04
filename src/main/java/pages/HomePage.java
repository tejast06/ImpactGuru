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

    @FindBy(xpath = "//a[text()='Browse Fundraisers']")
    WebElement browserFundRaiser;

    @FindBy(xpath = "//a[text()='How it Works']")
    WebElement howItWorks;

    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    /**
     * Created by Tejas Toley
     * This method click on fund raiser
     * @return
     * @throws IOException
     */
    public StartAFundRaiser clickOnFundRaiser() throws IOException {
        fundRaiser.click();
        return new StartAFundRaiser();
    }

    /**
     * Created by Tejas Toley
     * This method get the title of the page
     * @return
     */
    public String getTitle(){
        return driver.getTitle();
    }

    /**
     * Created by Tejas Toley
     * This method validate that 'Fund Raiser' button is display
     * @return
     */
    public boolean isFundRaiserDisplayed(){
        return fundRaiser.isDisplayed();
    }

    /**
     * Created by Tejas Toley
     * This method validate that 'Browse fund raiser' button is display
     * @return
     */
    public boolean isBrowserFundRaiserDisplayed(){
        return browserFundRaiser.isDisplayed();
    }

    /**
     * Created by Tejas Toley
     * This method validate that 'How it works' button is display
     * @return
     */
    public boolean isHowItWorksDisplayed(){
        return howItWorks.isDisplayed();
    }

    /**
     * Created by Tejas Toley
     * This method click on 'Browse Fund Riaser
     * @return
     * @throws IOException
     */
    public BrowseFundRaiser clickBrowseFundRaiser() throws IOException {
        browserFundRaiser.click();
        return new BrowseFundRaiser();
    }
}
