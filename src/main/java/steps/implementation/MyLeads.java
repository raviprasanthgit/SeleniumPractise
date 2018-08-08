package steps.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import pageobjectmodel.CreateLeadNeg;
import wdMethods.Annotations;

public class MyLeads extends Annotations{
	
	public  MyLeads() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLead;
	
	@And("Click on Create Lead link")
	public CreateLeadWithCucs clickCreateLead()
	{
		click(eleCreateLead);
		return new CreateLeadWithCucs();
	}
	
}
