package appHooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks 
{

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() throws FileNotFoundException
	{
		configReader=new ConfigReader();
		prop=configReader.init_prop();
		
	}
	@Before(order = 1)
	public void launchBrowser()
	{
	    String browserName=prop.getProperty("browser");
	    driverFactory=new DriverFactory();
	    driver=driverFactory.init_driver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser()
	{
		driver.quit();
	}
	@After(order = 1)
	public void tearDown(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			/*// take screenshot :
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			
			byte[]sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcePath, "image/png", screenshotName);*/
			
			TakesScreenshot tsc=(TakesScreenshot)driver;
			
			File source=tsc.getScreenshotAs(OutputType.FILE);
			
			File destination=new File("D:\\Harshit\\LatestApp\\CucumberPOMSeries\\Screenshot\\img1.png");
			
			FileHandler.copy(source, destination);
			
		}
	}
	
}
