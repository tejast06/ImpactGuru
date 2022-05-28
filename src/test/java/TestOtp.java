import base.TestBase;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestOtp extends TestBase {
    public HomePage homePage;

    public String sid = "AC31d4e73587b0f18d20cdaac96012ca8a";
    public String token = "a1221a3fac9f89fda109fe747e03e1d0";


    public TestOtp() throws IOException {
        super();
    }


    @BeforeTest
    public void setUp(){
        initialization();
    }

    @Test
    public void testOtp() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Start a free fundraiser']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("test zone");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("west@gmail.com");

       // driver.findElement(By.xpath("//select[@id='country_id']/option[text()='+1'][1]")).click();

        driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("2484505156");

        String css = ".custom-control-label";
        ((JavascriptExecutor)driver).executeScript("document.querySelector(arguments[0],':before').click();",css);

        driver.findElement(By.xpath("//button[text()='next']")).click();

        Twilio.init(sid,token);

        String msg = getMessage();
        System.out.println(msg);
        String otp = msg.replaceAll("[^-?0-9]+", " ");


    }

    public static String getMessage() {
        return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(m -> m.getTo().equals("+12484505156")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages() {
        String sid = "AC31d4e73587b0f18d20cdaac96012ca8a";
        ResourceSet<Message> messages = Message.reader(sid).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }







}
