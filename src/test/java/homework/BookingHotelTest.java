package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingHotelTest {

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
    public void bookingParisTest() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://booking.com");
        driver.findElement(By.name("ss")).sendKeys("Париж");
        WebElement element = new WebDriverWait(driver, 1000).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-label='Париж, Иль-де-Франс, Франция']")));
        element.click();

        driver.findElement(By.xpath("//td[@data-date='2021-12-12']")).click(); //7 ночей
        driver.findElement(By.xpath("//td[@data-date='2021-12-20']")).click();
        driver.findElement(By.xpath("//span[@data-adults-count]")).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Номера: увеличить количество']")).click();
        driver.findElement(By.xpath("//div[@class='sb-searchbox-submit-col -submit-button ']")).click();

        WebElement checkboxes = new WebDriverWait(driver, 5000).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='__bui-6']/ancestor::label//div[contains(text(), '+')]")));
        int expectedMaxPrice = Integer.parseInt(checkboxes.getText().replaceAll("\\D+", ""));

        checkboxes.click();
        Thread.sleep(2000);
        WebElement element2 = new WebDriverWait(driver, 5000).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Цена')]")));
        element2.click();
        Thread.sleep(2000);
        String actualMaxPriceText = driver
                .findElements(By.xpath("//div[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='price-and-discounted-price']/span"))
                .stream().reduce((x,y) -> y).get().getText();
        int actualMaxPrice = Integer.parseInt(actualMaxPriceText.replaceAll("\\D+", ""));
        System.out.println("Expected price: " + expectedMaxPrice);
        System.out.println("Actual price: " + actualMaxPrice / 7);

        Assert.assertTrue(" Expected hotel price is lower than expected!", actualMaxPrice / 7 >= expectedMaxPrice);
    }
}
