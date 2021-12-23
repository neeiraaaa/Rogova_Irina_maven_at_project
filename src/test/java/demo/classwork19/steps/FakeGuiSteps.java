package demo.classwork19.steps;

import demo.classwork19.driver.Driver;
import demo.classwork19.driver.ThreadSafeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FakeGuiSteps {

    @Given(value = "I go to google.com")
    public void checkHeaderTest() {
       // Driver.getWebDriver().get("https://google.com");
        ThreadSafeDriver.getWebDriver().get("https://google.com");
    }

    @When("I start waiting")
    public void checkFooterTest() throws InterruptedException {
        Thread.sleep(1);
    }

    @Then("I just passed")
    public void verify() {
        Assert.assertTrue(true);
    }
}
