package demo.classwork19.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver extends AbstractDriver{

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getWebDriver() {
        if (null == driver) {
            driver = DriverManager.getDriver(config);
        }
        int time = 30;
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
        return driver;
    }

    public static void destroy() {
        driver.quit();
        driver = null;
    }
}
