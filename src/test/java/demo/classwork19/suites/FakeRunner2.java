package demo.classwork19.suites;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"demo.classwork19"},
        features = {"src/test/resources/fake/FakeTwo.feature"},
        strict = true
)
public class FakeRunner2 {
}
