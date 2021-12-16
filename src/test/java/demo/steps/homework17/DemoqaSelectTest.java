package demo.steps.homework17;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoqaSelectTest {

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
    public void selectTest() {

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

        driver.findElement(By.id("withOptGroup")).click();
        driver.findElement(By.id("react-select-2-option-0-0")).click();
        driver.findElement(By.id("selectOne")).click();
        driver.findElement(By.id("react-select-3-option-0-0")).click();

        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(element);
        select.selectByValue("2");

        //3 select

        WebElement element1 = driver.findElement(By.id("cars"));
        Select select1 = new Select(element1);
        select1.selectByValue("opel");
    }
}
