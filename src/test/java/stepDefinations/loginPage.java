package stepDefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPage
{
    private static String title;
	private LoginPage login1=new LoginPage(DriverFactory.getDriver());
    
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException 
	{
	   DriverFactory.getDriver().get("https://www.saucedemo.com/");
	   Thread.sleep(5000);
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page()
	{
		 title=login1.getLoginPageTitle();
		   System.out.println("Login page title is : "+title);
	   
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expextedPageTitle) 
	{
		   
		   Assert.assertTrue(title.contains(expextedPageTitle));
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) throws InterruptedException 
	{
	   login1.enterUserName(username);
	   Thread.sleep(3000);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) throws InterruptedException 
	{
	  login1.enterPassword(password);
	  Thread.sleep(3000);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException 
	{
	   login1.clickOnLogin();
	   Thread.sleep(3000);
	}

	

	
}
