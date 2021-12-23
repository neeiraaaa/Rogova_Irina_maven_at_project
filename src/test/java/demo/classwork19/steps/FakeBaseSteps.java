package demo.classwork19.steps;


import demo.classwork19.driver.Config;
import demo.classwork19.driver.Driver;
import demo.classwork19.driver.ThreadSafeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FakeBaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    @Before
    public void beforeTest() {
        LOGGER.info("Initializing WebDriver..");
       // Driver.setConfig(Config.CHROME);
        //Driver.setConfig(Config.REMOTE);
        ThreadSafeDriver.setConfig(Config.REMOTE);
    }

    @After
    public void afterTest() {
        LOGGER.info("Killing WebDriver..");
        //Driver.destroy();
        ThreadSafeDriver.destroy();
    }
}
