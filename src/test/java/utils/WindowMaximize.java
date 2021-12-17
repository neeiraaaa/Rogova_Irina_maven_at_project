package utils;

import driver.BasicDriver;
import org.openqa.selenium.WebDriver;

public class WindowMaximize {

    public static void windowMaximize() {
        WebDriver driver = BasicDriver.getWebDriver();
        driver.manage().window().maximize();
    }
}
