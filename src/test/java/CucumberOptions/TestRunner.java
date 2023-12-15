package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//html, xml, json, junit, extent reports
//For extent report add plugin "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//and also add these key value pairs in newly created extent.properties file
//basefolder.name = Reports/ExtentReports
//basefolder.datetimepattern = d-MMM-YY HH-mm-ss
//extent.reporter.spark.start = true
//extent.reporter.spark.out = TestReports/spark.html
///Users/anubhavgupta/Documents/eclipse-workspace(Java)/UI_CucumberFramework/src/test/resources/extent.properties -> properties file location should be this only
@RunWith(Cucumber.class)
@CucumberOptions(features = "FeaturesFiles", glue = {
		"StepDefinitions" }, monochrome = true, tags = "@AddPlace or @DeletePlace", plugin = {
				"html:Reports/HTML_Reports/cucumber.html", "json:Reports/JSON_Reports/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunner {

}
//we can override cucumber option through terminal using these commands

//cucumber.ansi-colors.disabled=  # true or false. default: false
//cucumber.execution.dry-run=     # true or false. default: false
//cucumber.execution.limit=       # number of scenarios to execute (CLI only).
//cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
//cucumber.execution.wip=         # true or false. default: false.
//cucumber.features=              # comma separated paths to feature files. example: path/to/example.feature, path/to/other.feature
//cucumber.filter.name=           # regex. example: .*Hello.*
//cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
//cucumber.glue=                  # comma separated package names. example: com.example.glue
//cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
//cucumber.object-factory=        # object factory class name. example: com.example.MyObjectFactory
//cucumber.snippet-type=          # underscore or camelcase. default: underscore