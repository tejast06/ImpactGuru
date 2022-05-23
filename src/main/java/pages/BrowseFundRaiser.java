package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class BrowseFundRaiser extends TestBase  {

    public TransactionDetails transactionDetails;

    public  String newWindow;

    @FindBy(xpath = "//a[text()=  ' DONATE']")
    WebElement donateBtn;

    public BrowseFundRaiser() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    /**
     * Created by Tejas Toley
     * This method return the title of the page
     * @return
     */
    public String getTitle(){
        return driver.getTitle();
    }

    /**
     * Created by Tejas Toley
     * This method perform fail donation scenario
     * @param name
     * @param emailId
     * @param phone
     * @param city
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public TransactionDetails clickDonateAndEnterDetails(String name,String emailId,String phone,String city) throws IOException, InterruptedException {

        donateBtn.click();
        Thread.sleep(5000);
        Set<String> wins = driver.getWindowHandles();
        String newWin;
        Iterator<String> it = wins.iterator();
        while(it.hasNext()){
            newWin = it.next();
            driver.switchTo().window(newWin);
        }


        driver.findElement(By.cssSelector("#full_name")).sendKeys(name);
        driver.findElement(By.cssSelector("[id = 'email_receipt']")).sendKeys(emailId);
        driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(phone);
        driver.findElement(By.cssSelector("#city_text")).sendKeys(city);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('campaign_is_in_yes').click();");
        driver.findElement(By.cssSelector("#story-popup-donate-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#payment-netbanking-nav")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".bank-sbi")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#donate-netbanking-contribute")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@class='content_list']/li/a")).click();
        Thread.sleep(3000);

        String failureMsg = driver.findElement(By.xpath("//span[text()='Failure. Transaction not attempted']")).getText();
        Assert.assertTrue(failureMsg.contains("Failure. Transaction not attempted"));
        return new TransactionDetails();
    }










}
