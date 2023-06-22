package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*@CucumberOptions(plugin = { "pretty", "html:target/dsAlgoReport.html" }, // reporting purpose
		monochrome = false, // console output
		tags = "", // tags from feature file
		features = { "src/test/resources/features" }, // location of feature files
		glue = { "stepDefinition", "appHooks" }) // location of step definition files

public class TestRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}*/
@CucumberOptions(plugin = {"html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, // reporting purpose

publish=true,
monochrome = false, // console output
	
features = { "src/test/resources/features" }, // location of feature files
tags="",// tags from feature file,
glue = { "stepDefinition", "appHooks" }// location of step definition files

) // tags from feature file

public class TestRunner extends AbstractTestNGCucumberTests {
@DataProvider(parallel = false)
public Object[][] scenarios() {		
return super.scenarios();
}

}