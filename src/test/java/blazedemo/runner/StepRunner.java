package blazedemo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "blazedemo.stepdefinition",
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class StepRunner {
}
