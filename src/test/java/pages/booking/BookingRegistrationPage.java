package pages.booking;

import driver.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Waiter;
import utils.WindowMaximize;

public class BookingRegistrationPage {

    WebDriver driver = BasicDriver.getWebDriver();

    public static final String BOOKING_SITE = "https://booking.com";
    public static final String BUTTON_REGISTRATION = "//span[contains(text(), 'Зарегистрироваться')]";
    public static final String INPUT_REGISTRATION = "//input[@id='username']";
    public static final String BUTTON_SUBMIT = "//button[@type='submit']";
    public static final String FIRST_INPUT_PASSWORD = "//input[@id='new_password']";
    public static final String SECOND_INPUT_CONFIRMED_PASSWORD = "//input[@id='confirmed_password']";
    public static final String BUTTON_CREATE_ACCOUNT = "//button[@type= 'submit']";

    public void goToBookingMain() {
        WindowMaximize.windowMaximize();
        driver.navigate().to(BOOKING_SITE);
    }

    public void bookingRegistration() {
        driver.findElement(By.xpath(BUTTON_REGISTRATION)).click();
        driver.findElement(By.xpath(INPUT_REGISTRATION)).click();
        driver.findElement(By.xpath(INPUT_REGISTRATION)).sendKeys("rogova@trashmail.fr");
        driver.findElement(By.xpath(BUTTON_SUBMIT)).click();
        Waiter.waitForElement(FIRST_INPUT_PASSWORD);
        driver.findElement(By.xpath(FIRST_INPUT_PASSWORD)).click();
        driver.findElement(By.xpath(FIRST_INPUT_PASSWORD)).sendKeys("Ledovskih1");
        driver.findElement(By.xpath(SECOND_INPUT_CONFIRMED_PASSWORD)).click();
        driver.findElement(By.xpath(SECOND_INPUT_CONFIRMED_PASSWORD)).sendKeys("Ledovskih1");
        driver.findElement(By.xpath(BUTTON_CREATE_ACCOUNT)).click();
        WebElement element = driver.findElement(By.xpath("//iframe[7]"));
        Actions make = new Actions(driver);

        make
           .clickAndHold(element)
           .build()
           .perform();
    }

}
