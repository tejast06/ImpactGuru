package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    String path = System.getProperty("user.dir");

    public TestBase() throws IOException {
//        prop = new Properties();

        //FileInputStream file = new FileInputStream(path+"\\src\\main\\java\\config\\config.properties");
        //prop.load(file);
    }

    public  static void initialization(){

        System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");

            //WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();



        driver.get("https://whitehat:aUV9NLtDZaVqLAjN@whitehat.impactguru.com/");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    }

    public void getFailedScreenShot(String methodName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File(path+"\\src\\main\\java\\screenshot\\"+methodName+".jpeg"));
    }
}
