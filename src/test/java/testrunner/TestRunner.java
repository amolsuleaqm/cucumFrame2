package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features= {"src/test/resources/AppFeatures.features/loginPage.feature"},
		glue= {"stepDefinations","appHooks"},
		
				plugin= {"pretty","json:target/MyReports/report.json",
						  "junit:target/MyReports/report.xml",	
			               "html:target/MyReports/report.html","html:target/cucumber.html","json:target/cucumber.json",
						"junit:target/cukes.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		                
		                
		)
public class TestRunner {

}
