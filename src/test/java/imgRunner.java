import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "Feature",
glue = "StepDef",
tags = "@img")
public class imgRunner extends AbstractTestNGCucumberTests {

}
