package demo.homework17;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingMoscowTest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void before() {
        System.out.println("Start");
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }

    @Test
    public void  bookingTest() {

        driver.manage().window().maximize();
        driver.get("https://booking.com");
        driver.findElement(By.name("ss")).sendKeys("Москва");
        WebElement element = new WebDriverWait(driver, 3000).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-label='Москва, Россия']")));
        element.click();
        driver.findElement(By.xpath("//td[@data-date='2021-12-07']")).click();
        driver.findElement(By.xpath("//td[@data-date='2021-12-14']")).click();
        driver.findElement(By.xpath("//span[@data-adults-count]")).click();
        driver.findElement(By.xpath("//div[@class='sb-searchbox-submit-col -submit-button ']")).click();

        WebElement tenHotel = driver.findElement(By.xpath("//div[@id='search_results_table']//div[@data-testid='property-card'][10]"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", tenHotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenHotel);

        WebElement hotelTitle = driver.findElement(By.xpath("//div[@id='search_results_table']//div[@data-testid='property-card'][10]" +
                "//h3//div[@class='fde444d7ef _c445487e2']"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", hotelTitle);
        String colorTitle =  driver.findElement(By.xpath("//div[@id='search_results_table']//div[@data-testid='property-card'][10]" +
                "//h3//div[@class='fde444d7ef _c445487e2']")).getCssValue("color");
        System.out.println(colorTitle);

        String rgbRed = "rgba(255, 0, 0, 1)";
        Assert.assertEquals(" ", colorTitle, rgbRed);
    }
}
