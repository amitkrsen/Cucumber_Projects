package StepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/GoogleSearch.feature",glue={"StepDefinition"},
monochrome = true, plugin = {"pretty","html:target/HtmlReports/HTML_Report.html",
		"json:target/JsonReports/reports.json",
		"junit:target/JunitReports/report.xml"},
tags="@GoogleSearch")

public class TestRunner {

}
