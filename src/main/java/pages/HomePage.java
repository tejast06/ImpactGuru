package pages;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.TestDataImpactGuru;

import java.io.IOException;

public class HomePage extends TestBase implements TestDataImpactGuru {

    public StartAOldFundRaiser startAOldFundRaiser;
    public StartAFundRaiser startANewFundRaiser;

    @FindBy(xpath="//a[text()='Start a free fundraiser']")
    WebElement fundRaiser;

    @FindBy(xpath = "//a[text()='Browse Fundraisers']")
    WebElement browserFundRaiser;

    @FindBy(xpath = "//a[text()='How it Works']")
    WebElement howItWorks;

    @FindBy(xpath="//h2[text()='Our Partners']")
    WebElement ourPartner;

    @FindBy(css = "[type='text']")
    WebElement searchField;

    @FindBy(xpath = "//button[@id='nav-search-btn']")
    WebElement searchBtn;

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
    public StartAOldFundRaiser clickOnFundRaiser() throws IOException {
        fundRaiser.click();
        return new StartAOldFundRaiser();
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

    public boolean isOurPartnerDisplay(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ourPartner);
        return ourPartner.isDisplayed();
    }

    public boolean isSearchFieldDisplayed(){
        return searchField.isDisplayed();
    }

    public BrowseFundRaiser enterTextOnFieldAncClick(String searchText) throws InterruptedException, IOException {
        searchField.sendKeys(searchText);
        Thread.sleep(2000);
        searchBtn.click();
        return new BrowseFundRaiser();
    }





}
