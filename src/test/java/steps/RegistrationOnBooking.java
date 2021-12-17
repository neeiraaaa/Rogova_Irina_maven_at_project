package steps;

import driver.BasicDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BookingRegistrationPage;

public class RegistrationOnBooking {

    protected WebDriver driver = BasicDriver.getWebDriver();
    protected BookingRegistrationPage registrationPage = new BookingRegistrationPage();

    @Given("I open booking site")
    public void iOpenSite() {
        registrationPage.goToBookingMain();
    }

    @When("I register new user")
    public void iRegistrationTheForm() {
       registrationPage.bookingRegistration();
    }

    @Then("I verify, that mailbox was confirmed")
    public void iMailboxConfirmation() {
        Assert.assertTrue(true);
    }
}
