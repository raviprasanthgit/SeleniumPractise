package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;

public class MyLeads extends Annotations{
	
	public  MyLeads() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLead;
	
	public CreateLeadNeg clickCreateLead()
	{
		click(eleCreateLead);
		return new CreateLeadNeg();
	}
	
}
