package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/login.feature",glue={"StepDefinition_POM"},
monochrome = true, plugin = {"pretty","html:target/HtmlReports/HTML_Report.html",
		"json:target/JsonReports/reports.json",
		"junit:target/JunitReports/report.xml"},
tags="@SmokeTest")
public class testRunner {

}
