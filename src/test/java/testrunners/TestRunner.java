package testrunners;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by zsuleiman on 30/01/2017.
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber.json",
        overviewReport = true,
        detailedReport = true,
        outputFolder = "./target",
        toPDF = true,
        screenShotLocation ="./target/screenshots")
@CucumberOptions(
        features="./src/main/resources/features/",
        glue={"pageobjects","testrunners","testhooks","stepdefinitions"},
        plugin={ "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "junit:target/cucumber-results.xml"},
        tags = {"~@ignore"}

)

public class TestRunner {

}
