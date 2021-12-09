package homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingMoscow {

    @Before
    public void before() {
        System.out.println("Start");
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }

    WebDriver driver = new ChromeDriver();

    @Test
    public void bookingMoscowTest() {
        driver.get("https://booking.com");
        driver.findElement(By.name("ss")).sendKeys("Москва");

        WebElement element = new WebDriverWait(driver, 3000).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-label='Москва, Россия']")));
        element.click();

        driver.findElement(By.xpath("//td[@data-date='2021-12-08']")).click();
        driver.findElement(By.xpath("//td[@data-date='2021-12-14']")).click();
        System.out.println("2 гостя: " + driver.findElement(By.xpath("//span[@data-adults-count]")).isDisplayed());

        WebElement element2 = new WebDriverWait(driver, 3000).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-room-count]")));
        System.out.println("1 номер:  " + element2.isDisplayed());

        driver.findElement(By.xpath("//div[@class='sb-searchbox-submit-col -submit-button ']")).click();
       System.out.println("Есть ли отели на выбранные даты: " + driver.findElement(By.xpath("//div[@class='ea52000380']")).isDisplayed());
    }
}
