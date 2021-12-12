package homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolitpsTest {

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
    public void bookingTolipsTest () {
        driver.manage().window().maximize();
        driver.get("https://booking.com");

        WebElement element = driver.findElement(By.xpath("//button[@data-modal-aria-label='Выберите валюту']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        Assert.assertEquals("Incorrect text Tooltip Currency ","Выберите валюту" , driver.findElement(By.xpath("//div[@class= 'bui-tooltip__content']"))
                .getText());

        WebElement element2 = driver.findElement(By.xpath("//div[@class='bui-avatar bui-avatar--small']"));
        actions.moveToElement(element2);
        actions.perform();

        Assert.assertEquals("Incorrect text Tooltip Language ", "Выберите язык", driver.findElement(By.xpath("//div[@class= 'bui-tooltip__content']"))
                .getText());
    }
}
