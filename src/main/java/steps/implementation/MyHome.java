package steps.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;

public class MyHome extends Annotations{
	
	public  MyHome() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Leads")
	WebElement eleLead;
	
	public MyLeads clickLeads()
	{
		click(eleLead);
		return new MyLeads();
	}
	
}
