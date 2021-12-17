package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"booking"},
        features = {"src/test/resources/features/Booking.feature"},
        strict = true
)

public class CukeRunnerBooking {

}

