package steps.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wdMethods.Annotations;


public class CreateLead extends Annotations{
	
	
	/*@Given("Launch the browser")
	public void browser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@And("Maximise the browser Window")
	public void maximise()
	{
		driver.manage().window().maximize();
	}
	
	@And("Load the URL")
	public void url()
	{
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
	
	@And("Wait for the implicit time")
	public void waitTime()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
*/	
	@Given("Enter the user name as (.*)")
	public CreateLead uName(String uname)
	{
		driver.findElementById("username").sendKeys(uname);
		return this;
	}
	
	@And("Enter the password as (.*)")
	public CreateLead pass(String pass)
	{
		driver.findElementById("password").sendKeys(pass);
		return this;
	}
	
	@And("click on the submit button")
	public CreateLead submitButton()
	{
		driver.findElementByClassName("decorativeSubmit").click();
		return this;
	}
	
	@And("Click on CRMSFA link")
	public CreateLead crmLink()
	{
		driver.findElementByLinkText("CRM/SFA").click();
		return this;
	}
	
/*	@And("Click on Create Lead link")
	public void createLeadLink()
	{
		driver.findElementByLinkText("Create Lead").click();
	}
	
	@And("Enter the Company name as (.*)")
	public void cName(String cName)
	{
		driver.findElementById("createLeadForm_companyName").sendKeys(cName);
	}
	
	@And("Enter the first name as (.*)")
	public void fName(String fName)
	{
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
	}
	
	@And("Enter the last name as (.*)")
	public void lName(String lName)
	{
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
	}
	
	@When("Click on submit button")
	public void createLeadSub()
	{
		driver.findElementByClassName("smallSubmit").click();
	}
*/	
	@Then("Create lead is successfully created")
	public void verify()
	{
		System.out.println("Verified the create lead");
	}
	
	@And("Close the browser")
	public void browserClose()
	{
		driver.quit();
	}
	
}
