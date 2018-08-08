package steps.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import wdMethods.Annotations;

public class CreateLeadWithCucs extends Annotations{
	
	public  CreateLeadWithCucs() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCName;
	
	@FindBy(id="createLeadForm_firstName")
	WebElement eleFName;
	
	@FindBy(id="createLeadForm_lastName")
	WebElement eleLName;
	
	@FindBy(name="firstNameLocal")
	WebElement eleFNameLocal;
	
	@FindBy(id="createLeadForm_primaryPhoneNumber")
	WebElement elePhno;
	
	@FindBy(className="smallSubmit")
	WebElement eleCreateLead;
	
	@And("Enter the Company name as (.*)")
	public CreateLeadWithCucs typeCName(String cName)
	{
		type(eleCName,cName);
		return this;
	}
	
	@And("Enter the first name as (.*)")
	public CreateLeadWithCucs typeFName(String fName)
	{
		type(eleFName,fName);
		return this;
	}
	
	@And("Enter the last name as(.*)")
	public CreateLeadWithCucs typeLName(String lName)
	{
		type(eleLName,lName);
		return this;
	}
	
	@When("Click on submit button")
	public ViewLead clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLead();
	}
	
}
