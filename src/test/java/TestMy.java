import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestMy {

    WebDriver driver = new ChromeDriver();

    @Test
    public void bookingParisTest() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//span[contains(text(), 'Зарегистрироваться')]")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rogova@trashmail.fr");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='new_password']")).click();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("Ledovskih1");
        driver.findElement(By.xpath("//input[@id='confirmed_password']")).click();
        driver.findElement(By.xpath("//input[@id='confirmed_password']")).sendKeys("Ledovskih1");
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//iframe[5]"));
        // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[7]")));
        WebElement element = driver.findElement(By.xpath("//iframe[7]"));
        Actions make = new Actions(driver);

        make
                .clickAndHold(element)
                .build()
                .perform();

    }
}
