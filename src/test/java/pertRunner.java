//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"json:reports/pet.json","html:reports/pet.html"},
        features = "Feature",
        glue = "StepDef",
        tags = "@pet"
)
public class pertRunner extends AbstractTestNGCucumberTests {
}
