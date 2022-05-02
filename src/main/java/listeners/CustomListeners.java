package listeners;

import base.TestBase;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {

    public CustomListeners() throws IOException {
        super();
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
        try {
            getFailedScreenShot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
