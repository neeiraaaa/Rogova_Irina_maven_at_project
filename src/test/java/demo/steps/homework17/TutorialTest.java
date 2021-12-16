package demo.steps.homework17;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TutorialTest {

    WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }

    @Test
    public void tutorial() {

        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/java/");
        WebElement tutorial = driver.findElement((By.xpath("//h1/span[contains(@class, 'color_h1')]")));

        Actions make = new Actions(driver);

        make
                .doubleClick(tutorial)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyDown(Keys.LEFT_CONTROL)
                .build()
                .perform();

        driver.get("https://google.com");

        WebElement googleInput = driver.findElement((By.xpath("//input[@name='q']")));

        make
                .doubleClick(googleInput)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        Integer sizeBlocs =  driver.findElements(By.xpath("//div[@class='g']")).size();
        Integer containsTutorial =  driver.findElements(By.xpath("//div[@class='g' and contains(.,'tutorial')]")).size();

        System.out.println("Expected " + sizeBlocs);
        System.out.println("Actual words contains tutorial: " + containsTutorial);

        Assert.assertEquals(" ", sizeBlocs, containsTutorial);
    }
}
