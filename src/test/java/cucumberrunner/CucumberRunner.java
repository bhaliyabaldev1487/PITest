package cucumberrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "classpath:features",
		glue = {"stepdefinations"},
		plugin = {"pretty"}
		)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}