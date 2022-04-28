package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\impac\\Downloads\\ImpactGuru\\src\\main\\java\\config\\config.properties");
        prop.load(file);
    }

    public  static void initialization(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    }
}
