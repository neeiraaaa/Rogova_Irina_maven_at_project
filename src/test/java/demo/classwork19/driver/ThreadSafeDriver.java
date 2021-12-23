package demo.classwork19.driver;

import org.openqa.selenium.WebDriver;

public class ThreadSafeDriver extends AbstractDriver {

    public static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    private ThreadSafeDriver() {

    }

    public static WebDriver getWebDriver() {
        if (null == driverLocal.get()) {
            driverLocal.set(DriverManager.getDriver(config));
        }
        return driverLocal.get();
    }

    public static void destroy() {
        WebDriver localDriver = driverLocal.get();
        localDriver.quit();
        driverLocal.set(null);
    }
}

