package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class ShareDriver {
    private static AndroidDriver androidDriver;
    public static Properties prop;

    public static AndroidDriver getDriver() {
        if (androidDriver == null) {
            try {
                androidDriver = initialization();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return androidDriver;
    }

    public static AndroidDriver initialization() throws MalformedURLException {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/" + "main/resources/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
        capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
        capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
        capabilities.setCapability("noReset", prop.getProperty("noReset"));
        capabilities.setCapability("appWaitForLaunch", prop.getProperty("appWaitForLaunch"));

        return new AndroidDriver(new URL(prop.getProperty("url")), capabilities);
    }
}
