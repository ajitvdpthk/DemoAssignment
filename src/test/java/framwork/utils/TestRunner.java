package framwork.utils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@Tag"}, strict = true, monochrome = true,
        plugin = {"html:target/cucumber-reports/"},
        features = "src/test/java/featureFiles",
        glue = "stepDefinations")
public class TestRunner {

}
