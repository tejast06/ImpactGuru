package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    String path = System.getProperty("user.dir");

    public TestBase() throws IOException {
        prop = new Properties();

        FileInputStream file = new FileInputStream(path+"\\src\\main\\java\\config\\config.properties");
        prop.load(file);
    }

    public  static void initialization(){

        System.setProperty("webdriver.chrome.driver", " /usr/bin/chromedriver/chromedriver.exe");

//        if (prop.getProperty("browser").equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().setup();
//            driver= new ChromeDriver();
//        }
//        else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//
//        else if(prop.getProperty("browser").equalsIgnoreCase("edge")){
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        }

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
