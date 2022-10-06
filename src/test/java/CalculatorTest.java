import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class CalculatorTest {

    AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub/"),capabilities);
    }

    @Test
    public void testOne(){
        MobileElement[] numbers = new MobileElement[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_" + i);
        }

        HashMap<String,MobileElement> operations = new HashMap<>();
        operations.put("plus", driver.findElementById("com.android.calculator2:id/op_add"));
        //minus
        //divide
        //multiply
        //equal
        //dot
        //delete

        numbers[7].click();
        operations.get("plus").click();
        numbers[8].click();

    }

    @AfterClass
    public void end(){
        driver.quit();
    }

}
