package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;

public class CreateLead extends Annotations{
	
	public  CreateLead() {
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
	
	public CreateLead typeCName(String cName)
	{
		type(eleCName,cName);
		return this;
	}
	
	public CreateLead typeFName(String fName)
	{
		type(eleFName,fName);
		return this;
	}
	
	public CreateLead typeLName(String lName)
	{
		type(eleLName,lName);
		return this;
	}
	
	public CreateLead typeFNameLocal(String fNameloc)
	{
		type(eleFNameLocal,fNameloc);
		return this;
	}
	
	public CreateLead typePhNo(String phNo)
	{
		type(elePhno,phNo);
		return this;
	}
	
	public ViewLead clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLead();
	}
	
}
