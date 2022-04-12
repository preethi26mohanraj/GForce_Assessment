package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                plugin ={"html:target/cucumber.html",
                        "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                features ="D:\\Projects\\GForce\\ComputerDB\\Features\\Addcomputers.feature",
                glue="stepDefinitions",
                dryRun = false
                /*,tags = "@Run3"*/

        )

public class TestRunner {
}
