package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;

public class CreateLeadNeg extends Annotations{
	
	public  CreateLeadNeg() {
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
	
	@FindBy(className="errorList")
	WebElement eleErrorMsg;
	
	public CreateLeadNeg typeCName(String cName)
	{
		type(eleCName,cName);
		return this;
	}
	
	public CreateLeadNeg typeFName(String fName)
	{
		type(eleFName,fName);
		return this;
	}
	
	public CreateLeadNeg typeLName(String lName)
	{
		type(eleLName,lName);
		return this;
	}
	
	public CreateLeadNeg typeFNameLocal(String fNameloc)
	{
		type(eleFNameLocal,fNameloc);
		return this;
	}
	
	public CreateLeadNeg typePhNo(String phNo)
	{
		type(elePhno,phNo);
		return this;
	}
	
	public CreateLeadNeg clickCreateLeadNeg()
	{
		click(eleCreateLead);
		return this;
	}

	
	public CreateLeadNeg errorMessage(String erroMsg)
	{
		verifyPartialText(eleErrorMsg, erroMsg);
		return this;
	}

	
	public ViewLead clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLead();
	}

}

